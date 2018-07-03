package com.gjh.dao;

import com.gjh.entities.Amc;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AmcDao extends BaseDao{
    @Transactional
    public List<Amc> getAmcByEndJobNumber(String endJobNumber)
    {
        String hql="From Amc a where a.endJobNumber=?";
        return getSession().createQuery(hql).setParameter(0, endJobNumber).list();

    }
    @Transactional
    public List<Amc> getAmcByEndJobNumberAndOrg(String endJobNumber,String org)
    {
        String hql="From Amc a where a.endJobNumber=? and a.org=?";
        return getSession().createQuery(hql).setParameter(0, endJobNumber).setParameter(1, org).list();

    }
    @Transactional
    public Integer deleteAmcByOrgAndEndJobNumber(String org,String endJobNumber)
    {
        Amc amc=new Amc();
        boolean flag_org=false;
        if(endJobNumber==null ||  endJobNumber.trim().equals("")==true)
        {
            //end_job_number不能为空
            amc.setEndJobNumber(endJobNumber);
            return -1;
        }
        if(org!=null && org.trim().equals("")==false)
        {
            flag_org=true;
            amc.setOrg(org);
        }
        if(flag_org)
        {
            Integer affects=getSession().createQuery("Delete From Amc a where a.endJobNumber=? and a.org=?")
                    .setParameter(0, endJobNumber).setParameter(1, org).executeUpdate();
            return affects;
        }else{
            Integer affects=getSession().createQuery("Delete From Amc a where a.endJobNumber=?")
                    .setParameter(0, endJobNumber).executeUpdate();
            return affects;
        }
    }
    @Transactional
    public Integer updateEndJobLot(String endJobLot,String endJobNumber)
    {
        return getSession()
                .createQuery("update Amc a set a.endJobLot=? where a.endJobNumber=?")
                .setParameter(0,endJobLot).setParameter(1, endJobNumber).executeUpdate();
    }
    @Transactional
    public Integer updateEndJobLotAndOrg(String endJobLot,String endJobNumber,String org)
    {
        return getSession()
                .createQuery("update Amc a set a.endJobLot=? where a.endJobNumber=? and a.org=? ")
                .setParameter(0, endJobLot).setParameter(1,endJobNumber )
                .setParameter(2,org ).executeUpdate();
    }
    @Transactional
    public void saveAmc(List<Amc> list)
    {
        for(Amc amc:list)
        {
            getSession().save(amc);
        }

    }
    @Transactional
    public int deleteAmcById(Integer id)
    {
        String hql="Delete from Amc a where a.id=?";
        return getSession().createQuery(hql).setParameter(0, id).executeUpdate();
    }
}
