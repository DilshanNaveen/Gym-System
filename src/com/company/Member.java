package com.company;


public class Member {
    private long memberShipNo;
    private String name;
    private String gender;
    private String nationalID;
    private long contactNumber;
    private String healthInfo;
    private String startMembershipDate;
    private Integer age;
    private String schoolName;
    private String grade;


    public Member() {
        this.memberShipNo = 0;
        this.name = "";
        this.gender = "";
        this.nationalID = "";
        this.contactNumber = 0;
        this.healthInfo = "";
        this.startMembershipDate = "";
        this.age = 0;
        this.schoolName = "";
        this.grade = "";
    }

    public Member(long memberShipNo, String name, String gender, String nationalID, long contactNumber, String healthInfo, String startMembershipDate, Integer age, String schoolName, String grade) {
        this.memberShipNo = memberShipNo;
        this.name = name;
        this.gender = gender;
        this.nationalID = nationalID;
        this.contactNumber = contactNumber;
        this.healthInfo = healthInfo;
        this.startMembershipDate = startMembershipDate;
        this.age = age;
        this.schoolName = schoolName;
        this.grade = grade;
    }

    public long getMemberShipNo() {
        return memberShipNo;
    }

    public void setMemberShipNo(long memberShipNo) {
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

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    public String getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(String startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
