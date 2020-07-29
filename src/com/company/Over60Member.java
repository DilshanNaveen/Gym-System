package com.company;


public class Over60Member extends DefaultMember {

    private Integer age;

    public Over60Member(Integer memberShipNo, String name, String gender, String nationalID, Integer contactNumber, String startMembershipDate, String birthday,  Integer age) {
        super(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate, birthday);
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
