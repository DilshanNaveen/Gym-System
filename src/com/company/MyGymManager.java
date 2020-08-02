package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyGymManager implements GymManager{
    private List<DefaultMember> listOfAllMembers = new ArrayList<DefaultMember>();

    @Override
    public void addMember(DefaultMember member) {
        System.out.println("No of occupied slots : " + listOfAllMembers.size());
        System.out.println("No of free slots : " + (100 - listOfAllMembers.size()));

        if (listOfAllMembers.size() < 100){
            System.out.println(member.getName());

            listOfAllMembers.add(member);

            System.out.println("No of occupied slots : " + listOfAllMembers.size());
            System.out.println("No of free slots : " + (100 - listOfAllMembers.size())+"\n");
        }
        else{
            System.out.println("No free slot available \n");
        }
    }

    @Override
    public boolean deleteMember(String membershipNo) {
        boolean flag =  false;
        for (DefaultMember member: listOfAllMembers){
            if (member.getMemberShipNo().equals(membershipNo));{
                flag =  true;
                listOfAllMembers.remove(member);
                System.out.println("------------------------------------------------------------");
                System.out.println("|\t\t Membership No " + membershipNo + " Successfully Removed.\t\t |");
                System.out.println("------------------------------------------------------------\n");
                System.out.println("\nNo of free slots : " + (100 - listOfAllMembers.size()));

                if (member instanceof DefaultMember){
                    System.out.println("Type of deleted member : Default Member");
                }
                else if (member instanceof Over60Member){
                    System.out.println("Type of deleted member : Over 60 Member");
                }
                else{

                    System.out.println(" Type of deleted member : Student Member ");
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
        System.out.println("\n \t===================================");
        System.out.println("\t\t\t Members of Gym");
        System.out.println("\t===================================\n");
        for (DefaultMember member: listOfAllMembers){
            System.out.println("\nMembership No : " + member.getMemberShipNo());
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
        }
        if (listOfAllMembers.size() == 0){
            System.out.println("Empty List\n");
        }
    }

    @Override
    public void sortList() {
        Collections.sort(listOfAllMembers, new Comparator<DefaultMember>() {
            @Override
            public int compare(DefaultMember member1, DefaultMember member2) {
                // compare name of the members.
                return member1.getName().compareTo(member2.getName());
            }
        });
        printListMember();
        System.out.print("\nList Sorted Successfully");
    }

    @Override
    public void save() {

        JSONParser jsonParser = new JSONParser();

        for (DefaultMember member: listOfAllMembers) {
            try {
                Object obj = jsonParser.parse(new FileReader("members.json"));
                JSONArray memberArray = (JSONArray)obj;

                JSONObject memberDetails = new JSONObject();


                if (member instanceof StudentMember){
                    memberDetails.put("Type", 1);
                    memberDetails.put("School Name", ((StudentMember) member).getSchoolName());
                }
                else if (member instanceof Over60Member){
                    memberDetails.put("Type", 2);
                    memberDetails.put("Age", ((Over60Member) member).getAge());
                    memberDetails.put("Health Information", ((Over60Member) member).getHealthInfo());
                }else{
                    memberDetails.put("Type", 3);
                }

                memberDetails.put("Membership No", member.getMemberShipNo());
                memberDetails.put("Member Name", member.getName());
                memberDetails.put("Gender", member.getGender());
                memberDetails.put("National ID", member.getNationalID());
                memberDetails.put("Contact Number", member.getContactNumber());
                memberDetails.put("Membership Start Date", member.getStartMembershipDate());


                memberArray.add(memberDetails);

                FileWriter file = new FileWriter("members.json");
                file.write(memberArray.toJSONString());
                file.flush();
                file.close();

            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public ObservableList<Member> loadTable(){
        ObservableList<Member> memberRow = FXCollections.observableArrayList();

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("members.json"));
            JSONArray array = (JSONArray) obj;

            for (int i = 0; array.size() > i; i++) {

                JSONObject jsonObject = (JSONObject) array.get(i);

                int type = (int)(long) jsonObject.get("Type");
                long memberShipNo = (long) jsonObject.get("Membership No");
                String name = (String) jsonObject.get("Member Name");
                String gender = (String) jsonObject.get("Gender");
                String nationalID = (String) jsonObject.get("National ID");
                long contactNumber = (long) jsonObject.get("Contact Number");
                String startMembershipDate = (String) jsonObject.get("Membership Start Date");

                if (type == 1){
                    System.out.println(type);
                    String schoolName = (String) jsonObject.get("School Name");
                    memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate, null, schoolName));
                }
                else if (type == 2){
                    int age = (int)(long) jsonObject.get("Age");
                    memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate, age, null));
                }
                else if (type == 3){
                    memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate, null, null));
                }
            }
            return memberRow;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
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
