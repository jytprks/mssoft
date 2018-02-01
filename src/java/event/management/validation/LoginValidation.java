/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.validation;

import event.management.model.LoginDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author suvh
 */
@Component
public class LoginValidation implements Validator{

    @Override
    public boolean supports(Class<?> c) {
        return LoginDetails.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.name.empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.password.empty");
    }
    
}

