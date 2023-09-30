package org.example.lr1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner - это штука, которая считывает данные с потока (System.in - консоль)
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble(); // Например считать double
        System.out.print("y = ");
        double y = in.nextDouble();
        System.out.print("d = ");
        double d = in.nextDouble();
        double numerator = Math.pow(Math.cos(y),3)+Math.pow(2,x)*d;
        double denominator = Math.pow(Math.E,y)+Math.log(Math.pow(Math.sin(x),2)+7.4);
        double result = numerator/denominator;
        System.out.println("Result is: "+result);
        int alphabetNumber = (int) (result*9); // 9 - номер варианта, на который надо умножить
        System.out.println("Number in alphabet: "+alphabetNumber);
        String str = String.valueOf(alphabetNumber); // Приведение числа к строке
        String italianAlphabet = "ABCDEFGHILMNOPQRSTUVZ"; // Тут должен быть алфавит по варианту
        PrintWriter pw = new PrintWriter("output.txt"); // PrintWriter записывает в файл
        for (char c : str.toCharArray()) { // цикл по символам строки
            char letter = italianAlphabet.charAt((int)c-'0'); // Тут берется буква по номеру в алфавите
            System.out.print(letter+" ");
            pw.print(letter);
        }
        pw.close();
    }
}