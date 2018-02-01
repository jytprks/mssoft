/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import event.management.model.AddProductBean;
import event.management.service.Service;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author user
 */
@Controller
public class ImageController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/myImage.htm",method = RequestMethod.GET)
    public void showImage(@RequestParam("id") String productId, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        try{
        AddProductBean item = new AddProductBean();
        item = service.getImage(productId);
        System.out.println("hello>>>>>>>>>>>>>>" + item.getProductImage().length);
        byte[] image = item.getProductImage();
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(image);

        response.getOutputStream().close();
        }catch(RuntimeException ex){
        
        }

    }

}
