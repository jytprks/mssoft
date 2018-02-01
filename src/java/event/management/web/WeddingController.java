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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class WeddingController {

    static Logger logger = Logger.getLogger(WeddingController.class);
    @Autowired
    private Service service;

    @RequestMapping(value = "/Wedding.htm")
    public String viewWeeding(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingProduct();
            model.addAttribute("wedding", list);
            return "Wedding";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/wedDecoration.htm")
    public String WeedingDecorationProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingDecorationProduct();
            model.addAttribute("wedding", list);
            return "Wedding";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/wedLight.htm")
    public String WeedingLightProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingLightProduct();
            model.addAttribute("wedding", list);
            return "Wedding";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/wedSound.htm")
    public String WeedingSoundProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingSoundProduct();
            model.addAttribute("wedding", list);
            return "Wedding";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/wedLodge.htm")
    public String WeedingLodgeProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingLodgeProduct();
            model.addAttribute("wedding", list);
            return "Wedding";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/wedBandbaja.htm")
    public String WeedingBandbajaProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingBadnbajaProduct();
            model.addAttribute("wedding", list);
            return "Wedding";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/wedFood.htm")
    public String WeedingFoodProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingFoodProduct();
            model.addAttribute("wedding", list);
            return "Wedding";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

}
