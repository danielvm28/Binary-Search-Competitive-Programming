package main;

import java.util.*;

/**
 * Solution for HackerEarth - Timely Orders
 */
public class TimelyOrders {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int q = s.nextInt();
        long sum = 0;
        ArrayList<Long> tArr = new ArrayList<Long>();
        ArrayList<Long> prefixSum = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int num = s.nextInt();
            int val = s.nextInt();
            long t = s.nextLong();

            if (num == 1) {
                sum += val;
                prefixSum.add(sum);
                tArr.add(t);
            } else {
                // Binary search for the desired t
                long goal = t - val;

                if (goal > tArr.get(tArr.size() - 1)) {
                    System.out.println(0);
                } else {
                    int high = tArr.size() - 1;
                    int low = -1;

                    while (high - low > 1) {
                        int mid = low + (high - low) / 2;

                        if (tArr.get(mid) >= goal) {
                            high = mid;
                        } else {
                            low = mid;
                        }
                    }

                    if (low != -1) {
                        System.out.println(prefixSum.get(prefixSum.size() - 1) - prefixSum.get(low));
                    } else {
                        System.out.println(prefixSum.get(prefixSum.size() - 1));
                    }
                }

            }
        }
    }
}
