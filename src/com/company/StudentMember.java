package com.company;


public class StudentMember extends DefaultMember{

    private String schoolName;

    public StudentMember(Integer memberShipNo, String name, String gender, String nationalID, Integer contactNumber, String startMembershipDate, String schoolName) {
        super(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
