package com.qf.web.superadmin;

import com.qf.pojo.po.Area;
import com.qf.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/superadmin")
public class AreaController {
    Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    protected AreaService areaService;

    @RequestMapping(value = "/test111", method = RequestMethod.GET)
    public String test(){
        return "index";
    }
//
//    @RequestMapping(value = "/mainpage", method = RequestMethod.GET)
//    private String showMainPage() {
//        return "mainpage";
//    }
//
//    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
//    private String showProductDetail() {
//        return "productdetail";
//    }
//
//    @RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
//    private String showShopDetail() {
//        return "shopdetail";
//    }
//
//    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
//    private String showShopList() {
//        return "shoplist";
//    }
//
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    private String index() {
//        return "index";
//    }
//
//    @RequestMapping(value = "/mypoint", method = RequestMethod.GET)
//    private String myPoint() {
//        return "mypoint";
//    }
//
//    @RequestMapping(value = "/myrecord", method = RequestMethod.GET)
//    private String myRecord() {
//        return "myrecord";
//    }
//
//    @RequestMapping(value = "/pointrecord", method = RequestMethod.GET)
//    private String pointRecord() {
//        return "pointrecord";
//    }
//
//    @RequestMapping(value = "/awarddetail", method = RequestMethod.GET)
//    private String awardDetail() {
//        return "awarddetail";
//    }
//
//    @RequestMapping(value = "/customerbind", method = RequestMethod.GET)
//    private String customerBind() {
//        return "customerbind";
//    }


    @RequestMapping(value = "/listadmin", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
        logger.info("===start===");
        long startTime = System.currentTimeMillis();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = new ArrayList<Area>();
        try {
            list = areaService.getAreaList();
            modelMap.put("rows", list);
            modelMap.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        logger.error("test error!");
        long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}ms]" , endTime - startTime);
        logger.info("===end===");
        return modelMap;

    }
}
