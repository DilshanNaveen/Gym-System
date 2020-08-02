package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManagerConsole {

    FileWriter file = new FileWriter("com/company/data/members.json", true);
    private final static MyGymManager manager = new MyGymManager();

    public ManagerConsole() throws IOException {
    }

    public static void main(String[] args) {
        System.out.println("\t===================================");
        System.out.println("\t Welcome To Gym Management System");
        System.out.println("\t===================================\n");

        while (true) {
            Scanner newScanner = new Scanner(System.in);
            System.out.println("Chose Option");
            System.out.println(" 1.Enter No 1 to add members.");
            System.out.println(" 2.Enter No 2 to delete members.");
            System.out.println(" 3.Enter No 3 to Print.");
            System.out.println(" 4.Enter No 4 to Search Members.");
            System.out.println(" 5.Enter No 5 to Sort.");
            System.out.println(" 6.Enter No 6 to Save.");
            System.out.println(" 7.Enter No 7 to load saved data.");
            System.out.println(" 8.Enter No 8 to Quit. \n");

            System.out.print("Your choice : ");
            int choice = newScanner.nextInt();

            switch (choice) {
                case 1:
                    insertMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    manager.printListMember();
                    break;
                case 4:
                    System.out.println("First You Need To Save Your Data If you didn't");
                    System.out.print("Enter 'Y' To save, Enter 'N' to Continue Without Saving :  ");
                    String secondChoice = newScanner.next();
                    switch (secondChoice) {
                        case "Y":
                        case "y":
                            manager.save();
                            SearchUI.launch(SearchUI.class, args);
                            break;
                        case "N":
                        case "n":
                            SearchUI.launch(SearchUI.class, args);
                            break;
                    }
                case 5:
                    manager.sortList();
                    break;
                case 6:
                    manager.save();
                    break;
                case 7:
                    manager.loadMemberList();
                    break;
                case 8:
                    System.exit(0);
                    break;

            }
        }
    }

    private static void insertMember() {

        Scanner newScanner = new Scanner(System.in);

        try{
            System.out.println("\n \t===================================");
            System.out.println("\t\t\t Add New Member");
            System.out.println("\t===================================\n");

            System.out.print("Enter Membership No : ");
            Integer membershipNo = newScanner.nextInt();

            String name = getName();

            System.out.print("Enter You Gender (male/female/other): ");
            String gender = newScanner.next();

            switch (gender){
                case "male":
                case "Male":
                case "female":
                case "Female":
                case "other":
                case "Other":
                    System.out.print("Enter National ID : ");
                    String nationalID = newScanner.next();

                    System.out.print("Enter Your Contact Number : ");
                    Integer contactNumber = newScanner.nextInt();

                    String membershipStartDate = getDate();

                    System.out.println("Enter Type ");
                    System.out.println(" 1.Default Member (d/D) ");
                    System.out.println(" 2.Student Member (s/S) ");
                    System.out.println(" 3.Over 60 Member (o/O) ");
                    System.out.print("Type : ");
                    String type = newScanner.next();

                    DefaultMember newMember =  null;

                    switch (type){
                        case "D":
                        case "d":
                            newMember = new DefaultMember(membershipNo, name, gender, nationalID, contactNumber, membershipStartDate);
                            break;
                        case "S":
                        case "s":
                            System.out.println("Enter Your Grade : ");
                            String grade = newScanner.next();
                            newMember = new StudentMember(membershipNo, name, gender, nationalID, contactNumber, membershipStartDate, getStudentData(), grade);
                            break;
                        case "O":
                        case "o":
                            System.out.print("\nEnter Your age : ");
                            Integer age = newScanner.nextInt();
                            System.out.print("Enter Your Health Information : ");
                            String healthInfo = newScanner.next();
                            newMember = new Over60Member(membershipNo, name, gender, nationalID, contactNumber, membershipStartDate, age, healthInfo);
                            break;
                        default:
                            System.out.println("\n Invalid Input \n");
                    }
                    System.out.print("\n");
                    manager.addMember(newMember);
                    break;

                default:
                    System.out.println("\n Invalid Input \n");
            }
        }
        catch (Exception IllegalArgumentException) {
            System.out.println("\n Invalid Input \n");
        }

    }
    private static void deleteMember(){
        System.out.println("\n \t===================================");
        System.out.println("\t\t Delete Members from Gym");
        System.out.println("\t===================================\n");

        Scanner newScanner = new Scanner(System.in);
        System.out.print("\n Enter Membership ID of the Member That You want to delete : ");
        System.out.print("");
        String membershipNo = newScanner.nextLine();
        boolean result = manager.deleteMember(membershipNo);
    }

    private static String getStudentData(){
        Scanner studentScanner = new Scanner(System.in);
        System.out.print("\n Enter Your School : ");
        String schoolName = studentScanner.nextLine();
        return schoolName;
    }

    private static String getName(){
        Scanner newScanner = new Scanner(System.in);
        System.out.print("Enter Your Name : ");
        String name = newScanner.nextLine();
        return name;
    }

    private static String getDate(){
        String finalDate = "";
        while(true) {
            try {
                Scanner newScanner = new Scanner(System.in);
                System.out.println("Enter Your Membership Start Date (yyyy-mm-dd)");
                System.out.print(" Year : ");
                String year = newScanner.next();
                if (year.length() == 4) {
                    System.out.print(" Month : ");
                    Integer month = newScanner.nextInt();
                    if (String.valueOf(month).length() <= 2 && month <= 12 && month >= 1) {
                        System.out.print(" Date : ");
                        Integer date = newScanner.nextInt();
                        if (String.valueOf(date).length() <= 2 && date <= 31 && date >= 1) {
                            finalDate = year + "-" + month + "-" + date;
                            System.out.println("\nYour Membership Start Date is "+ finalDate +"\n");
                            return finalDate;
                        } else {
                            System.out.println("Please Enter Valid Date");
                        }
                    } else {
                        System.out.println("Please Enter Valid Month");
                    }
                } else {
                    System.out.println("Please Enter Valid Year");
                }
            } catch (Exception IllegalArgumentException) {
                System.out.println("Please Enter Valid Data");
            }
        }
    }

}
