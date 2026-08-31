import java.io.*;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream output = new PrintStream(new BufferedOutputStream(System.out));

        int n = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[4];
        for(int i = 0; i < 4; i++){
            a[i] = input.nextInt();
        }
        if(k < n + 1 || n == 4){
            output.println(-1);
            output.close();
            System.exit(0);
        }

        output.print(a[0] + " " + a[2] + " ");
        for(int i = 1; i <= n; i++){
            if(i == a[0] || i == a[1] || i == a[2] || i == a[3]){
                continue;
            }
            output.print(i + " ");
        }
        output.println(a[3] + " " + a[1]);

        output.print(a[2] + " " + a[0] + " ");
        for(int i = 1; i <= n; i++){
            if(i == a[0] || i == a[1] || i == a[2] || i == a[3]){
                continue;
            }
            output.print(i + " ");
        }
        output.println(a[1] + " " + a[3]);

        output.close();
    }
}