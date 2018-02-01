/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import event.management.model.AddProductBean;
import event.management.model.LoginDetails;
import event.management.service.Service;
import static event.management.web.SellController.logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author suvh
 */
@Controller
public class SaddproductController {

    static Logger logger = Logger.getLogger(SaddproductController.class);

    @Autowired
    private Service service;
    private String uname;

    @RequestMapping(value = "/Saddproduct.htm", method = RequestMethod.GET)
    public String viewForm(ModelMap model) {
        AddProductBean addProductBean = new AddProductBean();
        model.addAttribute("ProductDetails", addProductBean);
        return "Saddproduct";
    }

    @RequestMapping(value = "/Saddproduct.htm", method = RequestMethod.POST)
    public String uploadProduct(@ModelAttribute("ProductDetails") AddProductBean addProductBean, BindingResult result, ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws RuntimeException {
        File serverFile = null;
        FileInputStream fops;
        String filename = null;
        try {
            LoginDetails loginDetail = (LoginDetails) session.getAttribute("loginDetails");
            addProductBean.setUname(loginDetail.getName());
            boolean flag = false;
            MultipartFile multipartFile = null;
            String applicationPath = null;
            applicationPath = request.getSession().getServletContext().getRealPath("");
            multipartFile = addProductBean.getFiledata();
            if (!multipartFile.isEmpty()) {
                filename = multipartFile.getOriginalFilename();
                addProductBean.setFileName(multipartFile.getOriginalFilename());
            }
            if (filename != null && !filename.equals("")) {
                File dir = new File(applicationPath + "/");
                if (!dir.exists()) {
                    dir.mkdir();
                }
                serverFile = new File(dir, filename);
            }
            flag = service.addProduct(addProductBean);
            if (flag) {
                model.addAttribute("Success", "Successfully product added.");
                return "Saddproduct";
            } else {
                model.addAttribute("Success", " product add not completed successfully.");
                return "Saddproduct";
            }
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        } finally {
            if (serverFile != null) {
                serverFile.delete();
            }
        }
    }

    @RequestMapping(value = "/Product.htm")
    public String Product(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        LoginDetails loginDetail = (LoginDetails) session.getAttribute("loginDetails");
        uname = loginDetail.getName();
        try {
            List<AddProductBean> list = null;
            list = new ArrayList<AddProductBean>();
            list = service.getProduct(uname);
            model.addAttribute("Meet", list);
            return "Product";
        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

    @RequestMapping(value = "/deleteProduct.htm")
    public String deleteProductItem(@RequestParam("name") String productNm, @RequestParam("price") BigDecimal productPrice, @RequestParam("ID") String productId, ModelMap model, HttpSession session) {
        boolean flag = false;
        List<AddProductBean> list = null;
        try {
            LoginDetails loginDetail = (LoginDetails) session.getAttribute("loginDetails");
            uname = loginDetail.getName();
            flag = service.deleteProductItem(productId);
            if (flag) {
                list = new ArrayList<AddProductBean>();
                list = service.getProduct(uname);
                model.addAttribute("Meet", list);
                model.addAttribute("success", "Product item successfully deleted.");
                return "Product";
            } else {
                list = new ArrayList<AddProductBean>();
                list = service.getProduct(uname);
                model.addAttribute("Meet", list);
                model.addAttribute("success", "Product item not deleted successfully.");
                return "Product";
            }

        } catch (NullPointerException nulEx) {
            logger.info("NullPointerException in viewform:::::::::::::" + nulEx.getMessage());
            return "Error";
        } catch (RuntimeException runEx) {
            logger.info("RuntimeException in viewform:::::::::::::" + runEx.getMessage());
            return "Error";
        }
    }

}
