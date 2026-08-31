import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int[][] v = new int[30][30];
        String s;
        long n = cin.nextLong();
        cin.nextLine();
        s = cin.nextLine();
        int len = s.length();
        for (int i = 1; i < len; i++) {
            int x1 = (int)s.charAt(i-1),x2 =  (int)s.charAt(i);
            v[x1-(int)'A'][x2-(int)'A']++;
        }
        int a = 0,b = 0;
        for (int i = 0; i <= 'Z'-'A'; i++)
            for (int j = 0; j <= 'Z'-'A'; j++)
                if (v[i][j] > v[a][b]) {
                    a = i;
                    b = j;
                }
        char tp = (char)(a+'A');
        System.out.print(tp);
        tp = (char)(b+'A');
        System.out.println(tp);
    }
}