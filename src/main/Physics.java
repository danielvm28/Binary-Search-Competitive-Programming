package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.*;

/**
 * Solution for Codeforces - Physics Practical - 253B
 */
public class Physics {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("input.txt"));
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("output.txt"))));

        int n = s.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(s.nextInt());
        }

        Collections.sort(arr);

        if (2*arr.get(0) >= arr.get(arr.size()-1)) {
            br.write(0 + "");
            br.flush();

        } else {

            int ans = Integer.MAX_VALUE;

            for (int min = 0; min < arr.size(); min++) {
                int high = arr.size();
                int low = 0;
    
                while (high - low > 1) {
                    int mid = low + (high-low)/2;
    
                    if (2*arr.get(min) >= arr.get(mid)) {
                        low = mid;
                    } else if(2*arr.get(min) < arr.get(mid)) {
                        high = mid;
                    }
                }

                ans = Math.min(ans, (n-high) + min);
            }

            br.write(ans + "");
            br.flush();
        }

        br.close();
    }
}