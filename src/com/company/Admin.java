package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
    public static void adminLogin() {
        Scanner scan = new Scanner(System.in);

        String adminUsername = "admin101";
        String adminPassword = "pass123";

        System.out.print("Enter username: ");
        String enteredUsername = scan.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scan.nextLine();

        try
        {
            if (adminUsername.equals(enteredUsername) && adminPassword.equals(enteredPassword))
            {
                System.out.print("Login successful!.................. Welcome admin!\n" +
                        "Enter,\n" +
                        "'1' to edit information of the patients\n" +
                        "'2' to view patient details\n" +
                        "'3' to logout and return to home\n" +
                        "'4' to logout and exit: ");
                int a = scan.nextInt();

                //Admin's choices with try catch function used to prevent input mismatch error causing the app to terminate
                switch (a) {
                    case 1 -> editPatientInformation();
                    case 2 -> Main.showPatientDetails();
                    case 3 -> Main.homepage();
                    case 4 -> {
                        System.out.println("Thank you for using the program!");
                        System.exit(1);
                    }
                    default -> {
                        System.out.println("invalid answer! try again!");
                        System.exit(1);
                    }
                }

            }
            //If the admin typed mismatched username and password
            else
            {
                System.out.println("*******************************************\n" +
                        "Username and Password doesn't match!\n" +
                        "Please try again!");

                System.out.print("Enter,\n" +
                        "'1' to retry\n" +
                        "'2' to return home\n" +
                        "'3' to exit program: ");
                int answer = scan.nextInt();

                if (answer == 1)
                {
                    adminLogin();
                }
                else if (answer == 2)
                {
                    Main.homepage();
                }
                else if (answer == 3)
                {
                    System.exit(1);
                }

            }
        } catch (InputMismatchException e)
            {

            System.out.println("Error!\n" +
                    "Please enter a number!");
            Main.homepage();
             }
    }

    public static void editPatientInformation() {
        Scanner scan = new Scanner(System.in);

        System.out.println("***********************************************************");
        System.out.print("******************    Admin Home page    ******************\n" +
                "***********************************************************\n");

        try
        { System.out.print("please enter\n" +
                "'1' to add patient account\n" +
                "'2' to remove patients from the program\n" +
                "'3' to see new patient account requests\n" +
                "'4' to logout,\n" +
                "'5' to exit the program\n" +
                "Answer:  ");
            int edit = scan.nextInt();

            switch (edit)
                {
                case 1 -> Main.createNewAccount();
                case 2 -> Main.removePatientAccounts();
                case 3 -> Main.showNewPatientAccountRequests();
                case 4 -> Main.homepage();
                case 5 -> System.exit(1);
                default -> System.out.println("Invalid answer! Try again");
                }
        }
        catch (InputMismatchException e)
            {
            System.out.println("Input error!\n" +
                    "Please enter a number!");
            editPatientInformation();}
    }
}
