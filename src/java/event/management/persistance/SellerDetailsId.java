package event.management.persistance;
// Generated 3 Mar, 2016 3:49:27 PM by Hibernate Tools 4.3.1



/**
 * SellerDetailsId generated by hbm2java
 */
public class SellerDetailsId  implements java.io.Serializable {


     private String emailId;
     private String userName;

    public SellerDetailsId() {
    }

    public SellerDetailsId(String emailId, String userName) {
       this.emailId = emailId;
       this.userName = userName;
    }
   
    public String getEmailId() {
        return this.emailId;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }




}


