package com.gjh.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DownloadModAction  extends ActionSupport {
    private String contentType;
    private long contentLength;
    private InputStream inputStream;
    private String fileName;

    public String getContentType() {
        return contentType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFileName() {
        return fileName;
    }
    public String execute() throws IOException {
        contentType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        fileName="amcupload.xlsx";
        String realPath = ServletActionContext.getServletContext().getRealPath("/download/"+fileName);
        File file = new File(realPath);
        inputStream=new FileInputStream(file);
        contentLength = inputStream.available();

        return "success";
    }
}
