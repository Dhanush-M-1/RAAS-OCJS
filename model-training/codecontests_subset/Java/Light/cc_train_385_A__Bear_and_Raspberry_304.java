import java.util.*;
import java.lang.*;
import java.io.*;

public class CodeForces {
    public static void main(String []args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int max=Integer.MIN_VALUE;
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n-1; i++){
            if(a[i]-a[i+1]>max){
                max=a[i]-a[i+1];
            }
        }
        if(max>0 && max-c>0){
            int result = max-c;
            System.out.println(result);
        }else{
            System.out.println("0");
        }
    }
}