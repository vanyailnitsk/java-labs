package org.example.lr3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchThread extends Thread {
    private BufferedReader reader;
    private AtomicInteger count;

    public SearchThread(String name, BufferedReader reader, AtomicInteger atomicInteger) {
        super(name);
        this.reader = reader;
        this.count = atomicInteger;
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (ch == 'I' || ch == 'i') {
                        count.incrementAndGet();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
