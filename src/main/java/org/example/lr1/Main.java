package org.example.lr1;

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
        System.out.println("Result is: "+result);
        int alphabetNumber = (int) (result*9);
        System.out.println("Number in alphabet: "+alphabetNumber);
        String str = String.valueOf(alphabetNumber);
        String italianAlphabet = "ABCDEFGHILMNOPQRSTUVZ";
        PrintWriter pw = new PrintWriter("output.txt");
        for (char c : str.toCharArray()) {
            int pos =  (int)c-'0';
            if (pos == 0) {
                pw.print("_"); // Не соответствует алфавиту
            }
            else {
                char letter = italianAlphabet.charAt(pos-1);
                System.out.print(letter+" ");
                pw.print(letter);
            }
        }
        pw.close();
    }
}