package com.qf.dao;

import com.qf.pojo.po.Area;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AreaDao {
//   查询出地区列表
    List<Area> queryArea();
 }
