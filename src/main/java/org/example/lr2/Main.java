package org.example.lr2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Object> map = new HashMap<>();
        Random random = new Random();
        int[] numsArray = new int[100];
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numsArray[i] = 1 + random.nextInt(100);
            numsList.add(1 + random.nextInt(100));
        }
        map.put("array", numsArray);
        map.put("list", numsList);
        int[] sortedArray = cocktailSort(numsArray);
        List<Integer> sortedList = cocktailSort(numsList);
        System.out.println("Массив до сортировки: "+Arrays.toString((int[])map.get("array")));
        System.out.println("Массив после сортировки: "+Arrays.toString(sortedArray));
        System.out.println("Список до сортировки: "+ map.get("list"));
        System.out.println("Список после сортировки: "+ sortedList);
    }

    public static int[] cocktailSort(int[] nums) {
        int[] a = Arrays.copyOf(nums,nums.length);
        boolean swapped = true;
        int start = 0;
        int end = a.length;
        while (swapped) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
        return a;
    }
    public static List<Integer> cocktailSort(List<Integer> nums) {
        List<Integer> a = new ArrayList<>(nums);
        boolean swapped = true;
        int start = 0;
        int end = a.size();
        while (swapped) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (a.get(i) > a.get(i + 1)) {
                    int temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (a.get(i) > a.get(i + 1)) {
                    int temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    swapped = true;
                }
            }
            start = start + 1;
        }
        return a;
    }
}