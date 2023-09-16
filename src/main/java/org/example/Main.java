package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        System.out.print("y = ");
        double y = in.nextDouble();
        System.out.print("d = ");
        double d = in.nextDouble();
        double numerator = Math.pow(Math.cos(y),3)+Math.pow(2,x)*d;
        double denominator = Math.pow(Math.E,y)+Math.log(Math.pow(Math.sin(x),2)+7.4);
        double result = numerator/denominator;
        int alphabetNumber = (int) (result*9);
        System.out.println("Result is: "+(int)result);
        System.out.println("Number for alphabet: "+alphabetNumber);
        String str = String.valueOf(alphabetNumber);
        String italianAlphabet = "ABCDEFGHILMNOPQRSTUVZ";
        PrintWriter pw = new PrintWriter("output.txt");
        for (char c : str.toCharArray()) {
            char letter = italianAlphabet.charAt((int)c-'0');
            System.out.print(letter+" ");
            pw.println(letter);
        }
        pw.close();
    }
}