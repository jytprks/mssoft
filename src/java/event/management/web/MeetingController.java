///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
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
public class MeetingController {

    static Logger logger = Logger.getLogger(MeetingController.class);
    @Autowired
    private Service service;

    @RequestMapping(value = "/Meeting.htm")
    public String viewForm(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getWeddingProduct();
            model.addAttribute("meetingList", list);
            return "Meeting";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/meetingDecoration.htm")
    public String meetingDecorationProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getMeetingDecorationProduct();
            model.addAttribute("meetingList", list);
            return "Meeting";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/meetingLight.htm")
    public String meetingLightProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getMeetingLightProduct();
            model.addAttribute("meetingList", list);
            return "Meeting";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/meetingSound.htm")
    public String meetingSoundProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getMeetingSoundProduct();
            model.addAttribute("meetingList", list);
            return "Meeting";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/meetingFood.htm")
    public String meetingFoodProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getMeetingFoodProduct();
            model.addAttribute("meetingList", list);
            return "Meeting";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/meetingLodge.htm")
    public String meetingLodgeProduct(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getMeetingLodgeProduct();
            model.addAttribute("meetingList", list);
            return "Meeting";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }
}
