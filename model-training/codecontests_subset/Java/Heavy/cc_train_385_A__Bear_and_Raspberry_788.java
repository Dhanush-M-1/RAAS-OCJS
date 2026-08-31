import java.util.*;
import java.io.*;

    public class Solution {
      public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        int a[]=new int[n];
        
        //List<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++){
           a[i]=sc.nextInt();
        }
        int ans=0;
        for(int i=0;i<n-1;i++){
          if(a[i]>a[i+1]){
              ans=Math.max(a[i]-a[i+1],ans);
          }
        }
        if(ans-c<=0){
          System.out.println(0);
        }
        else{
          System.out.println(ans-c);
        }
        
        
      }
    }
