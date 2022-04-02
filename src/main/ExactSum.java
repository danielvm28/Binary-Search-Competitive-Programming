package main;

import java.util.*;

/**
 * Solution for Online Judge - Exact Sum
 */
public class ExactSum {
    public static Scanner s = new Scanner(System.in);

    public static boolean f(int x, int goal) {
        return x >= goal;
    }

    public static int binSearch(int[] books, int goal, int start) {
        int right = books.length - 1;
        int left = start;

        while (right - left > 1) {
            int mid = (right + left) / 2;

            if (f(books[mid], goal)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int n = 0;

        while (s.hasNext()) {
            n = Integer.parseInt(s.next());

            int[] books = new int[n];

            for (int i = 0; i < n; i++) {
                books[i] = Integer.parseInt(s.next());
            }

            int money = Integer.parseInt(s.next());

            Arrays.sort(books);

            int bestI = 0;
            int bestJ = 0;

            for (int i = 0; i < books.length; i++) {
                int currI = books[i];
                int currJ = books[binSearch(books, money - currI, i)];

                if (currI + currJ == money) {
                    bestI = currI;
                    bestJ = currJ;
                }

                if (books[i] > money/2) {
                    break;
                }
            }

            System.out.printf("Peter should buy books whose prices are %d and %d.\n\n", bestI , bestJ);
        }
    }
}