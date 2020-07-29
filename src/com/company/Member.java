package com.company;


public class Member {
    private String memberShipNo;
    private String name;
    private String gender;
    private String nationalID;
    private Integer contactNumber;
    private String startMembershipDate;
    private String birthday;
    private Integer age;
    private String schoolName;


    public Member(Integer memberShipNo, String name, String nationalID, Integer contactNumber, String startMembershipDate, String birthday, int i, String pcc) {
        this.memberShipNo = "";
        this.name = "";
        this.gender = "";
        this.nationalID = "";
        this.contactNumber = 0;
        this.startMembershipDate = this.startMembershipDate;
        this.birthday = "0000-00-00";
        this.age = 0;
        this.schoolName = "";
    }

    public Member(String memberShipNo, String name, String gender, String nationalID, Integer contactNumber, String startMembershipDate, String birthday, Integer age, String schoolName) {
        this.memberShipNo = memberShipNo;
        this.name = name;
        this.gender = gender;
        this.nationalID = nationalID;
        this.contactNumber = contactNumber;
        this.startMembershipDate = startMembershipDate;
        this.birthday = birthday;
        this.age = age;
        this.schoolName = schoolName;
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

    public String getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(String startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
