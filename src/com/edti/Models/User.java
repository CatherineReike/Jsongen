package com.edti.Models;

import java.util.Date;

public class User {

    private int UserID;
    private String NeptunKod;
    private String VezetekNev;
    private String KeresztNev;
    private String TeljesNev;
    private String Email;
    private Date UserLastChanged;
    private Date EmailLastChanged;

    public User(int userID, String neptunKod, String vezetekNev,
                String keresztNev, String teljesNev, String email) {
        UserID = userID;
        NeptunKod = neptunKod;
        VezetekNev = vezetekNev;
        KeresztNev = keresztNev;
        TeljesNev = teljesNev;
        Email = email;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getNeptunKod() {
        return NeptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        NeptunKod = neptunKod;
    }

    public String getVezetekNev() {
        return VezetekNev;
    }

    public void setVezetekNev(String vezetekNev) {
        VezetekNev = vezetekNev;
    }

    public String getKeresztNev() {
        return KeresztNev;
    }

    public void setKeresztNev(String keresztNev) {
        KeresztNev = keresztNev;
    }

    public String getTeljesNev() {
        return TeljesNev;
    }

    public void setTeljesNev(String teljesNev) {
        TeljesNev = teljesNev;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getUserLastChanged() {
        return UserLastChanged;
    }

    public void setUserLastChanged(Date userLastChanged) {
        UserLastChanged = userLastChanged;
    }

    public Date getEmailLastChanged() {
        return EmailLastChanged;
    }

    public void setEmailLastChanged(Date emailLastChanged) {
        EmailLastChanged = emailLastChanged;
    }
}
