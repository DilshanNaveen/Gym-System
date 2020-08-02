package com.company;


public class Over60Member extends DefaultMember {

    private Integer age;
    private String healthInfo;

    public Over60Member(Integer memberShipNo, String name, String gender, String nationalID, Integer contactNumber, String startMembershipDate, Integer age, String healthInfo) {
        super(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate);
        this.age = age;
        this.healthInfo = healthInfo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age>=60 && age<=100){
            this.age = age;
        }
        else{
            // value error
        }
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }
}
