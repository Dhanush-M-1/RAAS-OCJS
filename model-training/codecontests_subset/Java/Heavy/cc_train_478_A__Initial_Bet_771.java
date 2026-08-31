import java.util.*;
import java.io.*;
public class Cf273a {
    public static void main(String[] args) throws IOException {
        InputStreamReader fin = new InputStreamReader(System.in);
        Scanner scr = new Scanner(fin);
        int [] c = new int [5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            c[i] = scr.nextInt();
            sum += c[i];
        }
        int b = -1;
        int sum1 = 0;
        int sum2 = 0;
        if (sum%5 == 0 && sum != 0) {
            b = sum/5;
            for (int i = 0; i < 5; i++) {
                if (c[i] > b)
                    sum1 += c[i] - b;
                else if (c[i] < b) 
                    sum2 += b - c[i];
            }
            if (sum1 != sum2)
                b = -1;
        }
        PrintWriter fout = new PrintWriter(System.out);
        fout.print(b);
        fout.flush();
        fout.close();
    }
}