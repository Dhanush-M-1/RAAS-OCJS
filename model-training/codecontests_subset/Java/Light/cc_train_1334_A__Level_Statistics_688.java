import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
       
       int t=scn.nextInt();
         while(t>0){
             int n=scn.nextInt();
             int arr[][]=new int[n][2];
             for(int i=0;i<n;i++){
                 arr[i][0]=scn.nextInt();
                 arr[i][1]=scn.nextInt();
             }
             int i=1;
             if(arr[0][0]<arr[0][1]){
                 System.out.println("NO");
             }
             else{
             for( i=1;i<n;i++){
                 if(arr[i][0]<arr[i][1]){
                     System.out.println("NO");
                     break;
                 }
                 if(arr[i][0]<arr[i-1][0]){
                      System.out.println("NO");
                       break;
                 }
                 if(arr[i][1]<arr[i-1][1]){
                      System.out.println("NO");
                       break;
                 }
                 if(arr[i][1]>arr[i-1][1]){
                     int d=arr[i][1]-arr[i-1][1];
                     if(arr[i][0]<arr[i-1][0]+d){
                         System.out.println("NO");
                         break;
                     }
                 }
             }
             if(i==n){
                 System.out.println("YES");
             }
             }
             t--;
         }
               
    }
}
