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
public class BirthdayController {

    static Logger logger = Logger.getLogger(BirthdayController.class);
    @Autowired
    private Service service;

    @RequestMapping(value = "/Birthday.htm")
    public String viewForm(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingProduct();
            model.addAttribute("birthDaylist", list);
            return "Birthday";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/birthDayDecoration.htm")
    public String birthdayDecorationProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getBirthDayDecorationProduct();
            model.addAttribute("birthDaylist", list);
            return "Birthday";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/birthDayLight.htm")
    public String birthdayLightProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getBirthDayLightProduct();
            model.addAttribute("birthDaylist", list);
            return "Birthday";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/birthDaySound.htm")
    public String birthdaySoundProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getBirthDaySoundProduct();
            model.addAttribute("birthDaylist", list);
            return "Birthday";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/birthDayCake.htm")
    public String birthdayCakeProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getBirthDayCakeProduct();
            model.addAttribute("birthDaylist", list);
            return "Birthday";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/birthDayFood.htm")
    public String birthdayFoodProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getBirthDayFoodProduct();
            model.addAttribute("birthDaylist", list);
            return "Birthday";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }
}
