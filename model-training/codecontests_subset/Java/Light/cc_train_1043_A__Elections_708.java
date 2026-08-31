import java.util.*;
import java.lang.*;
import java.io.*;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int sum=0;
        for (int i=0;i<n;i++){
            int c = sc.nextInt();
            if (c>max) max=c;
            sum+=c;
        }
        int ans = (int) Math.ceil((double) (sum*2+1)/n);
        if (ans>max) System.out.println(ans);
        else System.out.println(max);
    }
}
