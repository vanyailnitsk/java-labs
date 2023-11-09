package org.example.lr3;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchThread extends Thread {
    private Scanner scanner;
    private AtomicInteger count;

    public SearchThread(Scanner scanner, AtomicInteger atomicInteger) {
        this.scanner = scanner;
        this.count = atomicInteger;
    }

    @Override
    public void run() {
        synchronized (scanner) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                for (char ch : line.toCharArray()) {
                    if (ch == 'I' || ch == 'i') {
                        count.incrementAndGet();
                    }
                }
            }
        }

    }
}
