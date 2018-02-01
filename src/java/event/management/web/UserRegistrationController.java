/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import event.management.model.RegistrationBean;
import event.management.service.Service;
import event.management.validation.RegistrationValidation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author suvh
 */
@Controller
public class UserRegistrationController {

    static Logger logger = Logger.getLogger(UserRegistrationController.class);
    @Autowired
    private Service service;
    @Autowired
    private RegistrationValidation regValidate;
    private RegistrationBean registerBean;
    private java.util.Date utilDate = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @RequestMapping(value = "/registration.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        try {
            logger.info("Enter inside viewform() method:::::::::::::");
            registerBean = new RegistrationBean();
            model.addAttribute("RegistrationDetails", registerBean);
            return "Registration";
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
        binder.addValidators(regValidate);
    }

    @RequestMapping(value = "/registration.htm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("RegistrationDetails") @Validated RegistrationBean regDetails, BindingResult result, ModelMap model, HttpSession session) throws RuntimeException {
        boolean flag = false;
        try {
            if (result.hasErrors()) {
                return "Registration";
            } else {
                String date = regDetails.getBirthDay() + "/" + regDetails.getBirthMonth() + "/" + regDetails.getBirthYear();
                utilDate = formatter.parse(date);
                regDetails.setBDate(utilDate);
                flag = service.RegistrationUser(regDetails);
                if (flag == false) {
                    result.reject("error.invalid");
                    return "Registration";
                } else {
                    model.addAttribute("success", "Successfully registration complated.");
                    return "Registration";
                }
            }
        } catch (ParseException parEx) {
            logger.info("ParseException in processForm:::::::::::::" + parEx.getMessage());
            model.addAttribute("success", "Registration not completed succseefully.Please try later");
            return "Registration";
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in processForm:::::::::::::" + nulEx.getMessage());
            model.addAttribute("success", "Registration not completed succseefully.Please try later");
            return "Registration";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in processForm:::::::::::::" + runEx.getMessage());
            model.addAttribute("success", "Registration not completed succseefully.Please try later");
            return "Registration";
        }

    }

}
