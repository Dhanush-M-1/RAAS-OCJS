import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] c = new int[n-1];
        int result = 0;
        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0;i<n;i++){
            result += sc.nextInt();
        }
        for(int i = 0;i<(n-1);i++){
            c[i] = sc.nextInt();
        }for(int i = 1;i<n;i++){
            if(a[i] - a[i-1] == 1){
                result += c[a[i-1]-1];
            }
        }
        System.out.println(result);
        sc.close();
    }
}