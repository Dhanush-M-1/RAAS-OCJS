import java.awt.image.LookupOp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Fibonacci {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 0;test<t;test++) {
            String[] input = br.readLine().split(" ");
            int a =Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);
            n=n%3;
            if(n==0){
                System.out.println(a);
            }else if(n==1){
                System.out.println(b);
            }else if(n==2) {
                    System.out.println(a^b);
                }
            }
    }
}
