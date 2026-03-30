package org.example.Scenario;

import org.example.Account;

import java.text.ParsePosition;
import java.util.Scanner;
class Amount{
        int balance=10000;
}

abstract class Insert{
    abstract void  insert_amount(Scanner sc);
        int amount;
        Amount am;
    Scanner sc;

    Insert(Amount am,Scanner sc)
    {
        this.am=am;
        this.sc=sc;
    }

}
class Deposit extends Insert{

    Deposit(Amount am,Scanner sc){
        super(am,sc);
    }
    void insert_amount(Scanner sc){
        System.out.println("Enter yhe amount: ");
        amount= sc.nextInt();
        System.out.println("The amount "+amount +" is deposited successfully ");

        am.balance+=amount;
    }
}

class Withdraw extends Insert{

    Withdraw(Amount am,Scanner sc){
        super(am,sc);
    }
    void insert_amount(Scanner sc){
        System.out.println("Enter the amount : ");
       int amount=sc.nextInt();
       if(am.balance>=amount) {
           System.out.println("The amount " + amount + " is withdrawed successfully");
           am.balance -= amount;
       }
       else{
           System.out.println("Insufficient balance");
       }
    }
}

class Check_Balance extends Insert{

    Check_Balance(Amount am,Scanner sc){
        super(am,sc);
    }
    void insert_amount(Scanner sc){}
    void show(){
      System.out.println("The balance is : " +am.balance);

    }
}

public class ATM_System {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
        Amount am=new Amount();
      Deposit deposit=new Deposit(am,sc);
       Withdraw withdraw=new Withdraw(am,sc);
       Check_Balance cb=new Check_Balance(am,sc);

        int try_attempt=3;


       while(true){
           System.out.println("Please select what you want to do: ");
           System.out.println("1.Check Balance");
           System.out.println("2.Deposit amount ");
           System.out.println("3.Withdraw amount");
           System.out.println("4.Exit");
           System.out.println();
           System.out.println("Enter your choice: ");
           int choice= sc.nextInt();

           switch(choice){
               case 1:
                   System.out.println("Please enter your pin number: ");
                   int pin=sc.nextInt();
                   if(pin==1357){
                       cb.show();
                   }
                   if(pin!=1357){
                       if(try_attempt>1){
                       System.out.println("Invalid pin.Please try again");
                       System.out.println("Attempt left: "+(try_attempt-1));
                       try_attempt-=1;
                       }
                       else{
                           System.out.println("Your account has been lock. Please try again after 24 hours.");
                       }
                   }

                   break;
               case 2:
                   deposit.insert_amount(sc);
                   break;
               case 3:
                   withdraw.insert_amount(sc);
                   break;
               case 4:
                   System.out.println("Exiting...");
                   return;
               default:
                   System.out.println("Invalid choice");
                   break;
           }
       }

    }
}
