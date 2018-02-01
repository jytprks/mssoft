/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import event.management.model.AddProductBean;
import event.management.service.Service;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author suvh
 */
@Controller
public class HomeController {

    static Logger logger = Logger.getLogger(HomeController.class);
    @Autowired
    private Service service;
    
    @RequestMapping(value = "/home.htm")
    public String viewHome(ModelMap model) {
        try {
            logger.info("Enter inside viewHome() method:::::::::::::");
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getAllProduct();
            model.addAttribute("All", list);
            logger.info("Exit from viewHome() method:::::::::::::");
            return "Home";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewHome NullPointerException:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewHome RuntimeException:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }
}
