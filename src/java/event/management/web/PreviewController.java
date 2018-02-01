/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import event.management.model.AddProductBean;
import event.management.model.LoginDetails;
import event.management.service.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author suvh
 */
@Controller
public class PreviewController {

    static Logger logger = Logger.getLogger(PreviewController.class);
    @Autowired
    private Service service;
    private LoginDetails loginDetails;

    @RequestMapping(value = "/Preview.htm")
    public String viewForm(@RequestParam("name") String productNm, @RequestParam("price") BigDecimal productPrice, @RequestParam("ID") String productId, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            AddProductBean list = null;
            list = new AddProductBean();
            System.out.println("product is>>>>>>>>>>>" + productId);
            list = service.productDetailsById(productId);
            model.addAttribute("singleproduct", list);
            return "Preview";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/bookAction.htm", params = "addCart")
    public String addToChart(@ModelAttribute("singleproduct") AddProductBean addProduct, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            boolean flag = false;
            System.out.println("hello>>>>>>>>>>>>>>>>>>>>>>>>");
            loginDetails = (LoginDetails) session.getAttribute("LoginDetails");
            if (loginDetails == null) {
                return "redirect:/login.htm";
            } else {
                flag = service.userProductBooking(addProduct, loginDetails);
                if (flag) {
                    return "redirect:/wishlist.htm";
                } else {
                    model.addAttribute("Success", "Product booking not completed.try again");
                    return "Preview";
                }

            }
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/bookAction.htm", params = "book")
    public String addBooking(@ModelAttribute("singleproduct") AddProductBean addProduct, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            boolean flag = false;
            loginDetails = (LoginDetails) session.getAttribute("LoginDetails");
            if (loginDetails == null) {
                return "redirect:/login.htm";
            } else {
                flag = service.userProductBooking(addProduct, loginDetails);
                if (flag) {
                    model.addAttribute("Success", "Product booking completed.");
                    return "Preview";
                } else {
                    model.addAttribute("Success", "Product booking not completed.try again");
                    return "Preview";
                }

            }
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

}
