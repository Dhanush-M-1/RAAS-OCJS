import java.io.*;
import java.util.*;

public class Day9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());
        for(int q = 0; q < t; ++q){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int a1 = a;
            int b1 = b;
            int c1 = c;
            int ans = 0;
            while(a1 > 0 && b1 > 1){
                ans += 3;
                a1--;
                b1-=2;
            }
            while(b1 > 0 && c1 > 1){
                ans += 3;
                b1--;
                c1 -= 2;
            }
            int counter = 0;
            while(b > 0 && c > 1){
                counter += 3;
                b--;
                c -= 2;
            }
            while(a > 0 && b > 1){
                counter += 3;
                a--;
                b-=2;
            }
            writer.println(Math.max(counter, ans));
        }
        writer.close();
    }
}