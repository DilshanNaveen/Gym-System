package com.company;

import java.util.Date;

public class Over60Member extends DefaultMember {

    private Integer age;

    public Over60Member(String memberShipNo, String name, String gender, String nationalID, Integer contactNumber, Date startMembershipDate, Date birthday, Double cost, Integer age) {
        super(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate, birthday, cost);
        this.age = age;
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
}
