package com.company;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Admin {
    public static HashMap<String, String> PatientCredentials = new HashMap<>();

    public static HashMap<String, String> NewPatientRequest = new HashMap<>();

    //Patient details
    public static HashMap<String, String> PatientName = new HashMap<>();
    public static HashMap<String, String> PatientContactNumber = new HashMap<>();
    public static HashMap<String, String> PatientAppointmentDate = new HashMap<>();
    public static HashMap<String, Integer>PatientPaidAmount = new HashMap<>();
    public static HashMap<String, String> PatientPaymentStatus = new HashMap<>();

    public static void main(String[] args) {
        Main.homepage();
    }

    public static void homepage()
    {
        // This method acts as a homepage for the program
        Scanner s = new Scanner(System.in);
        System.out.println("***********************************************************");
        System.out.println("*********************   Home page   ***********************\n" +
                "***********************************************************");

        try {
            System.out.print(
                    "Please enter,\n" +
                            "'1' for administrator login\n" +
                            "'2' for patient login\n" +
                            "'3' to add a request for a new patient account\n" +
                            "'4' to exit the program\n" +
                            "Please enter number: ");
            int answer = s.nextInt();

            switch (answer)
            {
                case 1 -> adminLogin();
                case 2 -> patientLogin();
                case 3 -> newPatientAccountRequests();
                case 4 -> {
                    System.out.println("Thank you for using the program!\n" +
                            "******************************************************");
                                return;
                            }
                default -> System.out.println("Invalid answer!\n" +
                        "Try again!");
            }
        }
        catch (InputMismatchException e)
            {
                System.out.println("Error!!\n" +
                    "Enter a number!!");
            }
        homepage();

    }

    public static void createNewAccount() {
        //This method is used to create new account for patients
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************************************");
        System.out.println("*****************   Create new account   ******************\n" +
                "***********************************************************");

        System.out.print("Enter a username: ");
        String username = scan.nextLine();

        System.out.print("Enter a password: ");
        String password = scan.nextLine();

        PatientCredentials.put(username, password);


        try
            {
            System.out.print("Enter patient full name: ");
            String fullName = scan.nextLine();

            System.out.print("Enter patient appointment date: ");
            String appointmentDate = scan.nextLine();

            System.out.print("Enter patient payment amount: ");
            Integer paidAmount = scan.nextInt();

            System.out.print("Enter patient payment status: ");
            String paymentStatus = scanner.nextLine();

            System.out.print("Enter patient contact number: ");
            String contactNumber = scanner.nextLine();

            PatientName.put(username, fullName);
            PatientAppointmentDate.put(username, appointmentDate);
            PatientContactNumber.put(username, contactNumber);
            PatientPaidAmount.put(username, paidAmount);
            PatientPaymentStatus.put(username, paymentStatus);

            }
                catch (InputMismatchException e)
                    {
                    System.out.println("Error!" +
                            "Enter a number!");
                    System.exit(1);
                    }

        homepage();
    }

    public static void patientLogin() {
        //This method is used by patients to login and see their details

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter username: ");
        String enteredUsername = scan.nextLine();


        System.out.print("Enter password: ");
        String enteredPassword = scan.nextLine();

        if (PatientCredentials.containsKey(enteredUsername) && PatientCredentials.containsValue(enteredPassword))
        {
            System.out.println("Login successful");
            System.out.println("********************  Patient Details  ********************");

            System.out.println("Patient Full name: "+PatientName.get(enteredUsername));

            System.out.println("Patient Appointment date: : "+PatientAppointmentDate.get(enteredUsername));

            System.out.println("Patient contact number: "+PatientContactNumber.get(enteredUsername));

            System.out.println("Patient payment amount: Rs. " + PatientPaidAmount.get(enteredUsername) );

            System.out.println("Patient payment status: " + PatientPaymentStatus.get(enteredUsername));
        }
        else {
            System.out.println("Wrong credentials");
            homepage();
            }

    }

    public static void removePatientAccounts(){
        //This method is used to remove patient accounts
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        PatientCredentials.remove(enteredUsername);

        System.out.print("Remaining patient accounts: "+ PatientCredentials);
    }

    public static void showPatientDetails(){
        //This method is used to show patient details
        Scanner scan = new Scanner(System.in);
        System.out.println("To get the patient details, please enter patient username..............");

        System.out.print("Enter patient username: ");
        String patientUsernameVerification = scan.nextLine();

        System.out.println("********************  Patient Details  ********************");

        System.out.println("Patient Full name: "+PatientName.get(patientUsernameVerification));

        System.out.println("Patient Appointment date: : "+PatientAppointmentDate.get(patientUsernameVerification));

        System.out.println("Patient contact number: "+PatientContactNumber.get(patientUsernameVerification));

        System.out.println("Patient payment amount: Rs. " + PatientPaidAmount.get(patientUsernameVerification) );

        System.out.println("Patient payment status: " + PatientPaymentStatus.get(patientUsernameVerification));

        System.out.println("  ");


    }

    public static void newPatientAccountRequests(){
        Scanner scan = new Scanner(System.in);

        System.out.println("***********************************************************");
        System.out.print("*****************   New patient details    *******************\n" +
                "***********************************************************\n");

        System.out.print("Please enter your name: ");
        String name = scan.nextLine();

        System.out.print("Please enter your contact number: ");
        String contact = scan.nextLine();

        NewPatientRequest.put(name,contact);

        System.out.println("Information has been successfully input!\n" +
                "Please wait until Admin for your appointment!\n" +
                "Thank you for using the app!\n");
        homepage();
    }

    public static void showNewPatientAccountRequests(){
        System.out.println("These are the requested accounts: " + NewPatientRequest);
        editPatientInformation();
    }


}

