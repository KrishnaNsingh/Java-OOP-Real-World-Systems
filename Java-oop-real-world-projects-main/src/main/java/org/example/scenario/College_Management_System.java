package org.example.Scenario;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class Student{
    String name;
    LocalDate date;
    int age;
    long PhoneNo;
    String address;
    long AadarNo;
    double percentage;
    int marks;
    String field;
    int attendedClasses = 0;
    int totalClasses = 24;

    String[][] subject=new String[6][5];


    public String toString(){
        return "Name: " + name + " | Field: " + field + " | Age: " + age;
    }
}
class Admission{
    void enrollStudent(Student s,Scanner sc){
        System.out.println("Enter Student nane: ");
        s.name=sc.nextLine();

        System.out.println("Enter DOB(dd-MM-yyyy):");
        String inputdate=sc.nextLine();
        DateTimeFormatter formated=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        s.date=LocalDate.parse(inputdate,formated);

        System.out.println("Enter Age :");
        s.age= sc.nextInt();

        System.out.println("Enter Phone no:");
        s.PhoneNo=sc.nextLong();
        sc.nextLine();

        System.out.println("Enter Address: ");
        s.address=sc.nextLine();

        System.out.println("Enter Aadhar no: ");
        s.AadarNo=sc.nextLong();
        sc.nextLine();

        System.out.println("Enter percentage: ");
        s.percentage=sc.nextDouble();

        System.out.println("Enter Marks: ");
        s.marks=sc.nextInt();

        System.out.println("Enter Field: ");
        sc.nextLine();
        s.field=sc.nextLine();
    }

}
class Fee{
    void fee_structure(Student s,Scanner sc){
        String field;
        String rupees= "\u20B9";
        while(true) {
            System.out.println("Please select the fee-stucture: ");
            System.out.println("1. Full Payment.");
            System.out.println("2. Installments : ");
            System.out.println("3.Exit");
            System.out.println("Enter your choice: ");
            int select = sc.nextInt();
            sc.nextLine();
            int amount=0;
            switch (select){
                case 1:
                    amount=getFullAmount(s.field);
                    System.out.println("Amount: "+ rupees +" " + amount);
                    payment(sc);
                    break;
                case 2:
                        amount=getInstallmentAmount(s.field);
                        System.out.println("Installment Amount: "+ rupees + " " + amount);
                        payment(sc);
                        break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    int getFullAmount(String field){
        if(field.equalsIgnoreCase("Science")) return 35000;
        if(field.equalsIgnoreCase("Commerce")) return 24000;
        if(field.equalsIgnoreCase("Arts")) return 21000;
        return 0;

    }
    int getInstallmentAmount(String field){
        if(field.equalsIgnoreCase("Science")) return 20000;
        if(field.equalsIgnoreCase("Commerce")) return 10000;
        if(field.equalsIgnoreCase("Arts")) return 10000;
        return 0;
    }
   //Fee Payment method
   void payment(Scanner sc){
        while(true) {
            System.out.println("Please choose the payment method: ");
            System.out.println("1.UPI Payment:");
            System.out.println("2.Cheque Payment");
            System.out.println("3.Cash Payment");
            System.out.println("4.Exit");
            System.out.println("Enter your choose: ");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Please pay on this number :2341789605");
                    System.out.println("Payment successfull");
                    return;
                case 2:
                    System.out.println("Check accepted!");
                    return;
                case 3:
                    System.out.println("Cash received!");
                    return;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice! ");

            }
        }
   }
}
class Faculty{

    Attendance at;
    Timetable tb;
    Communication cn;
    String name;
    String qualification;
    int age;
    String address;
    Faculty(){
        this.at=new Attendance();
        this.tb=new Timetable();
        this.cn=new Communication();

    }
    void duty(Student s,Scanner sc){
        while(true){
            System.out.println("Please choose from the following: ");
            System.out.println("1.Attendance.");
            System.out.println("2.Timetable.");
            System.out.println("3.Communicate with parents.");
            System.out.println("4.Exit.");
            int select=sc.nextInt();
            sc.nextLine();
            switch(select){
                case 1:
                    at.markAttendance(s,sc);
                    break;
                case 2:
                    tb.operations(s,sc);
                    break;
                case 3:
                    cn.communicate(s,sc);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }

        }
    }
}
class Attendance {
    void markAttendance(Student s,Scanner sc) {

        while (true) {
            System.out.println("1.Mark Attendance.");
            System.out.println("2.Calculate percentage");
            System.out.println("3.Exit.");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Attendance:(P/A) : ");
                    sc.nextLine();
                    String attend = sc.nextLine();
                    if (attend.equalsIgnoreCase("P")) {
                        s.attendedClasses++;
                        break;
                    }
                    if(attend.equalsIgnoreCase("A")){
                        break;
                    }
                    break;
                case 2:
                    double percentage=((double)s.attendedClasses/s.totalClasses)*100;
                    System.out.println("The student has attended : "+ percentage + " % ");
                    if(percentage>=75){
                        System.out.println("Student can attend the exam.");
                    }
                    else{
                        System.out.println("Student cannot attend the exam!");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
class Timetable{
     void operations(Student s,Scanner sc){
         while(true){
             System.out.println("1.Create Timetable.");
             System.out.println("2.Update Timetable.");
             System.out.println("3.Display Timetable");
             System.out.println("4.Exit.");
             System.out.println("Enter your choice: ");
             int choice=sc.nextInt();
             sc.nextLine();
             switch(choice){
                 case 1:
                     for(int i=0;i<6;i++){
                         for(int j=0;j<5;j++){
                             System.out.print("Enter subject for Day " + i + " Period " + j + ": ");
                             s.subject[i][j]=sc.nextLine();
                         }
                         System.out.println();
                     }
                     System.out.println(Arrays.deepToString(s.subject));
                     break;
                 case 2:
                     while (true) {
                         System.out.println("\n1.Update Entry");
                         System.out.println("2.Exit Update");
                         int select = sc.nextInt();
                         sc.nextLine();

                         if (select == 2) break;

                         System.out.print("Enter row: ");
                         int i = sc.nextInt();

                         System.out.print("Enter column: ");
                         int j = sc.nextInt();
                         sc.nextLine();

                         if (i >= 0 && i < 6 && j >= 0 && j < 5) {
                             System.out.print("Enter new subject: ");
                             s.subject[i][j] = sc.nextLine();
                         } else {
                             System.out.println("Invalid index!");
                         }
                     }
                     break;
                 case 3:
                      System.out.println(Arrays.deepToString(s.subject));
                      break;
                 case 4:
                     return;
                 default:
                     System.out.println("Invalid choice!");
             }
         }
     }
}
class Communication{
        void communicate(Student s,Scanner sc){
            while(true){
                System.out.println("1.Send Notification.");
                System.out.println("2.Exit.");
                System.out.println("Enter your choice: ");
                int choice=sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Enter your message to " + s.name +" parents");
                        String  data=sc.nextLine();
                        System.out.println("The message is send to "+s.name + " parents");

                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
}

public class College_Management_System {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> list=new ArrayList<>();
        Admission admission=new Admission();
        Fee fee=new Fee();
        Faculty fc=new Faculty();
        while(true){
            int index;
            System.out.println("1.Admission process.");
            System.out.println("2.Fee Payment.");
            System.out.println("3.Faculty.");
            System.out.println("4.Students");
            System.out.println("5.Exit.");
            System.out.println("Enter your choice: ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    Student s1=new Student();
                    admission.enrollStudent(s1,sc);
                    list.add(s1);
                    break;
                case 2:
                    if(list.isEmpty()){
                        System.out.println("No student available!");
                        break;
                    }
                    System.out.println("Select student Index for Fee Payment: ");
                    for(int i=0;i<list.size();i++){
                        System.out.println(i+ " -> " + list.get(i).name);
                    }
                     index= sc.nextInt();
                    sc.nextLine();

                    if(index>= 0 && index< list.size()){
                        fee.fee_structure(list.get(index),sc);
                    }
                    else{
                        System.out.println("Invalid student selection!");
                    }
                    break;
                case 3:
                    if(list.isEmpty()){
                        System.out.println("No students available!");
                        break;
                    }

                    System.out.println("Select Student for Faculty Actions:");

                    for(int i = 0; i < list.size(); i++){
                        System.out.println(i + " -> " + list.get(i).name);
                    }

                    index = sc.nextInt();
                    sc.nextLine();

                    if(index >= 0 && index < list.size()){
                        fc.duty(list.get(index), sc);
                    } else {
                        System.out.println("Invalid student selection!");
                    }
                      break;
                case 4:
                    System.out.println("Student available : ");
                    for(Student s:list){
                        System.out.println(s);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid chocie!");

            }
        }
    }
}
