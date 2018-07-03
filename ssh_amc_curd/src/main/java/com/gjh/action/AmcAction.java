package com.gjh.action;

import com.gjh.entities.Amc;
import com.gjh.service.AmcService;
import com.gjh.utils.Format;
import com.gjh.utils.GetCellValue;
import com.gjh.validate.ParseSessionObj;
import com.gjh.validate.UserMsg;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AmcAction extends ActionSupport implements ModelDriven<Amc>, Preparable {
    private Amc module;
    private AmcService service;
    private InputStream inputStream;
    private File upfile;
    private String upfileContentType;
    private String upfileFileName;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public File getUpfile() {
        return upfile;
    }

    public void setUpfile(File upfile) {
        this.upfile = upfile;
    }

    public String getUpfileContentType() {
        return upfileContentType;
    }

    public void setUpfileContentType(String upfileContentType) {
        this.upfileContentType = upfileContentType;
    }

    public String getUpfileFileName() {
        return upfileFileName;
    }

    public void setUpfileFileName(String upfileFileName) {
        this.upfileFileName = upfileFileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    @Autowired
    public void setService(AmcService service) {
        this.service = service;
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    @Override
    public Amc getModel() {
        return module;
    }
    public void prepareList() {
        module = new Amc();
    }
    public void prepareDelete() {
        module = new Amc();
    }

    public void prepareUpdate() {
        module = new Amc();
    }

    @Override
    public void prepare() throws Exception {

    }
    public String list(){
        List<Amc> amcList=new ArrayList<Amc>();
        if(module.getOrg()==null || module.getOrg().trim().equals(""))
        {
            amcList = service.getAmcByEndJobNumber(module);
        }else {
            amcList = service.getAmcByEndJobNumberAndOrg(module);
        }
        String msg="";
        if(amcList.size()==0){
           msg="你要查询的记录不存在";
        }else{
            StringBuffer buffer=new StringBuffer("");
            buffer.append("<table>" +
                    "<th>END_ITEM</th>" +
                    "<th>COMPONENT</th>" +
                    "<th>QTY_ISSUED_AVERAGE</th>" +
                    "<th>END_JOB_LOT</th>" +
                    "<th>RAW_ITEM_LOT_NUM</th>" +
                    "<th>ORG</th>" +
                    "<th>END_JOB_NUMBER</th>" +
                    "<th>level</th>" +
                    "<th>Parent_job</th>" +
                    "<th>Parent_item</th>" +
                    "<th>BOND_UNBOND</th>" +
                    "<th>Delete</th>" );
            for(Amc amc:amcList)
            {
                buffer.append("<tr>");
                buffer.append("<td>"+amc.getEndItem()+"</td>");
                buffer.append("<td>"+amc.getComponent()+"</td>");
                buffer.append("<td>"+amc.getQtyIssuedAverage()+"</td>");
                buffer.append("<td>"+amc.getEndJobLot()+"</td>");
                buffer.append("<td>"+amc.getRawItemLotNum()+"</td>");
                buffer.append("<td>"+amc.getOrg()+"</td>");
                buffer.append("<td>"+amc.getEndJobNumber()+"</td>");
                buffer.append("<td>"+amc.getLevel()+"</td>");
                buffer.append("<td>"+amc.getParentJob()+"</td>");
                buffer.append("<td>"+amc.getParentItem()+"</td>");
                buffer.append("<td>"+amc.getbONDUNBOND()+"</td>");
                buffer.append("<td>"+"<a href=doamcaction-delete?id="+amc.getId()+">Delete</a></td>");
                buffer.append("</tr>");
            }
            buffer.append("</table>");
            msg=buffer.toString();
        }

        try {
            inputStream=new ByteArrayInputStream(msg.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "list";
    }


    public String delete() {
        String msg = "";
        Integer delete_rows;
        if(id!=null)
        {
            delete_rows=service.deleteAmcById(id);
        }else{
            delete_rows = service.deleteAmcByOrgAndEndJobNumber(module);

        }
        if (delete_rows > 0) {
            msg = "共删除" + delete_rows + "行";
        } else {
            msg = "你要删除的记录不存在";
        }

        try {
            inputStream = new ByteArrayInputStream(msg.getBytes("UTF-8"));
        } catch (Exception e) {
            System.out.println("Unsupported Charactor UTF-8");
        }

        return "delete";
    }

    public String update() {
        Integer update_rows = service.updateEndJobLot(module);
        String msg = "共更新" + update_rows + "条记录";
        try {
            inputStream = new ByteArrayInputStream(msg.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Charactor UTF-8");
        }
        return "update";
    }

    public String upload() {
        handle(upfile);
        return "upload";
    }

    private void handle(File upfile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(upfile);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet1 = workbook.getSheet("Sheet1");
            if (sheet1 == null) {
                System.out.print("未找到工作表Sheet1");
            } else {
                List<Amc> list = new ArrayList<Amc>();
                int lastRowNum = sheet1.getLastRowNum();
                //从第二行开始读取数据
                if (lastRowNum == 0) {
                } else {
                    for (int i = 1; i <= lastRowNum; i++) {
                        XSSFRow row = sheet1.getRow(i);
                        String enditem = row.getCell(0).getStringCellValue();
                        enditem=Format.format(enditem);
                        String component = GetCellValue.getVale(row.getCell(1)).toString();
                        component=Format.format(component);
                        String qtyissuedaverage = GetCellValue.getVale(row.getCell(2)).toString();
                        String end_job_lot = row.getCell(3).getStringCellValue();
                        String rawitemlotnum = row.getCell(4).getStringCellValue();
                        String org = row.getCell(5).getStringCellValue();
                        String endjobnumber = row.getCell(6).getStringCellValue();
                        Double level_d = (Double) GetCellValue.getVale(row.getCell(7));
                        Integer level_i = (int) Math.round(level_d);
                        Byte level = new Byte(level_i.toString());
                        String parentjob = row.getCell(8).getStringCellValue();
                        String parentitem = row.getCell(9).getStringCellValue();
                        parentitem=Format.format(parentitem);
                        String bondunbond = row.getCell(10).getStringCellValue();
                        Amc amc = new Amc();
                        amc.setEndItem(enditem);
                        amc.setComponent(component);
                        amc.setQtyIssuedAverage(new Double(qtyissuedaverage));
                        amc.setEndJobLot(end_job_lot);
                        amc.setRawItemLotNum(rawitemlotnum);
                        amc.setOrg(org);
                        amc.setEndJobNumber(endjobnumber);
                        amc.setLevel(level);
                        amc.setParentJob(parentjob);
                        amc.setParentItem(parentitem);
                        amc.setbONDUNBOND(bondunbond);
                        UserMsg userMsg = ParseSessionObj.getUserMsg(ServletActionContext.getRequest().getSession());
                        amc.setUpdateUser(userMsg.getName());
                        list.add(amc);
                    }
                    if (list.size() != 0) {
                        Map<String, Object> request = (Map<String, Object>) (ActionContext.getContext().get("request"));
                        request.put("amc_row_num_upload", list.size());
                        service.saveAmc(list);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Excel File can't read!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
