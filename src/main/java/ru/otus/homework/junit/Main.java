package ru.otus.homework.junit;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        System.out.println(Arrays.toString(arrAfterLastOne(new int[] {2, 2, 3, 1, 2, 0})));
        System.out.println(onlyOneAndTwo(new int[] {2, 2, 1, 1, 2, 1}));
        System.out.println(onlyOneAndTwo(new int[] {3, 4, 5}));
        System.out.println(onlyOneAndTwo(new int[] {1, 1}));
    }

    public static int []  arrAfterLastOne(int [] a) throws Exception {
        for(int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 1) {
                System.out.println(a.length - i + "  " + a.length);
                return Arrays.copyOfRange(a, a.length - (a.length  - i - 1), a.length);
            }
        }

        throw new RuntimeException();
    }

    public static boolean onlyOneAndTwo(int[] a) {
        boolean oneExists = false;
        boolean twoExists = false;
        for(int i = a.length - 1; i >= 0; i--) {
            if (a[i] != 1 && a[i] != 2) {
                return false;
            }

            if (a[i] == 1) {
                oneExists = true;
            }

            if (a[i] == 2) {
                twoExists = true;
            }
        }

        return oneExists && twoExists;
    }
}