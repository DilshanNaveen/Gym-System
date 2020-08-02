package com.company;


public class StudentMember extends DefaultMember{

    private String schoolName;
    private String grade;

    public StudentMember(Integer memberShipNo, String name, String gender, String nationalID, Integer contactNumber, String startMembershipDate, String schoolName, String grade) {
        super(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate);
        this.schoolName = schoolName;
        this.grade = grade;
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
