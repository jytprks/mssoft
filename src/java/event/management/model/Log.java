/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.management.model;

/**
 *
 * @author suvh
 */
public class Log {

    private String PASSWORD;
    private String ADD;
    private String EMAIL;
    private String PHONE;

    /**
     * @return the PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * @param PASSWORD the PASSWORD to set
     */
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    /**
     * @return the ADD
     */
    public String getADD() {
        return ADD;
    }

    /**
     * @param ADD the ADD to set
     */
    public void setADD(String ADD) {
        this.ADD = ADD;
    }

    /**
     * @return the EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * @param EMAIL the EMAIL to set
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    /**
     * @return the PHONE
     */
    public String getPHONE() {
        return PHONE;
    }

    /**
     * @param PHONE the PHONE to set
     */
    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }
}
