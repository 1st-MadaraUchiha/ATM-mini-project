package com.atm;

import java.util.Scanner;

public class Main {
    private static long acc;
    private static int pin;

    public static void main(String[] args) {
        System.out.println("Enter Account number");
        Scanner sc = new Scanner(System.in);
        acc = sc.nextLong();
        System.out.println("Enter pin");
        Scanner sc1 = new Scanner(System.in);
        pin = sc1.nextInt();
        Transactions tx = new Transactions(acc,pin);
        }

    }
