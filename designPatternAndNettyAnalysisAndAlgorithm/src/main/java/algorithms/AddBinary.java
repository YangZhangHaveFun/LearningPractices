package algorithms;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AddBinary {
//    Example 1:
//
//    Input: a = "11", b = "1"
//    Output: "100"
//    Example 2:
//
//    Input: a = "1010", b = "1011"
//    Output: "10101"
    public static String addBinary(String a, String b) {
        char[] array_a;
        char[] array_b;

        boolean aIsLonger = a.length() > b.length();
        if (aIsLonger) {
            array_a = reverse(a.toCharArray(), a.length());
            array_b = reverse(b.toCharArray(), b.length());
        } else {
            array_a = reverse(b.toCharArray(), b.length());
            array_b = reverse(a.toCharArray(), a.length());
        }

        StringBuilder result = new StringBuilder();
        char adder = '0';


        for (int i = 0; i < array_b.length; i++) {
            adder = addBinaryRecursive(array_a[i], array_b[i], adder, result);
        }

        int lengthDiff = array_a.length - array_b.length;

        for (int i = 0; i < lengthDiff; i++) {
            adder = addBinaryRecursive(array_a[i+array_b.length],'0', adder, result);
        }
        if (adder == '1'){
            result.insert(0, String.valueOf(1));
        }

        return result.toString();
    }

    private static char addBinaryRecursive(char a, char b, char adder, StringBuilder result){
        if (adder == '0'){
            if ((a == '1') && (b == '1'))  {
                result.insert(0, String.valueOf(0));
                return '1';
            } else if ((a == '0') && (b == '0')){
                result.insert(0, String.valueOf(0));
                return '0';
            } else {
                result.insert(0, String.valueOf(1));
                return '0';
            }
        } else {
            if ((a == '1') && (b == '1'))  {
                result.insert(0, String.valueOf(1));
                return '1';
            } else if ((a == '0') && (b == '0')){
                result.insert(0, String.valueOf(1));
                return '0';
            } else {
                result.insert(0, String.valueOf(0));
                return '1';
            }
        }
    }

    static char[] reverse(char a[], int n)
    {
        char i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
        return a;
    }

    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String a_1 = "100";
        String b_1 = "110010";

        System.out.println(addBinary(a_1, b_1));
    }
}
