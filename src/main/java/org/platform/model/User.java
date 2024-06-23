package org.platform.model;

import lombok.*;
import org.platform.enams.Status;

public class User {
@Getter
@Setter
    private int id;
    private String name;
    private String surname;
    private int year;
    private String email;
    private String password;
    private Status status;
    private String verificationCode;
    private String resetToken;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public User(int id, String name, String surname, int year, String email, String password, Status status, String verificationCode, String resetToken) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.email = email;
        this.password = password;
        this.status = status;
        this.verificationCode = verificationCode;
        this.resetToken = resetToken;
    }

    @Override
    public String toString() {
        return id + " " +  name + " " + surname + " " + year + " " + email + " " + password + " " + status + " " + verificationCode + " " + resetToken;
    }
}
