package com.edti.Models;

import java.time.LocalDateTime;
import java.util.Date;

public class User {

    private int UserID;
    private String NeptunKod;
    private String VezetekNev;
    private String KeresztNev;
    private String TeljesNev;
    private String Email;
    private LocalDateTime UserLastChanged;
    private LocalDateTime EmailLastChanged;

    public User(int userID, String neptunKod, String vezetekNev,
                String keresztNev, String teljesNev, String email) {
        UserID = userID;
        NeptunKod = neptunKod;
        VezetekNev = vezetekNev;
        KeresztNev = keresztNev;
        TeljesNev = teljesNev;
        Email = email;
        UserLastChanged = LocalDateTime.now();
        EmailLastChanged = LocalDateTime.now();
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

    public LocalDateTime getUserLastChanged() {
        return UserLastChanged;
    }

    public void setUserLastChanged(LocalDateTime userLastChanged) {
        UserLastChanged = userLastChanged;
    }

    public LocalDateTime getEmailLastChanged() {
        return EmailLastChanged;
    }

    public void setEmailLastChanged(LocalDateTime emailLastChanged) {
        EmailLastChanged = emailLastChanged;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", NeptunKod='" + NeptunKod + '\'' +
                ", VezetekNev='" + VezetekNev + '\'' +
                ", KeresztNev='" + KeresztNev + '\'' +
                ", TeljesNev='" + TeljesNev + '\'' +
                ", Email='" + Email + '\'' +
                ", UserLastChanged=" + UserLastChanged +
                ", EmailLastChanged=" + EmailLastChanged +
                '}';
    }
}

