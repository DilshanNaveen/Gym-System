package com.company;

import java.util.Date;

public class DefaultMember {
    private String memberShipNo;
    private String name;
    private String gender;
    private String nationalID;
    private Integer contactNumber;
    private Date startMembershipDate;
    private Date birthday;
    private Double cost;

    public DefaultMember(String memberShipNo, String name, String gender, String nationalID, Integer contactNumber, Date startMembershipDate, Date birthday, Double cost) {
        this.memberShipNo = memberShipNo;
        this.name = name;
        this.gender = gender;
        this.nationalID = nationalID;
        this.contactNumber = contactNumber;
        this.startMembershipDate = startMembershipDate;
        this.birthday = birthday;
        this.cost = cost;
    }

    public String getMemberShipNo() {
        return memberShipNo;
    }

    public void setMemberShipNo(String memberShipNo) {
        this.memberShipNo = memberShipNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(Date startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
