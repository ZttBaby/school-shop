package com.qf.service;

import com.qf.BaseTest;
import com.qf.pojo.po.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("cxx是大帅比",areaList.get(0).getAreaName());
    }
}
