import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by olymp1 on 12.01.2018.
 */
public class ww {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int b[] = new int [n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);
        for (int i = n - 1; i >= 0 ; i--) {
            if (k % b[i] == 0) {
                pw.print(k / b[i]);
                break;
            }
        }
        pw.close();
        }
    }
