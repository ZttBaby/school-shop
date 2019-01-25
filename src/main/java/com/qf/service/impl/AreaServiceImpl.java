package com.qf.service.impl;

import com.qf.dao.AreaDao;
import com.qf.pojo.po.Area;
import com.qf.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {

        return areaDao.queryArea();
    }
}
