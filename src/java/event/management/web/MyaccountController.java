/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import event.management.model.AddProductBean;
import event.management.model.LoginDetails;
import event.management.service.Service;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author suvh
 */
@Controller
public class MyaccountController {

    static Logger logger = Logger.getLogger(MyaccountController.class);
    private LoginDetails loginDetails;

    @Autowired
    private Service service;

    @RequestMapping(value = "/Myacc.htm")
    public String viewForm(ModelMap model, HttpSession session) {

        try {
            loginDetails = new LoginDetails();
            loginDetails = (LoginDetails) session.getAttribute("LoginDetails");
            model.addAttribute("registrationBean", loginDetails);
            return "Myaccount";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/updateDetails.htm")
    public String updateDetails(@ModelAttribute("registrationBean") LoginDetails loginDetails, ModelMap model) {
        try {
//            logger.info("NullPointerException in processForm:::::::::::::" + loginDetails.getPinCode());
            loginDetails = service.userUpdate(loginDetails);
            model.addAttribute("registrationBean", loginDetails);
            model.addAttribute("success", " User Details update successfully.");
            return "Myaccount";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/changepassword.htm", method = RequestMethod.GET)
    public String viewPassDetail(ModelMap model) {
        return "Cpass";
    }

    @RequestMapping(value = "/changepassword.htm", method = RequestMethod.POST)
    public String updatePassword(@RequestParam("oldpassword") String oldpass, @RequestParam("newpassword") String newpass, @RequestParam("confirmpassword") String confirmpass, ModelMap model, HttpSession session) {
        try {
            loginDetails = new LoginDetails();
            loginDetails = (LoginDetails) session.getAttribute("LoginDetails");
            String dbPass = loginDetails.getPassword();
            System.out.println("pass is>>>>>>>>>>>>" + dbPass);
            System.out.println("pass is1>>>>>>>>>>>>" + oldpass);
            if (oldpass == null ? dbPass != null : !oldpass.equals(dbPass)) {
                model.addAttribute("success", "Old Password Invalid.");
                return "Cpass";
            } else if (newpass == null ? confirmpass != null : !newpass.equals(confirmpass)) {
                model.addAttribute("success", "new password and confirm password mismatch.");
                return "Cpass";
            } else {
                boolean flag = service.passwordUpDate(loginDetails, newpass);
                if (flag) {
                    model.addAttribute("success", "password update successfully.");
                    return "Cpass";
                } else {
                    model.addAttribute("success", "password not update successfully.");
                    return "Cpass";
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

    @RequestMapping(value = "/wishlist.htm")
    public String userProductBookDetails(ModelMap model, HttpSession session) {
        List<AddProductBean> userPDet = null;

        try {
            loginDetails = new LoginDetails();
            loginDetails = (LoginDetails) session.getAttribute("LoginDetails");
            userPDet = service.UserBookProductDet(loginDetails.getEmailId(), loginDetails.getName());
            System.out.println("value is"+ userPDet);
            model.addAttribute("userPDet", userPDet);
            return "UserBookproduct";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }
}
