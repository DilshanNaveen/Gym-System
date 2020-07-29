package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class json {

    public static void main(String[] args) {

        Scanner newScanner = new Scanner(System.in);

        /*
        System.out.print("Enter Membership No : ");
        Integer membershipNo = newScanner.nextInt();

        System.out.print("Enter Your Name : ");
        String name = newScanner.nextLine();

        System.out.print("Enter You Gender : ");
        String gender = newScanner.nextLine();

        System.out.print("Enter National ID : ");
        String nationalID = newScanner.nextLine();

        System.out.print("Enter Your Contact Number : ");
        Integer contactNumber = newScanner.nextInt();

        System.out.print("Enter Your Membership Start Date : ");
        String membershipStartDate = newScanner.nextLine();

        System.out.print("Enter Your Birthday : ");
        String birthday = newScanner.nextLine();
        */

        System.out.print("Enter Membership No : ");
        Integer membershipNo = newScanner.nextInt();
        System.out.print("Enter Your Name : ");
        String name = newScanner.next();
        System.out.print("Enter You Gender : ");
        String gender = newScanner.next();




        /*
        JSONObject memberDetails = new JSONObject();
        memberDetails.put("Membership No", member.getMemberShipNo());
        memberDetails.put("Member Name", member.getName());
        memberDetails.put("Gender", member.getGender());
        memberDetails.put("National ID", member.getNationalID());

        JSONObject memberObject = new JSONObject();
        memberObject.put(member.getMemberShipNo(), memberDetails);

        JSONArray memberArray = new JSONArray();
        memberArray.add(memberObject);

        try (FileWriter file = new FileWriter("members.json", true)) {

            file.write(memberArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }
}
