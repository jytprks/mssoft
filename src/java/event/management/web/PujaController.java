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
public class PujaController {

    static Logger logger = Logger.getLogger(PujaController.class);
    @Autowired
    private Service service;

    @RequestMapping(value = "/Puja.htm")
    public String PujaProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getPujaProduct();
            model.addAttribute("list", list);
            return "Puja";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/pujaDecoration.htm")
    public String PujaDecorationProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getPujaDecorationProduct();
            model.addAttribute("list", list);
            return "Puja";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/pujaLight.htm")
    public String PujaLightProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getPujaLightProduct();
            model.addAttribute("list", list);
            return "Puja";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/pujaSound.htm")
    public String PujaSoundProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getPujaSoundProduct();
            model.addAttribute("list", list);
            return "Puja";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/pujaProgram.htm")
    public String PujaProgramProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getPujaProgramProduct();
            model.addAttribute("list", list);
            return "Puja";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/pujaBandbaja.htm")
    public String PujaBandbajaProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getPujaBadnbajaProduct();
            model.addAttribute("list", list);
            return "Puja";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/pujaFood.htm")
    public String PujaFoodProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getPujaFoodProduct();
            model.addAttribute("list", list);
            return "Puja";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

}
