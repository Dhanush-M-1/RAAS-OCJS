import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new java.util.Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int b = 0;
        int[] c = new int[n - 1];
        int d = 0;
        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
        }
        for(int i = 0; i < n; i++){
            b = b + scan.nextInt();
        }
        for(int i = 0; i < n - 1; i++){
            c[i] = scan.nextInt();
        }
        for(int i = 0; i < n - 1; i++){
            if(a[i] + 1 == a[i + 1]){
                d = d + c[a[i] - 1];
            }
        }
        System.out.println(b + d);
    }
}