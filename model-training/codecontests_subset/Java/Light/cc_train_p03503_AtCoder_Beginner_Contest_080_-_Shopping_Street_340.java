import java.util.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] shopOpenData = new int[n][10];
        int[][] shopProfitData = new int[n][11];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                shopOpenData[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                shopProfitData[i][j] = sc.nextInt();
            }
        }
        
        int max = -1000000000;
        for (int i = 1; i < 1024; i++) {
            String binaryNumber = Integer.toBinaryString(i);
            while (binaryNumber.length() < 10) {
                binaryNumber = "0" + binaryNumber;
            }
            
            int[] shopOpenCount = new int[n];
            
            for (int j = 0; j < 10; j++) {
                int k = Integer.parseInt(String.valueOf(binaryNumber.charAt(j)));
                if (k == 1) {
                    for (int h = 0; h < n; h++) {
                        if (shopOpenData[h][j] == 1) shopOpenCount[h]++;
                    }
                }
            }
            
            int profit = 0;
            for (int j = 0; j < n; j++) {
                profit += shopProfitData[j][shopOpenCount[j]];
            }
            
            max = Math.max(max, profit);
        }
        
        System.out.println(max);
    }
}
