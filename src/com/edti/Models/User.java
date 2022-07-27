package com.edti.Models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class User {

    private String UserID;
    private String NeptunKod;
    private String VezetekNev;
    private String KeresztNev;
    private String TeljesNev;
    private String Email;
    private LocalDateTime UserLastChanged;
    private LocalDateTime EmailLastChanged;

    public User(String userID, String neptunKod, String vezetekNev,
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

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof User c)) {
            return false;
        }


        return Objects.equals(c.UserID, this.UserID);

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

