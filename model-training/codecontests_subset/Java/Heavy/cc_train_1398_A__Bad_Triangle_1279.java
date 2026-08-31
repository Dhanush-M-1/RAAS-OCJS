import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        int[] res=new int[test];
        for(int i=0;i<test;i++){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int j=0;j<n;j++){
                a[j]=sc.nextInt();
            }
            if(a[0]+a[1]>a[n-1]){
                res[i]=-1;
            }else{
                res[i]=n;
            }
        }
        for(int i=0;i<test;i++){
            if(res[i]==-1){
                System.out.println(-1);
            }else{
                System.out.println("1"+" 2"+" "+res[i]);
            }
        }
    }
}