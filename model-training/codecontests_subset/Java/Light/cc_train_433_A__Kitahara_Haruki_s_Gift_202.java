import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        Scanner sc = new Scanner(inputStreamReader);
        int n = sc.nextInt();
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < n; ++i){
            int k = sc.nextInt();
            if (k == 200) ++n2;
            else ++n1;
        }
        sc.close();
        int S = n2*2 + n1;
        if (S%2 != 0) System.out.println("NO");
        else if ((n2%2 != 0)&&(n1 == 0)) System.out.println("NO");
        else System.out.println("YES");
    }
}
