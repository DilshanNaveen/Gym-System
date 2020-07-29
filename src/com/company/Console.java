package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Console {

    FileWriter file = new FileWriter("members.json", true);
    private final static MyGymManager manager = new MyGymManager();

    public Console() throws IOException {
    }

    public static void main(String[] args) {

    while (true) {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("\n Select \n");
        System.out.println("\t============================\n");
        System.out.println(" 1.Enter No 1 to add members.");
        System.out.println(" 2.Enter No 2 to delete members.");
        System.out.println(" 3.Enter No 3 to Print.");
        System.out.println(" 4.Enter No 4 to Search Members.");
        System.out.println(" 5.Enter No 5 to Quit. \n");

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
                printReport();
                break;
            case 4:
                Table.launch(Table.class, args);
                break;
            case 5:
                System.exit(0);
                break;

        }
    }
    }

    private static void insertMember() {

        Scanner newScanner = new Scanner(System.in);

        try{
            System.out.print("Enter Membership No : ");
            Integer membershipNo = newScanner.nextInt();

            System.out.print("Enter Your Name : ");
            String name = newScanner.next();

            System.out.print("Enter You Gender : ");
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

                    System.out.print("Enter Your Membership Start Date (yyyy-mm-dd) : ");
                    String membershipStartDate = newScanner.next();

                    System.out.print("Enter Your Birthday (yyyy-mm-dd) : ");
                    String birthday = newScanner.next();

                    System.out.println("\n Enter Type ");
                    System.out.println("  1.Default Member (d/D) ");
                    System.out.println("  2.Student Member (s/S) ");
                    System.out.println("  3.Over 60 Member (o/O) ");
                    System.out.print("Type : ");
                    String type = newScanner.next();

                    DefaultMember member =  null;

                    switch (type){
                        case "D":
                        case "d":
                            member = new DefaultMember(membershipNo, name, gender, nationalID, contactNumber, membershipStartDate, birthday);
                            break;
                        case "S":
                        case "s":
                            member = new StudentMember(membershipNo, name, gender, nationalID, contactNumber, membershipStartDate, birthday, getStudentData());
                            break;
                        case "O":
                        case "o":
                            Integer age = newScanner.nextInt();
                            member = new Over60Member(membershipNo, name, gender, nationalID, contactNumber, membershipStartDate, birthday, age);
                            break;
                        default:
                            System.out.println("\n Invalid Input \n");
                    }
                    System.out.print("\n");
                    manager.addMember(member);
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
        Scanner newScanner = new Scanner(System.in);
        System.out.print("\n Enter Membership ID of the Member That You want to delete : ");
        System.out.print("");
        String membershipNo = newScanner.nextLine();
        boolean result = manager.deleteMember(membershipNo);
    }

    private static void printReport(){}

    private static String getStudentData(){
        Scanner studentScanner = new Scanner(System.in);
        System.out.print("\n Enter Your School : ");
        String schoolName = studentScanner.nextLine();
        return schoolName;
    }
}
