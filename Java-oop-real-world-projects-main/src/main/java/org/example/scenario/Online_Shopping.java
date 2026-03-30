package org.example.Scenario;

import java.util.ArrayList;
import java.util.Scanner;

class Product{
    int id;
    String name;
    double price;
    Product(int id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public String toString(){
        return id+ " - " +name + " - $"+ price;
    }
}

class ShoppingCart {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Product> cart = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ShoppingCart() {
        products.add(new Product(1, "Shampoo", 19));
        products.add(new Product(2, "Soap", 20));
        products.add(new Product(3, "Handwash", 25));
        products.add(new Product(4, "Hair Dryer", 35));

    }

    void showProduct() {
        System.out.println("\nAvailable products : ");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty");
            return;
        }
        double total = 0;
        System.out.println("\nCart items: ");
        for (Product p : cart) {
            System.out.println(p);
            total += p.price;

        }
        System.out.println("Total amount = $ " + total);
    }

    void selectProduct() {
        while (true) {
            showProduct();
            System.out.println("\nEnter Product ID (0 to Exit) ");
            int id = sc.nextInt();

            if (id == 0) break;

            Product selected = null;

            for (Product p : products) {
                if (p.id == id) {
                    selected = p;
                    break;
                }
            }
            if (selected == null) {
                System.out.println("Invalid Product ID! ");
                continue;
            }
            System.out.println("\n 1. Add to Cart");
            System.out.println("2. Buy Now");
            System.out.println("3. View Cart");
            System.out.println("4. Cancel");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    cart.add(selected);
                    System.out.println(selected.name + " added to cart");
                    break;
                case 2:
                    processPayment(selected.price);
                    break;
                case 3:
                    showCart();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }

    void processPayment(double amount) {
        System.out.println("Selected Payment Method: ");
        System.out.println("1. Card");
        System.out.println("2. Cash on Delivery");

        int pay = sc.nextInt();

        switch (pay) {
            case 1:
                sc.nextLine();
                System.out.println("Enter 4-digit Card Number:");
                String card = sc.nextLine();

                System.out.println("Enter 3-digit Number:");
                String pin = sc.nextLine();

                if (card.length() == 4 && pin.length() == 3) {
                    System.out.println("Payment Successful!");

                } else {
                    System.out.println("Invalid Card Details.");
                }
                break;
            case 2:
                System.out.println("Order placed with Cash on Delivery.");
                break;
            default:
                System.out.println("Invalid Payment Method!");
        }
    }
}
public class Online_Shopping {
    public static void main(String[] args) {
            ShoppingCart cart=new ShoppingCart();
            cart.selectProduct();

        }
    }
