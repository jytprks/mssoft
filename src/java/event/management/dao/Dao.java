/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.dao;

import event.management.model.AddProductBean;
import event.management.model.Log;
import event.management.model.LoginDetails;
import event.management.model.RegistrationBean;

import java.util.List;

/**
 *
 * @author suvh
 */
public interface Dao {

    public LoginDetails userAuthentication(LoginDetails loginDetails) throws RuntimeException;

    public LoginDetails userUpdate(LoginDetails loginDetails) throws RuntimeException;

    public boolean getEmailValidation(String email) throws RuntimeException;

    public boolean getSellerEmailValidation(String email) throws RuntimeException;

    public boolean passwordUpDate(LoginDetails loginDetails, String pass) throws RuntimeException;

    public boolean RegistrationUser(RegistrationBean registration) throws RuntimeException;

    public LoginDetails sellerAuthentication(LoginDetails loginDetails) throws RuntimeException;

    public boolean sellerRegistration(RegistrationBean registration) throws RuntimeException;

    public boolean addProduct(AddProductBean addProductBean) throws RuntimeException;

    public boolean deleteProductItem(String productId) throws RuntimeException;

    public long rowCount() throws RuntimeException;

    public List<AddProductBean> getAllProduct() throws RuntimeException;

    public AddProductBean getImage(String productId) throws RuntimeException;

    public List<AddProductBean> getProduct(String uname) throws RuntimeException;

    public boolean UpdateUser(RegistrationBean regDetails, LoginDetails loginDetails) throws RuntimeException;

    public AddProductBean productDetailsById(String productId) throws RuntimeException;

    //****************************************Puja Product Details*****************************************
    public List<AddProductBean> getPujaProduct() throws RuntimeException;

    public List<AddProductBean> getPujaDecorationProduct() throws RuntimeException;

    public List<AddProductBean> getPujaLightProduct() throws RuntimeException;

    public List<AddProductBean> getPujaSoundProduct() throws RuntimeException;

    public List<AddProductBean> getPujaProgramProduct() throws RuntimeException;

    public List<AddProductBean> getPujaBadnbajaProduct() throws RuntimeException;

    public List<AddProductBean> getPujaFoodProduct() throws RuntimeException;

    //****************************************Wedding Product Details*****************************************
    public List<AddProductBean> getWeddingProduct() throws RuntimeException;

    public List<AddProductBean> getWeddingDecorationProduct() throws RuntimeException;

    public List<AddProductBean> getWeddingLightProduct() throws RuntimeException;

    public List<AddProductBean> getWeddingSoundProduct() throws RuntimeException;

    public List<AddProductBean> getWeddingLodgeProduct() throws RuntimeException;

    public List<AddProductBean> getWeddingBadnbajaProduct() throws RuntimeException;

    public List<AddProductBean> getWeddingFoodProduct() throws RuntimeException;

    //****************************************BirthDay Details*****************************************
    public List<AddProductBean> getBirthDayProduct() throws RuntimeException;

    public List<AddProductBean> getBirthDayDecorationProduct() throws RuntimeException;

    public List<AddProductBean> getBirthDayLightProduct() throws RuntimeException;

    public List<AddProductBean> getBirthDaySoundProduct() throws RuntimeException;

    public List<AddProductBean> getBirthDayCakeProduct() throws RuntimeException;

    public List<AddProductBean> getBirthDayFoodProduct() throws RuntimeException;

    //****************************************Meeting Product Details*****************************************
    public List<AddProductBean> getMeetingProduct() throws RuntimeException;

    public List<AddProductBean> getMeetingDecorationProduct() throws RuntimeException;

    public List<AddProductBean> getMeetingLightProduct() throws RuntimeException;

    public List<AddProductBean> getMeetingSoundProduct() throws RuntimeException;

    public List<AddProductBean> getMeetingLodgeProduct() throws RuntimeException;

    public List<AddProductBean> getMeetingFoodProduct() throws RuntimeException;
    
    public boolean userProductBooking(AddProductBean addProduct,LoginDetails logindet ) throws RuntimeException;
    
     public List<AddProductBean> UserBookProductDet(String emailId,String userNm)  throws RuntimeException;

}
