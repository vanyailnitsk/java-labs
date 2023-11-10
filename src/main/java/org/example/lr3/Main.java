package org.example.lr3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        String fileName = "text.txt";
        long start = System.currentTimeMillis();
        int oneThreadResult = oneThreadSearch(fileName);
        System.out.println("Время поиска в однопоточном режиме: "+(System.currentTimeMillis() - start)+" мс");
        System.out.println("Результат поиска в однопоточном режиме: "+oneThreadResult);
        long startConcurrent = System.currentTimeMillis();
        int multiThreadResult = multiThreadSearch("text.txt");
        System.out.println("Время поиска в многопоточном режиме: "+(System.currentTimeMillis()-startConcurrent)+" мс");
        System.out.println("Результат поиска в многопоточном режиме: "+multiThreadResult);
    }

    public static int oneThreadSearch(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("text.txt");
        Scanner fileReader = new Scanner(is);
        int counter = 0;
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            for (char ch : line.toCharArray()) {
                if (ch == 'I' || ch == 'i') {
                    counter++;
                }
            }
        }
        fileReader.close();
        return counter;
    }
    public static int multiThreadSearch(String fileName)  {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        AtomicInteger count = new AtomicInteger(0);
        SearchThread[] threads = new SearchThread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SearchThread(i+"",reader,count);
            threads[i].start();
        }

        try {
            for (SearchThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count.get();
    }
}
