/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author suvh
 */
@Controller
public class FoodController {
        @RequestMapping(value = "/Food.htm")
    public String viewForm(ModelMap model) {
        return "Food";
    }
}
