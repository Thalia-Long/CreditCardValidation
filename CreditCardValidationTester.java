/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creditcardvalidation;

import java.util.Scanner;

/**
 *
 * @author Hien Long
 */
public class CreditCardValidationTester {

    public static void main(String[] args) {

        Validation v = new Validation();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer: ");
        long input = keyboard.nextLong();
        v.check(input);

    }

}
