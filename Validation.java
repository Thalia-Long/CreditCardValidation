/*
 * Validate credit card using Luhn algorithm
 * 
 */
package creditcardvalidation;

import java.util.ArrayList;

/**
 *
 * @author Hien Long
 */
public class Validation {

    private static ArrayList<Integer> numList1; //numList1 contains every second digit from right to left
    private static ArrayList<Integer> numList2; //numList2 contains all digits in the odd places from right to left

    boolean isValid = false;

    /**
     * Checking if the input is valid
     *
     * @param num: credit card number
     */
    public void check(long num) {

        String cardNum = String.valueOf(num);
        int sum;
        isValid = isValid(num);

        if (isValid == false) {
            System.out.println("Invalid Card Number!");
        } else {
            sum = sumOfDoubleEvenPlace(num) + sumOfOddPlace(num);

            if (sum % 10 == 0) {

                System.out.println(num + " is Valid!");
            } else {

                System.out.println(num + " is Invalid!");
            }
        }

    }

    /**
     * Checking if the input is valid by checking the length, and the leading
     * digit of the credit card number
     *
     * @param num is the credit card number
     * @return true if the credit card number is valid, and false otherwise
     */
    public boolean isValid(long num) {
        boolean valid;
        int size;
        size = getSize(num);
        String cardNum = String.valueOf(num);
        if (size < 13 || size > 16) {
            valid = false;
            System.out.println("Invalid Input! The length of credit card number cannot be less than 13, or greater than 16.");
        } 
        else if (prefixMatched(num, 4)
                || prefixMatched(num,5)
                || prefixMatched(num,6)
                || prefixMatched(num,37)) {
            valid = true;
        } 
        else {  
            valid = false;
            System.out.println(num + " is InValid!");
        }
        return valid;
    }

    public static int sumOfDoubleEvenPlace(long number) {

        int temp;
        int sum = 0;
        String cardNum = String.valueOf(number);
        numList1 = new ArrayList<>();
        int j = cardNum.length(); //The index to keep track of every second digit from right to left
        
        //Loop through the String and find the responding numbers
        for (int i = cardNum.length(); i > 0; i--) {
            //Store every second digit from right to left in ArrayList numList1
            if (j - 2 >= 0) {

                temp = Character.getNumericValue(cardNum.charAt(j - 2));
                numList1.add(temp * 2);
                j = j - 2;
            }
        }
        //Loop through the ArrayList and add all the digits together
        for (int i = 0; i < numList1.size(); i++) {
    
            int numb = getDigit(numList1.get(i));
          
            sum = sum + numb;
        }
        return sum;
    }

    /**
     * Return this number if it is a single digit, otherwise, return the sum of
     * the two digits
     */
    public static int getDigit(int number) {
        int num = number;
        if (num > 9) {
            int a = num / 10;
            int b = num % 10;

            num = a + b;
        }
        return num;

    }

    /**
     * Return sum of odd-place digits in number
     *
     * @param number: credit card number
     * @return the sum of all digit in odd places from right to left
     */
    public static int sumOfOddPlace(long number) {
        int temp;
        int sum = 0;
        String cardNum = String.valueOf(number);
        numList2 = new ArrayList<>();
        int k = cardNum.length(); //The index to keep track of every odd place digit from right to left
        
        //Store every odd place digit from right to left in ArrayList numList2
        for (int i = cardNum.length(); i > 0; i--) {
            if ((k - 1) % 2 == 1) {

                temp = Character.getNumericValue(cardNum.charAt(k - 1));
                numList2.add(temp);
                k = k - 2;
            }
        }
        for (int i = 0; i < numList2.size(); i++) {
            sum = sum + numList2.get(i);
        }
        return sum;
    }

    /**
     * Return true if the digit d is a prefix for number
     *
     * @param number: credit card number
     * @param d: the prefix digit
     * @return true if the prefix digit match the prefix for number
     */
    public static boolean prefixMatched(long number, int d) {

        String numb = String.valueOf(number);
        String dnum = String.valueOf(d);
        int i = dnum.length();
        numb = numb.substring(0, i);

        return numb.equals(dnum);
    }

    /**
     * Return the number of digits in d
     */
    public static int getSize(long d) {

        String cardNum = String.valueOf(d);
        return cardNum.length();

    }

    /**
     * Return the first k number of digits from number. If the number of digits
     * in number is less than k, return number.
     */
    public static long getPrefix(long number, int k) {
        long prefix = 0;
        String numb = String.valueOf(number);
        String prefixString;
        if (numb.length() < k) {
            prefix = number;
        } else {

            prefixString = numb.substring(0, k);
            prefix = Long.parseLong(prefixString);

        }
        return prefix;
    }

}
