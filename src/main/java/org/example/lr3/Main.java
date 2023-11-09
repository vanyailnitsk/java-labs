package org.example.lr3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("text.txt");
        long start = System.currentTimeMillis();
        int oneThreadResult = oneThreadSearch(is);
        System.out.println("Время поиска в однопоточном режиме: "+(System.currentTimeMillis() - start));
        System.out.println("Результат поиска в однопоточном режиме: "+oneThreadResult);
        is.close();
        is = classloader.getResourceAsStream("text.txt");
        long startConcurrent = System.currentTimeMillis();
        int multiThreadResult = multiThreadSearch(is);
        System.out.println("Время поиска в однопоточном режиме: "+(System.currentTimeMillis()-startConcurrent));
        System.out.println("Результат поиска в многопоточном режиме: "+multiThreadResult);
    }

    public static int oneThreadSearch(InputStream is) {
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
    public static int multiThreadSearch(InputStream is) {
        Scanner fileReader = new Scanner(is);
        AtomicInteger count = new AtomicInteger(0);
        SearchThread[] threads = new SearchThread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SearchThread(fileReader,count);
            threads[i].start();
        }
        try {
            for(SearchThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return count.get();
    }
}
