/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import event.management.model.LoginDetails;
import event.management.model.RegistrationBean;
import event.management.service.Service;
import event.management.validation.LoginValidation;
import event.management.validation.RegistrationValidation;
import static event.management.web.LoginController.logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author suvh
 */
@Controller
public class SellController {

    static Logger logger = Logger.getLogger(SellController.class);
    private LoginDetails loginDetails;
    @Autowired
    private Service service;
    @Autowired
    private LoginValidation loginVallidate;
    @Autowired
    private RegistrationValidation regValidate;
    private java.util.Date utilDate = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @RequestMapping(value = "/Shome.htm")
    public String viewHomeForm(ModelMap model) {
        return "Shome";
    }

    @RequestMapping(value = "/sellerlogin.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        try {
            logger.info("Enter inside viewform() method:::::::::::::");
            loginDetails = new LoginDetails();
            model.addAttribute("LoginDetails", loginDetails);
            return "Sell";
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/sellerlogin.htm", method = RequestMethod.POST)
    public String sellerLoginForm(@ModelAttribute("LoginDetails") @Validated LoginDetails loginDetails, BindingResult result, ModelMap model, HttpSession session) {

        try {
            loginVallidate.validate(loginDetails, result);
            if (result.hasErrors()) {
                return "Sell";
            } else {
                loginDetails = service.sellerAuthentication(loginDetails);
                if (loginDetails == null) {
                    result.reject("error.invalid");
                    return "Sell";
                } else {
                    session.setAttribute("loginDetails", loginDetails);
                    return "Shome";
                }
            }
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in processForm:::::::::::::" + nulEx.getMessage());
            result.reject("error.invalid");
            return "Sell";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            result.reject("error.invalid");
            return "Sell";
        }
    }

    @RequestMapping(value = "/sellerregistration.htm", method = RequestMethod.POST)
    public String sellerRegistration(@ModelAttribute("RegistrationDetails") @Validated RegistrationBean regDetails, BindingResult result, ModelMap model, HttpSession session) {
        try {
            boolean regflag = false;
            regValidate.validate(regDetails, result);
            if (result.hasErrors()) {
                return "sell";
            } else {
                String date = regDetails.getBirthDay() + "/" + regDetails.getBirthMonth() + "/" + regDetails.getBirthYear();
                utilDate = formatter.parse(date);
                regDetails.setBDate(utilDate);
                regflag = service.sellerRegistration(regDetails);
                if (regflag == true) {
                    model.addAttribute("success", "Successfully Registration completed");
                    return "Sell";
                } else {
                    result.reject("error.seller");
                    return "sell";
                }
            }
        } catch (ParseException parEx) {
            logger.info("ParseException in processForm:::::::::::::" + parEx.getMessage());
            model.addAttribute("success", "Registration not completed succseefully.Please try later");
            return "sell";
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in processForm:::::::::::::" + nulEx.getMessage());
            model.addAttribute("success", "Registration not completed succseefully.Please try later");
            return "sell";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            model.addAttribute("success", "Registration not completed succseefully.Please try later");
            return "sell";
        }
    }

    @RequestMapping(value = "/sellerLogout.htm")
    public String sellerLogout(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("Enter in Logout request");
            session = request.getSession(false);
            loginDetails = (LoginDetails) session.getAttribute("loginDetails");
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
            return "redirect:/sellerlogin.htm";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            return "redirect:/sellerlogin.htm";
        }

    }

    @RequestMapping(value = "/Sforgotpass.htm", method = RequestMethod.GET)
    public String sellerForgatePassForm(ModelMap model) {
        return "SforgotPassword";
    }

    @RequestMapping(value = "/Sforgotpass.htm", method = RequestMethod.POST)
    public String getForgatePass(@RequestParam("Email") String emailId, ModelMap model) {
        boolean flag = false;
        try {
            flag = service.getEmailValidation(emailId);
            if (flag) {

                return "SforgotPassword";
            } else {
                model.addAttribute("success", "Enter valid email.");
                return "SforgotPassword";
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
