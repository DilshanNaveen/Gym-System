package com.company;


public class DefaultMember implements Comparable<DefaultMember>{
    private Integer memberShipNo;
    private String name;
    private String gender;
    private String nationalID;
    private Integer contactNumber;
    private String startMembershipDate;

    public DefaultMember(Integer memberShipNo, String name, String gender, String nationalID, Integer contactNumber, String startMembershipDate) {
        this.memberShipNo = memberShipNo;
        this.name = name;
        this.gender = gender;
        this.nationalID = nationalID;
        this.contactNumber = contactNumber;
        this.startMembershipDate = startMembershipDate;
    }

    public Integer getMemberShipNo() {
        return memberShipNo;
    }

    public void setMemberShipNo(Integer memberShipNo) {
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

    public String getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(String startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    @Override
    public int compareTo(DefaultMember o) {
        return this.name.compareTo(o.getName());
    }
}
