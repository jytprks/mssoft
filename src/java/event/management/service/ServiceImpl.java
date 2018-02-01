/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.service;

import event.management.dao.Dao;
import event.management.model.AddProductBean;

import event.management.model.LoginDetails;
import event.management.model.RegistrationBean;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author suvh
 */
@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {

    static Logger logger = Logger.getLogger(ServiceImpl.class);
    @Autowired
    private Dao dao;

    @Override
    public LoginDetails userAuthentication(LoginDetails loginDetails) throws RuntimeException {
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            loginDetails = dao.userAuthentication(loginDetails);
            return loginDetails;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public LoginDetails userUpdate(LoginDetails loginDetails) throws RuntimeException {
        try {
            logger.info("Enter inside Service userUpdate Method:::::::::::::::::::");
            loginDetails = dao.userUpdate(loginDetails);
            return loginDetails;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean RegistrationUser(RegistrationBean registration) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            registrationMsg = dao.RegistrationUser(registration);
            return registrationMsg;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public LoginDetails sellerAuthentication(LoginDetails loginDetails) throws RuntimeException {

        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            loginDetails = dao.sellerAuthentication(loginDetails);
            return loginDetails;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean sellerRegistration(RegistrationBean registration) throws RuntimeException {
        boolean flag = false;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            flag = dao.sellerRegistration(registration);
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }

    }

    @Override
    public boolean addProduct(AddProductBean addProductBean) throws RuntimeException {
        boolean flag = false;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            flag = dao.addProduct(addProductBean);
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public AddProductBean getImage(String productId) throws RuntimeException {
        AddProductBean addImage = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            addImage = new AddProductBean();
            addImage = dao.getImage(productId);
            return addImage;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getAllProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getAllProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getProduct(String uname) throws RuntimeException {
        {
            List<AddProductBean> list = null;
            try {
                logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
                list = new ArrayList<AddProductBean>();
                list = dao.getProduct(uname);
                return list;
            } catch (NullPointerException ex) {
                throw new NullPointerException(ex.getMessage());
            } catch (HibernateException hibex) {
                throw new HibernateException(hibex.getMessage());
            } catch (RuntimeException runEx) {
                throw new RuntimeException(runEx.getMessage());
            }
        }
    }

    @Override
    public boolean UpdateUser(RegistrationBean regDetails, LoginDetails loginDetails) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            registrationMsg = dao.UpdateUser(regDetails, loginDetails);
            return registrationMsg;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public AddProductBean productDetailsById(String productId) throws RuntimeException {
        AddProductBean list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new AddProductBean();
            list = dao.productDetailsById(productId);
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    //****************************************Puja Product Details*****************************************
    @Override
    public List<AddProductBean> getPujaProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getPujaProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getPujaDecorationProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getPujaDecorationProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getPujaLightProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getPujaLightProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getPujaSoundProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getPujaSoundProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getPujaProgramProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getPujaProgramProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getPujaBadnbajaProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getPujaBadnbajaProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getPujaFoodProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getPujaFoodProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    //****************************************Wedding Product Details*****************************************
    @Override
    public List<AddProductBean> getWeddingProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getWeddingProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getWeddingDecorationProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getWeddingDecorationProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getWeddingLightProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getWeddingLightProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getWeddingSoundProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getWeddingSoundProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getWeddingLodgeProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getWeddingLodgeProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getWeddingBadnbajaProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getWeddingBadnbajaProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getWeddingFoodProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getWeddingFoodProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    //****************************************BirthDay Details*****************************************
    @Override
    public List<AddProductBean> getBirthDayProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getBirthDayProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getBirthDayDecorationProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getBirthDayDecorationProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getBirthDayLightProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getBirthDayLightProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getBirthDaySoundProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getBirthDaySoundProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getBirthDayCakeProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getBirthDayCakeProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getBirthDayFoodProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getBirthDayFoodProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    //****************************************Meeting Product Details*****************************************
    @Override
    public List<AddProductBean> getMeetingProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getMeetingProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }

    }

    @Override
    public List<AddProductBean> getMeetingDecorationProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getMeetingDecorationProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getMeetingLightProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getMeetingLightProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getMeetingSoundProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getMeetingSoundProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getMeetingLodgeProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getMeetingLodgeProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public List<AddProductBean> getMeetingFoodProduct() throws RuntimeException {
        List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.getMeetingFoodProduct();
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean getEmailValidation(String email) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            registrationMsg = dao.getEmailValidation(email);
            return registrationMsg;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean getSellerEmailValidation(String email) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            registrationMsg = dao.getSellerEmailValidation(email);
            return registrationMsg;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean passwordUpDate(LoginDetails loginDetails, String pass) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            registrationMsg = dao.passwordUpDate(loginDetails, pass);
            return registrationMsg;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

    @Override
    public boolean deleteProductItem(String productId) throws RuntimeException {
       boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            registrationMsg = dao.deleteProductItem(productId);
            return registrationMsg;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public boolean userProductBooking(AddProductBean addProduct, LoginDetails logindet) throws RuntimeException {
        boolean registrationMsg = false;
        try {
            logger.info("Enter inside Service Method:::::::::::::::::::");
            registrationMsg = dao.userProductBooking(addProduct,logindet);
            return registrationMsg;
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<AddProductBean> UserBookProductDet(String emailId, String userNm) throws RuntimeException {
       List<AddProductBean> list = null;
        try {
            logger.info("Enter inside Service UserBookProductDet():::::::::::::::::::");
            list = new ArrayList<AddProductBean>();
            list = dao.UserBookProductDet(emailId, userNm);
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        }
    }

}
