import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int count = 0;
            while (x >= 10) {
                x = getMax(x);
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
    
    static int getMax(int x) {
        int max = 0;
        for (int i = 10; i <= x; i *= 10) {
            max = Math.max(max, (x / i) * (x % i));
        }
        return max;
    }
}
