package com.company;

import java.util.Date;

public class StudentMember extends DefaultMember{

    private String schoolName;

    public StudentMember(String memberShipNo, String name, String gender, String nationalID, Integer contactNumber, Date startMembershipDate, Date birthday, Double cost, String schoolName) {
        super(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate, birthday, cost);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
