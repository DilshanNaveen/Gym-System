package com.company;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class json {

    public static void main(String[] args) {
        String text = "Text";

        if (text == "Text"){
            System.out.println("text");
        }


        /*
        JSONParser parser = new JSONParser();

        int userInput = 213;

        try {
            Object obj = parser.parse(new FileReader("members.json"));

            JSONArray array = (JSONArray) obj;
            for (int i = 0; array.size()>= i; i++){
                JSONObject jsonObject = (JSONObject) array.get(i);
                long temp = (long) jsonObject.get("Contact Number");
                if (userInput == temp){
                    String name = (String) jsonObject.get("Member Name");
                    System.out.println(name);
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        */

    }
    public static ObservableList<Member> loadTable() {
        ObservableList<Member> memberRow = FXCollections.observableArrayList();

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("members.json"));
            JSONArray array = (JSONArray) obj;

            for (int i = 0; array.size() >= i; i++) {

                JSONObject jsonObject = (JSONObject) array.get(i);

                long memberShipNo = (long) jsonObject.get("Membership No");
                String name = (String) jsonObject.get("Member Name");
                String gender = (String) jsonObject.get("Gender");
                String nationalID = (String) jsonObject.get("National ID");
                long contactNumber = (long) jsonObject.get("Contact Number");
                String startMembershipDate = (String) jsonObject.get("Membership Start Date");

                System.out.println(memberShipNo);
                System.out.println(name);
                System.out.println(nationalID);
                System.out.println(contactNumber);
                System.out.println(startMembershipDate);

                memberRow.add(new Member(memberShipNo, name, gender, nationalID, contactNumber, startMembershipDate, 18, "pcc"));
                return memberRow;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}