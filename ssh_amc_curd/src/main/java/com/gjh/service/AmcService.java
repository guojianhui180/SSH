package com.gjh.service;

import com.gjh.dao.AmcDao;
import com.gjh.entities.Amc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AmcService {
    @Autowired
    private AmcDao dao;

    @Transactional
    public List<Amc> getAmcByEndJobNumber(Amc module)
    {
        return  dao.getAmcByEndJobNumber(module.getEndJobNumber());
    }
    @Transactional
    public List<Amc> getAmcByEndJobNumberAndOrg(Amc module)
    {
        return dao.getAmcByEndJobNumberAndOrg(module.getEndJobNumber(), module.getOrg());
    }
    @Transactional
    public Integer deleteAmcByOrgAndEndJobNumber(Amc module)
    {
        return dao.deleteAmcByOrgAndEndJobNumber(module.getOrg(),module.getEndJobNumber());
    }
    @Transactional
    public Integer updateEndJobLot(Amc module)
    {
        if(module.getOrg()==null || module.getOrg().trim().equals("")){
            return dao.updateEndJobLot(module.getEndJobLot(),module.getEndJobNumber() );
        }else{
            return  dao.updateEndJobLotAndOrg(module.getEndJobLot(),
                    module.getEndJobNumber(), module.getOrg());
        }

    }
    @Transactional
    public void  saveAmc(List<Amc> list)
    {
        dao.saveAmc(list);
    }
    @Transactional
    public Integer deleteAmcById(Integer id)
    {
        return dao.deleteAmcById(id);
    }

}
