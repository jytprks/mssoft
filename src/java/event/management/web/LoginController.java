/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import event.management.model.LoginDetails;
import event.management.service.Service;
import event.management.validation.LoginValidation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author suvh
 */
@Controller
@RequestMapping
public class LoginController {

    static Logger logger = Logger.getLogger(LoginController.class);
    private LoginDetails loginDetails;
    @Autowired
    private Service service;
    @Autowired
    private LoginValidation loginVallidate;

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        try {
            logger.info("Enter inside viewform() method:::::::::::::");
            loginDetails = new LoginDetails();
            model.addAttribute("LoginDetails", loginDetails);
            return "Login";
        } catch (NullPointerException nulEx) {
            logger.info("exception in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("exception in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }

    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        logger.info("Enter Data Binding Method:::::::::::");
        binder.addValidators(loginVallidate);
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("LoginDetails") @Validated LoginDetails loginDetails, BindingResult result, ModelMap model, HttpSession session) throws RuntimeException {

        try {
            loginDetails = service.userAuthentication(loginDetails);
            if (loginDetails == null) {
                result.reject("error.invalid");
                return "Login";
            } else {
                session.setAttribute("LoginDetails", loginDetails);
                model.addAttribute("LoginDetails", loginDetails);
                return "redirect:/home.htm";
            }
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in processForm:::::::::::::" + nulEx.getMessage());
            result.reject("error.invalid");
            return "Login";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            result.reject("error.invalid");
            return "Login";
        }
    }

    @RequestMapping(value = "/Logout.htm")
    public String logout(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("Enter in Logout request");
            session = request.getSession(false);
            loginDetails = (LoginDetails) session.getAttribute("LoginDetails");
            if (loginDetails != null) {
                loginDetails = null;
            }
            if (session != null) {
                session.invalidate();
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-store");
                response.setHeader("Expires", "0");
                response.setDateHeader("Expires", -1);
                response.addHeader("X-Frame-Options", "SAMEORIGIN");
            }
            logger.info("Logout successfully");
            return "redirect:/home.htm";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            return "redirect:/home.htm";
        }
    }

    @RequestMapping(value = "/Forgotpass.htm", method = RequestMethod.GET)
    public String ForgatePassView(ModelMap model) {
        return "ForgotPassword";
    }

    @RequestMapping(value = "/Forgotpass.htm", method = RequestMethod.POST)
    public String getForgatePass(@RequestParam("Email") String emailId, ModelMap model) {
        boolean flag = false;
        try {
            flag = service.getEmailValidation(emailId);
            if(flag){
                
              return "ForgotPassword";
            }else{
              model.addAttribute("success", "Enter valid email.");
              return "ForgotPassword";
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
