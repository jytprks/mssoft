/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.dao;

import event.management.model.AddProductBean;
import event.management.model.LoginDetails;
import event.management.model.RegistrationBean;
import event.management.persistance.ProductDetails;
import event.management.persistance.RegistrationUser;
import event.management.persistance.RegistrationUserId;
import event.management.persistance.SellerDetails;
import event.management.persistance.SellerDetailsId;
import event.management.persistance.UserProductDetails;
import event.management.persistance.UserProductDetailsId;
import event.management.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author suvh
 */
@Repository("dao")
public class DaoImpl implements Dao {

    static Logger logger = Logger.getLogger(DaoImpl.class);
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//    private String typ;

    @Override
    public LoginDetails userAuthentication(LoginDetails loginDetails) throws RuntimeException {
        Session session = null;

        try {
            logger.info("Enter inside Service sellerRegistration():::::::::::::::::::");
            session = sessionFactory.openSession();
            Criteria loginCriteria = session.createCriteria(RegistrationUser.class);
            loginCriteria.add(Restrictions.eq("id.userName", loginDetails.getName()));
            loginCriteria.add(Restrictions.eq("userPassword", loginDetails.getPassword()));
            if (loginCriteria.list().size() > 0 && !loginCriteria.list().equals("")) {
                loginDetails = null;
                Iterator it = loginCriteria.list().iterator();
                while (it.hasNext()) {
                    RegistrationUser regUser = (RegistrationUser) it.next();
                    loginDetails = new LoginDetails();
                    loginDetails.setFristName(regUser.getFristName());
                    loginDetails.setLastName(regUser.getLastName());
                    loginDetails.setName(regUser.getId().getUserName());
                    loginDetails.setAddress(regUser.getAddress());
                    loginDetails.setPinCode(regUser.getPinCode());
                    loginDetails.setMobileNo(regUser.getMobileNo());
                    loginDetails.setEmailId(regUser.getId().getEmailId());
                    loginDetails.setPassword(regUser.getUserPassword());
                }
            } else {
                loginDetails = null;
            }
            return loginDetails;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public LoginDetails userUpdate(LoginDetails loginDetails) throws RuntimeException {
        boolean registrationMsg = false;
        Session session = null;
        Transaction transaction = null;
        String upDateQry = "update RegistrationUser regUsr set regUsr.fristName=:fname,regUsr.lastName=:lname,regUsr.address=:addr,"
                + "regUsr.pinCode=:pin,regUsr.mobileNo=:mob where regUsr.id.emailId=:email and regUsr.id.userName=:uname ";
        try {
            logger.info("Enter Dao  userUpdate():::::::::::::::::::");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(upDateQry);
            query.setParameter("fname", loginDetails.getFristName());
            query.setParameter("lname", loginDetails.getLastName());
            query.setParameter("addr", loginDetails.getAddress());
            query.setParameter("pin", loginDetails.getPinCode());
            query.setParameter("mob", loginDetails.getMobileNo());
            query.setParameter("email", loginDetails.getEmailId());
            query.setParameter("uname", loginDetails.getName());
            int count = query.executeUpdate();
            if (count > 0) {
                transaction.commit();
            }
            Criteria loginCriteria = session.createCriteria(RegistrationUser.class);
            loginCriteria.add(Restrictions.eq("id.userName", loginDetails.getName()));
            loginCriteria.add(Restrictions.eq("id.emailId", loginDetails.getEmailId()));
            if (loginCriteria.list().size() > 0 && !loginCriteria.list().equals("")) {
                loginDetails = null;
                Iterator it = loginCriteria.list().iterator();
                while (it.hasNext()) {
                    //loginDetails=new LoginDetails();
                    RegistrationUser regUser = (RegistrationUser) it.next();
                    loginDetails = new LoginDetails();
                    loginDetails.setFristName(regUser.getFristName());
                    loginDetails.setLastName(regUser.getLastName());
                    loginDetails.setName(regUser.getId().getUserName());
                    loginDetails.setAddress(regUser.getAddress());
                    loginDetails.setPinCode(regUser.getPinCode());
                    loginDetails.setMobileNo(regUser.getMobileNo());
                    loginDetails.setEmailId(regUser.getId().getEmailId());
                }
            } else {
                loginDetails = null;
            }
            return loginDetails;

        } catch (NullPointerException nullex) {
            throw new RuntimeException(nullex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean RegistrationUser(RegistrationBean registration) throws RuntimeException {
        boolean registrationMsg = false;
        Session session = null;
        Transaction transaction = null;
        try {
            logger.info("Enter Dao  RegistrationUser():::::::::::::::::::");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            RegistrationUserId regId = new RegistrationUserId();
            RegistrationUser regUsr = new RegistrationUser();
            regId.setEmailId(registration.getEmail());
            regId.setUserName(registration.getUsername());
            regUsr.setFristName(registration.getFname());
            regUsr.setLastName(registration.getLname());
            regUsr.setUserPassword(registration.getPassword());
            regUsr.setBirthDay(registration.getBDate());
            regUsr.setAddress(registration.getAddress());
            regUsr.setGender(registration.getGender());
            regUsr.setPinCode(registration.getPin());
            regUsr.setMobileNo(registration.getPhone());
            regUsr.setLogDt(new Date());
            regUsr.setId(regId);
            session.save(regUsr);
            transaction.commit();
            registrationMsg = true;
        } catch (NullPointerException nullex) {
            throw new RuntimeException(nullex.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return registrationMsg;
    }

    @Override
    public LoginDetails sellerAuthentication(LoginDetails loginDetails) throws RuntimeException {
        Session session = null;
        try {
            logger.info("Enter inside DAO sellerAuthentication():::::::::::::::::::");
            session = sessionFactory.openSession();
            Criteria loginCriteria = session.createCriteria(SellerDetails.class);
            loginCriteria.add(Restrictions.eq("id.userName", loginDetails.getName()));
            loginCriteria.add(Restrictions.eq("userPassword", loginDetails.getPassword()));
            if (loginCriteria.list().size() > 0 && !loginCriteria.list().equals("")) {
                loginDetails = null;
                Iterator it = loginCriteria.list().iterator();
                while (it.hasNext()) {
                    SellerDetails regUser = (SellerDetails) it.next();
                    loginDetails = new LoginDetails();
                    loginDetails.setFristName(regUser.getFristName());
                    loginDetails.setLastName(regUser.getLastName());
                    loginDetails.setName(regUser.getId().getUserName());
                }
            } else {
                loginDetails = null;
            }
            return loginDetails;

        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean sellerRegistration(RegistrationBean registration) throws RuntimeException {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        try {
            logger.info("Enter inside DAO sellerRegistration() method::::::::::::::");
            logger.info("Create session object:::::::::::::::");
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            SellerDetailsId sellerId = new SellerDetailsId();
            SellerDetails sellerDet = new SellerDetails();
            sellerId.setEmailId(registration.getEmail());
            sellerId.setUserName(registration.getUsername());
            sellerDet.setFristName(registration.getFname());
            sellerDet.setLastName(registration.getLname());
            sellerDet.setAddress(registration.getAddress());
            sellerDet.setBirthDay(new Date());
            sellerDet.setGender(registration.getGender());
            sellerDet.setMobileNo(registration.getPhone());
            sellerDet.setPinCode(registration.getPin());
            sellerDet.setUserPassword(registration.getPassword());
            sellerDet.setLogDt(new Date());
            sellerDet.setId(sellerId);
            session.save(sellerDet);
            transaction.commit();
            flag = true;
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean addProduct(AddProductBean addProductBean) throws RuntimeException {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        long productId = this.rowCount();
        productId = productId + 1;
        Long lObj = new Long(productId);
        try {
            logger.info("Enter inside DAO sellerRegistration() method::::::::::::::");
            logger.info("Create session object:::::::::::::::" + productId);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            // Blob blob=Hibernate.createBlob();
//            typ = addProductBean.getType();
            ProductDetails pDetails = new ProductDetails();
            pDetails.setProductId(lObj.toString());
            pDetails.setProductName(addProductBean.getProductName());
            pDetails.setProductType(addProductBean.getType());
            pDetails.setImageName(addProductBean.getFileName());
            pDetails.setProductImage(addProductBean.getFiledata().getBytes());
            System.out.println("lenght is>>>>>>>>>>>>" + addProductBean.getFiledata().getBytes().length);
            pDetails.setProductPrice(addProductBean.getPrice());
            pDetails.setProductDesc(addProductBean.getDescription());
            pDetails.setSellername(addProductBean.getUname());
            session.save(pDetails);
            transaction.commit();
            flag = true;

        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return flag;
    }

    @Override
    public AddProductBean getImage(String productId) throws RuntimeException {
        Session session = null;
        AddProductBean addImage = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productId", productId));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    addImage = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    addImage.setProductImage(pp.getProductImage());
                }
            }
            return addImage;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            runEx.printStackTrace();
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public long rowCount() throws RuntimeException {
        Session session = null;
        long count = 0;
        try {
            session = sessionFactory.openSession();
            //String qry = "select count(productId) from ProductDetails ";
            //  Query query = session.createQuery(qry);
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.setProjection(Projections.rowCount());
            //List list=
            //criteria.s
            if (criteria.list().size() > 0) {
                count = (Long) criteria.list().get(0);
            }
            return count;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<AddProductBean> getAllProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> Meeting = null;
        Meeting = new ArrayList<AddProductBean>();

        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.setMaxResults(10);
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean m = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    m.setProductId(meeting.getProductId());
                    m.setProductName(meeting.getProductName());
                    m.setPrice(meeting.getProductPrice());
                    Meeting.add(m);
                }

            }
            return Meeting;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getProduct(String uname) throws RuntimeException {
        Session session = null;
        List<AddProductBean> Meeting = null;
        Meeting = new ArrayList<AddProductBean>();

        try {
            session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("sellername", uname));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean m = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    m.setProductId(meeting.getProductId());
                    m.setProductName(meeting.getProductName());
                    m.setPrice(meeting.getProductPrice());
                    Meeting.add(m);
                }

            }
            return Meeting;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean UpdateUser(RegistrationBean regDetails, LoginDetails loginDetails) throws RuntimeException {
        boolean registrationMsg = false;
        Session session = null;
        Transaction transaction = null;
        try {
            logger.info("Enter inside Service RegistrationUser():::::::::::::::::::");
            session = sessionFactory.openSession();
            if (loginDetails != null) {
                String hql = "UPDATE REGISTRATION_USER set EMAIL_ID = :mail "
                        + "WHERE USER_NAME = :uname";
                Query query = session.createQuery(hql);
                query.setParameter("uname", loginDetails.getName());
                query.setParameter("EMAIL_ID", regDetails.getEmail());
                int result = query.executeUpdate();
                transaction.commit();
                registrationMsg = true;
            } else {
                registrationMsg = false;
            }
            return registrationMsg;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public AddProductBean productDetailsById(String productId) throws RuntimeException {
        Session session = null;
        AddProductBean addp = null;
        addp = new AddProductBean();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            // criteria.add(Restrictions.i)
            // criteria.add(Restrictions.in("productType",));
            criteria.add(Restrictions.eq("productId", productId));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    // AddProductBean addp = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    addp.setProductId(pp.getProductId());
                    addp.setProductName(pp.getProductName());
                    addp.setPrice(pp.getProductPrice());

                }
            }
            return addp;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //****************************************Puja Product Details*****************************************  
    @Override
    public List<AddProductBean> getPujaProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> list = null;
        list = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean pujaProBean = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    pujaProBean.setProductId(pp.getProductId());
                    pujaProBean.setProductName(pp.getProductName());
                    pujaProBean.setPrice(pp.getProductPrice());
                    list.add(pujaProBean);
                }
            }
            return list;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<AddProductBean> getPujaDecorationProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> pujaDecor = null;
        pujaDecor = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "D"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean pujaProBean = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    pujaProBean.setProductId(pp.getProductId());
                    pujaProBean.setProductName(pp.getProductName());
                    pujaProBean.setPrice(pp.getProductPrice());
                    pujaDecor.add(pujaProBean);
                }
            }
            return pujaDecor;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getPujaLightProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> pujaLight = null;
        pujaLight = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "LG"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean pujaProBean = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    pujaProBean.setProductId(pp.getProductId());
                    pujaProBean.setProductName(pp.getProductName());
                    pujaProBean.setPrice(pp.getProductPrice());
                    pujaLight.add(pujaProBean);
                }
            }
            return pujaLight;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getPujaSoundProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> pujaSound = null;
        pujaSound = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "S"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean pujaProBean = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    pujaProBean.setProductId(pp.getProductId());
                    pujaProBean.setProductName(pp.getProductName());
                    pujaProBean.setPrice(pp.getProductPrice());
                    pujaSound.add(pujaProBean);
                }
            }
            return pujaSound;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getPujaProgramProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> pujaProg = null;
        pujaProg = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "P"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean pujaProBean = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    pujaProBean.setProductId(pp.getProductId());
                    pujaProBean.setProductName(pp.getProductName());
                    pujaProBean.setPrice(pp.getProductPrice());
                    pujaProg.add(pujaProBean);
                }
            }
            return pujaProg;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getPujaBadnbajaProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> pujaBandBaja = null;
        pujaBandBaja = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "B"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean pujaProBean = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    pujaProBean.setProductId(pp.getProductId());
                    pujaProBean.setProductName(pp.getProductName());
                    pujaProBean.setPrice(pp.getProductPrice());
                    pujaBandBaja.add(pujaProBean);
                }
            }
            return pujaBandBaja;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getPujaFoodProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> pujaFood = null;
        pujaFood = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "F"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean pujaProBean = new AddProductBean();
                    ProductDetails pp = (ProductDetails) iterator.next();
                    pujaProBean.setProductId(pp.getProductId());
                    pujaProBean.setProductName(pp.getProductName());
                    pujaProBean.setPrice(pp.getProductPrice());
                    pujaFood.add(pujaProBean);
                }
            }
            return pujaFood;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //****************************************Wedding Product Details*****************************************
    @Override
    public List<AddProductBean> getWeddingProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> wedding = null;
        wedding = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean wedProBean = new AddProductBean();
                    ProductDetails wed = (ProductDetails) iterator.next();
                    wedProBean.setProductId(wed.getProductId());
                    wedProBean.setProductName(wed.getProductName());
                    wedProBean.setPrice(wed.getProductPrice());
                    wedding.add(wedProBean);
                }
            }
            return wedding;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<AddProductBean> getWeddingDecorationProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> weddingDecor = null;
        weddingDecor = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "D"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean wedProBean = new AddProductBean();
                    ProductDetails wed = (ProductDetails) iterator.next();
                    wedProBean.setProductId(wed.getProductId());
                    wedProBean.setProductName(wed.getProductName());
                    wedProBean.setPrice(wed.getProductPrice());
                    weddingDecor.add(wedProBean);
                }
            }
            return weddingDecor;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getWeddingLightProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> weddingLight = null;
        weddingLight = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "LG"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean wedProBean = new AddProductBean();
                    ProductDetails wed = (ProductDetails) iterator.next();
                    wedProBean.setProductId(wed.getProductId());
                    wedProBean.setProductName(wed.getProductName());
                    wedProBean.setPrice(wed.getProductPrice());
                    weddingLight.add(wedProBean);
                }
            }
            return weddingLight;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getWeddingSoundProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> weddingSound = null;
        weddingSound = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "S"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean wedProBean = new AddProductBean();
                    ProductDetails wed = (ProductDetails) iterator.next();
                    wedProBean.setProductId(wed.getProductId());
                    wedProBean.setProductName(wed.getProductName());
                    wedProBean.setPrice(wed.getProductPrice());
                    weddingSound.add(wedProBean);
                }
            }
            return weddingSound;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getWeddingLodgeProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> weddingLodge = null;
        weddingLodge = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "LD"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean wedProBean = new AddProductBean();
                    ProductDetails wed = (ProductDetails) iterator.next();
                    wedProBean.setProductId(wed.getProductId());
                    wedProBean.setProductName(wed.getProductName());
                    wedProBean.setPrice(wed.getProductPrice());
                    weddingLodge.add(wedProBean);
                }
            }
            return weddingLodge;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getWeddingBadnbajaProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> weddingBandBaja = null;
        weddingBandBaja = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "B"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean wedProBean = new AddProductBean();
                    ProductDetails wed = (ProductDetails) iterator.next();
                    wedProBean.setProductId(wed.getProductId());
                    wedProBean.setProductName(wed.getProductName());
                    wedProBean.setPrice(wed.getProductPrice());
                    weddingBandBaja.add(wedProBean);
                }
            }
            return weddingBandBaja;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getWeddingFoodProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> weddingFood = null;
        weddingFood = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "F"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean wedProBean = new AddProductBean();
                    ProductDetails wed = (ProductDetails) iterator.next();
                    wedProBean.setProductId(wed.getProductId());
                    wedProBean.setProductName(wed.getProductName());
                    wedProBean.setPrice(wed.getProductPrice());
                    weddingFood.add(wedProBean);
                }
            }
            return weddingFood;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //****************************************BirthDay Product Details*****************************************
    @Override
    public List<AddProductBean> getBirthDayProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> birthDay = null;
        birthDay = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
//            criteria.add(Restrictions.eq("productType", "D"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean birthProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    birthProBean.setProductId(meeting.getProductId());
                    birthProBean.setProductName(meeting.getProductName());
                    birthProBean.setPrice(meeting.getProductPrice());
                    birthDay.add(birthProBean);
                }
            }
            return birthDay;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getBirthDayDecorationProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> birthDayDecor = null;
        birthDayDecor = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "D"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean birthProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    birthProBean.setProductId(meeting.getProductId());
                    birthProBean.setProductName(meeting.getProductName());
                    birthProBean.setPrice(meeting.getProductPrice());
                    birthDayDecor.add(birthProBean);
                }
            }
            return birthDayDecor;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getBirthDayLightProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> birthDayLight = null;
        birthDayLight = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "LG"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean birthProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    birthProBean.setProductId(meeting.getProductId());
                    birthProBean.setProductName(meeting.getProductName());
                    birthProBean.setPrice(meeting.getProductPrice());
                    birthDayLight.add(birthProBean);
                }
            }
            return birthDayLight;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getBirthDaySoundProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> birthDaySound = null;
        birthDaySound = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "S"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean birthProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    birthProBean.setProductId(meeting.getProductId());
                    birthProBean.setProductName(meeting.getProductName());
                    birthProBean.setPrice(meeting.getProductPrice());
                    birthDaySound.add(birthProBean);
                }
            }
            return birthDaySound;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getBirthDayCakeProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> birthDayCake = null;
        birthDayCake = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "C"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean birthProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    birthProBean.setProductId(meeting.getProductId());
                    birthProBean.setProductName(meeting.getProductName());
                    birthProBean.setPrice(meeting.getProductPrice());
                    birthDayCake.add(birthProBean);
                }
            }
            return birthDayCake;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> getBirthDayFoodProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> birthDayFood = null;
        birthDayFood = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "F"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean birthProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    birthProBean.setProductId(meeting.getProductId());
                    birthProBean.setProductName(meeting.getProductName());
                    birthProBean.setPrice(meeting.getProductPrice());
                    birthDayFood.add(birthProBean);
                }
            }
            return birthDayFood;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //****************************************Meeting Product Details*****************************************
    @Override
    public List<AddProductBean> getMeetingProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> Meeting = null;
        Meeting = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "D"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean meetProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    meetProBean.setProductId(meeting.getProductId());
                    meetProBean.setProductName(meeting.getProductName());
                    meetProBean.setPrice(meeting.getProductPrice());
                    Meeting.add(meetProBean);
                }
            }
            return Meeting;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<AddProductBean> getMeetingDecorationProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> MeetingDecor = null;
        MeetingDecor = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "D"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean meetProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    meetProBean.setProductId(meeting.getProductId());
                    meetProBean.setProductName(meeting.getProductName());
                    meetProBean.setPrice(meeting.getProductPrice());
                    MeetingDecor.add(meetProBean);
                }

            }
            return MeetingDecor;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<AddProductBean> getMeetingLightProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> MeetingLight = null;
        MeetingLight = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "LG"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean meetProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    meetProBean.setProductId(meeting.getProductId());
                    meetProBean.setProductName(meeting.getProductName());
                    meetProBean.setPrice(meeting.getProductPrice());
                    MeetingLight.add(meetProBean);
                }

            }
            return MeetingLight;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<AddProductBean> getMeetingSoundProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> MeetingSound = null;
        MeetingSound = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "S"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean meetProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    meetProBean.setProductId(meeting.getProductId());
                    meetProBean.setProductName(meeting.getProductName());
                    meetProBean.setPrice(meeting.getProductPrice());
                    MeetingSound.add(meetProBean);
                }

            }
            return MeetingSound;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<AddProductBean> getMeetingLodgeProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> MeetingLodge = null;
        MeetingLodge = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "LD"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean meetProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    meetProBean.setProductId(meeting.getProductId());
                    meetProBean.setProductName(meeting.getProductName());
                    meetProBean.setPrice(meeting.getProductPrice());
                    MeetingLodge.add(meetProBean);
                }

            }
            return MeetingLodge;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<AddProductBean> getMeetingFoodProduct() throws RuntimeException {
        Session session = null;
        List<AddProductBean> MeetingFood = null;
        MeetingFood = new ArrayList<AddProductBean>();
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(ProductDetails.class);
            criteria.add(Restrictions.eq("productType", "F"));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while (iterator.hasNext()) {
                    AddProductBean meetProBean = new AddProductBean();
                    ProductDetails meeting = (ProductDetails) iterator.next();
                    meetProBean.setProductId(meeting.getProductId());
                    meetProBean.setProductName(meeting.getProductName());
                    meetProBean.setPrice(meeting.getProductPrice());
                    MeetingFood.add(meetProBean);
                }
            }
            return MeetingFood;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public boolean getEmailValidation(String email) throws RuntimeException {
        Session session = null;
        boolean flag = false;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(RegistrationUser.class);
            criteria.add(Restrictions.eq("id.emailId", email));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                flag = true;
            }
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean passwordUpDate(LoginDetails loginDetails, String pass) throws RuntimeException {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        int count = 0;
        String upDatePass = "update RegistrationUser regUsr set regUsr.userPassword=:passwd where regUsr.id.emailId=:email and regUsr.id.userName=:uname ";
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(upDatePass);
            query.setParameter("passwd", pass);
            query.setParameter("email", loginDetails.getEmailId());
            query.setParameter("uname", loginDetails.getName());
            count = query.executeUpdate();
            if (count > 0) {
                flag = true;
            }
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean getSellerEmailValidation(String email) throws RuntimeException {
        Session session = null;
        boolean flag = false;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(SellerDetails.class);
            criteria.add(Restrictions.eq("id.emailId", email));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                flag = true;
            }
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean deleteProductItem(String productId) throws RuntimeException {
        Session session = null;
        boolean flag = false;
        Transaction transaction = null;
        String delProdutQry = " delete from ProductDetails prodtDet where prodtDet.productId=:productId";
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(delProdutQry);
            query.setParameter("productId", productId);
            int count = query.executeUpdate();
            if (count > 0) {
                transaction.commit();
                flag = true;
            }
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean userProductBooking(AddProductBean addProduct, LoginDetails logindet) throws RuntimeException {
        Session session = null;
        boolean flag = false;
        Transaction transaction = null;
        System.out.println("hello}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}"+addProduct.getProductId());
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            UserProductDetails userProd = new UserProductDetails();
            UserProductDetailsId userProdId = new UserProductDetailsId();
            userProdId.setUserName(logindet.getName());
            userProdId.setUserEmail(logindet.getEmailId());
            userProdId.setProductId(addProduct.getProductId());
            userProd.setProductName(addProduct.getProductName());
            userProd.setProductPrice(addProduct.getPrice());
            userProd.setStatus("N");
            userProd.setBookDt(new Date());
            userProd.setId(userProdId);
            session.save(userProd);
            transaction.commit();
            flag = true;
            return flag;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<AddProductBean> UserBookProductDet(String emailId, String userNm) throws RuntimeException {
        Session session = null;
        List<AddProductBean> userPDet = null;
        try {
            userPDet=new ArrayList<AddProductBean>();
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(UserProductDetails.class);
            criteria.add(Restrictions.eq("id.userName", userNm));
            criteria.add(Restrictions.eq("id.userEmail", emailId));
            if (criteria.list().size() > 0 && !criteria.list().equals("")) {
                Iterator iterator = criteria.list().iterator();
                while(iterator.hasNext()){
                   AddProductBean prodBook=new AddProductBean();
                   UserProductDetails usrPDet=(UserProductDetails)iterator.next();
                   prodBook.setProductName(usrPDet.getProductName());
                   prodBook.setProductId(usrPDet.getId().getProductId());
                   prodBook.setPrice(usrPDet.getProductPrice());                   
                   userPDet.add(prodBook);
                }
            }
            return userPDet;
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        } catch (HibernateException hibex) {
            throw new HibernateException(hibex.getMessage());
        } catch (RuntimeException runEx) {
            throw new RuntimeException(runEx.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
