package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyGymManager implements GymManager{
    private List<DefaultMember> memberList = new ArrayList<DefaultMember>();

    @Override
    public void addMember(DefaultMember member) {
        System.out.println("No of occupied slots : " + memberList.size());
        System.out.println("No of free slots : " + (100 - memberList.size()));

        if (memberList.size() < 100){
            System.out.println(member.getName());
            memberList.add(member);

            System.out.println("No of occupied slots : " + memberList.size());
            System.out.println("No of free slots : " + (100 - memberList.size()));
        }
        else{
            System.out.println("No free slot available ");
        }
    }

    @Override
    public boolean deleteMember(String membershipNo) {
        boolean flag =  false;
        for (DefaultMember member: memberList){
            if (member.getMemberShipNo().equals(membershipNo));{
                flag =  true;
                memberList.remove(member);
                System.out.println("\n Membership No " + membershipNo + "Successfully Removed ");
                System.out.println("No of free slots : " + (100 - memberList.size()));

                if (member instanceof DefaultMember){
                    System.out.println("Type of deleted member : Default Member");
                }
                else if (member instanceof Over60Member){
                    System.out.println("Type of deleted member : Over 60 Member");
                }
                else{
                    System.out.println("Type of deleted member : Student Member");
                }

                break;
            }
        }
        if (!flag){
            System.out.println("\n Membership No " + membershipNo + " Not Found ");
        }
        return flag;
    }


    @Override
    public void printListMember() {
        for (DefaultMember member: memberList){
            System.out.println("Membership No : " + member.getMemberShipNo());
            if (member instanceof DefaultMember){
                System.out.println("Type of the member : Default Member");
            }
            else if (member instanceof Over60Member){
                System.out.println("Type of the member : Over 60 Member");
            }
            else{
                System.out.println("Type of the member : Student Member");
            }
            System.out.println("Name of the member : " + member.getName());
            System.out.println("Membership start date : " + member.getStartMembershipDate());
            System.out.println("members birthday : " + member.getBirthday());
        }
        if (memberList.size() == 0){
            System.out.println("Empty List");
        }
    }

    @Override
    public void sort() {

    }

    @Override
    public void save() {

    }

    @Override
    public List<DefaultMember> getMemberList() {
        return null;
    }

    @Override
    public DefaultMember getMemberByMemberShipNo(String membershipNo) {
        return null;
    }

    @Override
    public DefaultMember[] getMemberByName(String name) {
        return new DefaultMember[0];
    }
}
