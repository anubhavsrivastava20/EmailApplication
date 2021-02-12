package EmailApp;

import java.util.Scanner;

public class Email {
    //Properties to be added in Email App
    private String firstName;
    private String lastName;
    private String password;
    public String email;
    private String department;
    private int defaultPasswordlength = 6;
    private int mailboxCapacity =500;
    private String alternateEmail;
    private String companySuffix = "abccompany.com";

    //Constructor to receive First and Last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created : " + this.firstName + " " + this.lastName);

        //Call a method asking for department then return a department
        this.department = setDepartment();
        System.out.println("Department is : " + this.department);

        //Call a method asking for Random Password then return password
        this.password = randomPassword(defaultPasswordlength);
        System.out.println("Random Password is : " + this.password);

        //Combine Elements to generate Email
        email = firstName.toLowerCase() + "."+ lastName.toLowerCase()+"@"+department+"."+ companySuffix;
        System.out.println("Your Email is : "+ email);

    }
        //Ask for Department. making it Private Since it is only
    private String setDepartment() {
        System.out.print("Choose the Department codes :\n1 for Sales\n2 for Development \n3 for Accounting \n0 for None\n Enter the code : ");
        Scanner sc = new Scanner(System.in);
        int depCode = sc.nextInt();
        if (depCode == 1) {
            return "Sales";
        } else if (depCode == 2) {
            return "Development";
        } else if (depCode == 3) {
            return "Accounting";
        } else {
            return "None";
        }
    }

    //Ask for Random Password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&*";
        char [] password = new char[length];
        for (int i =0;i<length;i++){
            int rand = (int) (Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set Mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }

    //Set alternate Email Address
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }

    //Set Change Password
    public void setPassword(String changePass){
        this.password=changePass;
    }

    //Getting the Methods
    public int getMailboxCapacity(){
        return  mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    //Display all the details
    public String showInfo(){
        return "Name : " + firstName + " "+ lastName + "\nEmail : " + email + "\nMailbox Capacity : " + mailboxCapacity;
    }
}
