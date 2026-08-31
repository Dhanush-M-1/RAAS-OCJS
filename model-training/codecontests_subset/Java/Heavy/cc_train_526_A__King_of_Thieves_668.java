import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] x = str.toCharArray();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                boolean ch = true;
                for (int k = 0; k < 5; k++) {
                    int pos = i + j * k;
                    if (pos >= n || x[pos] != '*') {
                        ch = false;
                        break;
                    }
                }
                if (ch) {
                    flag++;
                }
            }
        }
        if (flag == 0) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }
}