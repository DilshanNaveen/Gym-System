package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
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
    public void addMember(DefaultMember newMember) {
        System.out.println("\n===========================================================");
        System.out.println("No of occupied slots : " + listOfAllMembers.size());
        System.out.println("No of free slots : " + (100 - listOfAllMembers.size()));

        if (listOfAllMembers.size() < 100){
            System.out.println("\n Adding data of " + newMember.getName() + " to the System\n");

            listOfAllMembers.add(newMember);
            System.out.println("No of occupied slots : " + listOfAllMembers.size());
            System.out.println("No of free slots : " + (100 - listOfAllMembers.size()));
            System.out.println("===========================================================\n");
        }
        else{
            System.out.println("No free slot available \n");
        }
    }

    @Override
    public boolean deleteMember(String membershipNo) {
        boolean flag =  false;
        for (DefaultMember selectedMember: listOfAllMembers){
            if (selectedMember.getMemberShipNo().equals(membershipNo));{
                flag =  true;
                listOfAllMembers.remove(selectedMember);
                System.out.println("------------------------------------------------------------");
                System.out.println("|\t\t Membership No " + membershipNo + " Successfully Removed.\t\t |");
                System.out.println("------------------------------------------------------------\n");
                System.out.println("\nNo of free slots : " + (100 - listOfAllMembers.size()));

                if (selectedMember instanceof DefaultMember){
                    System.out.println("Type of deleted member : Default Member");
                }
                else if (selectedMember instanceof Over60Member){
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
        System.out.println("\t\t\t Members of the Gym");
        System.out.println("\t===================================\n");
        for (DefaultMember member: listOfAllMembers){
            System.out.println("\nMembership No : " + member.getMemberShipNo());
            System.out.println("Name of the member : " + member.getName());

            if (member instanceof DefaultMember){
                System.out.println("Type of the member : Default Member");
            }
            else if (member instanceof Over60Member){
                System.out.println("Age : "+ ((Over60Member) member).getAge());
                System.out.println("Health Information : "+ ((Over60Member) member).getHealthInfo());
                System.out.println("Type of the member : Over 60 Member");
            }
            else{
                System.out.println("School Name : "+ ((StudentMember) member).getSchoolName());
                System.out.println("Grade : " + ((StudentMember) member).getGrade());
                System.out.println("Type of the member : Student Member");
            }
            System.out.println("Membership start date : " + member.getStartMembershipDate());
            System.out.println("Gender : "+ member.getGender());
            System.out.println("National ID : "+ member.getNationalID());
            System.out.println("Contact Number : "+ member.getContactNumber());
            System.out.println("Membership Start Date : " + member.getStartMembershipDate()+"\n");
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
                Object obj = jsonParser.parse(new FileReader("./src/com/company/data/members.json"));
                JSONArray memberArray = (JSONArray)obj;

                JSONObject memberDetails = new JSONObject();


                if (member instanceof StudentMember){
                    memberDetails.put("Type", 1);
                    memberDetails.put("School Name", ((StudentMember) member).getSchoolName());
                    memberDetails.put("Grade", ((StudentMember) member).getGrade());
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

                FileWriter file = new FileWriter("./src/com/company/data/members.json");
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
            Object obj = parser.parse(new FileReader("./src/com/company/data/members.json"));
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
                    String grade = (String) jsonObject.get("Grade");
                    memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, null, startMembershipDate, null, schoolName, grade));
                }
                else if (type == 2){
                    int age = (int)(long) jsonObject.get("Age");
                    String healthInfo = (String) jsonObject.get("Health Information");
                    memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, healthInfo, startMembershipDate, age, null, null));
                }
                else if (type == 3){
                    memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, null, startMembershipDate, null, null, null));
                }
            }
            return memberRow;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ObservableList<Member> searchTableById(int searchId) {
        ObservableList<Member> memberRow = FXCollections.observableArrayList();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("./src/com/company/data/members.json"));
            JSONArray array = (JSONArray) obj;

            for (int i = 0; array.size() > i; i++) {

                JSONObject jsonObject = (JSONObject) array.get(i);
                int memberShipNo = (int)(long) jsonObject.get("Membership No");

                if (memberShipNo == searchId){
                    int type = (int)(long) jsonObject.get("Type");
                    String name = (String) jsonObject.get("Member Name");
                    String gender = (String) jsonObject.get("Gender");
                    String nationalID = (String) jsonObject.get("National ID");
                    long contactNumber = (long) jsonObject.get("Contact Number");
                    String startMembershipDate = (String) jsonObject.get("Membership Start Date");

                    if (type == 1){
                        String schoolName = (String) jsonObject.get("School Name");
                        String grade = (String) jsonObject.get("Grade");
                        memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, null,startMembershipDate, null, schoolName, grade));
                    }
                    else if (type == 2){
                        int age = (int)(long) jsonObject.get("Age");
                        String healthInfo = (String) jsonObject.get("Health Information");
                        memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, healthInfo,startMembershipDate, age, null,null));
                    }
                    else if (type == 3){
                        memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, null, startMembershipDate, null, null,null));
                    }
                    return memberRow;
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void loadMemberList() {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("./src/com/company/data/members.json"));
            JSONArray array = (JSONArray) obj;

            for (int i = 0; array.size() > i; i++) {

                JSONObject jsonObject = (JSONObject) array.get(i);
                int membershipNo = (int) (long) jsonObject.get("Membership No");
                int type = (int) (long) jsonObject.get("Type");
                String name = (String) jsonObject.get("Member Name");
                String gender = (String) jsonObject.get("Gender");
                String nationalID = (String) jsonObject.get("National ID");
                int contactNumber = (int) (long) jsonObject.get("Contact Number");
                String startMembershipDate = (String) jsonObject.get("Membership Start Date");
                DefaultMember oldMemberData =  null;

                if (type == 1){
                    String schoolName = (String) jsonObject.get("School Name");
                    String grade = (String) jsonObject.get("Grade");
                    oldMemberData = new StudentMember(membershipNo, name, gender, nationalID, contactNumber, startMembershipDate, schoolName, grade);
                }
                else if (type == 2){
                    int age = (int)(long) jsonObject.get("Age");
                    String healthInfo = (String) jsonObject.get("Health Information");
                    oldMemberData = new Over60Member(membershipNo, name, gender, nationalID, contactNumber, startMembershipDate, age, healthInfo);
                }
                else if (type == 3){
                    oldMemberData = new DefaultMember(membershipNo, name, gender, nationalID, contactNumber, startMembershipDate);
                }


                addMember(oldMemberData);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

}
