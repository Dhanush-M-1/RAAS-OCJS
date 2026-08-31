//package round616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] parts = br.readLine().split(" ");
            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            int leftIndx = 0;
            while (leftIndx < n) {
                if (arr[leftIndx] < leftIndx) {
                    leftIndx--;
                    break;
                }
                leftIndx++;
            }

            int rightIndx = n - 1;
            while (rightIndx >= 0) {
                if (arr[rightIndx] < n-1-rightIndx) {
                    rightIndx++;
                    break;
                }
                rightIndx--;
            }
            if (leftIndx >= rightIndx) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
