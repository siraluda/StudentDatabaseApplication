package com.studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentID;
    private String courses;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id= 1000;

    // Scanner util


    // Constructor: prompt user to add student name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextLine();

        setStudentID();
    }

    // Generate an ID
    private void setStudentID(){
        // Grade level + ID
        int numberID = id + (900 * (int) Math.random());
        this.studentID = this.gradeYear + "" + numberID;
    }

    // Enroll in courses
    public void enroll(){
        do {
            System.out.println("Enter course to enroll (Enter Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();

            //preferred way of comparing strings
            if (!course.equals("Q")){
                this.courses += "\n\t" + course;
                this.tuitionBalance += costOfCourse;
            } else {
                break;
            }
        } while (true);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + this.tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewBalance();

        System.out.print("Enter payment amount: ");
        Scanner in  = new Scanner(System.in);
        int amount = in.nextInt();
        this.tuitionBalance -= amount;
    }

    // Show info
    public String showInfo(){

        return  "Name: " + this.firstName + " " + this.lastName +
                "\nGrade level: " + this.gradeYear +
                "\nStudent ID: " + this.studentID +
                "\nCourse enrolled: " + this.courses +
                "\nBalance: $" + this.tuitionBalance;
    }
}
