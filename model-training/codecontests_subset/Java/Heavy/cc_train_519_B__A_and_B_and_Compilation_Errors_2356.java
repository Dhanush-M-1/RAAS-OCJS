import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n=scn.nextInt();
        int arr1[]=new int[n];
      
        for(int i=0;i<n;i++){
            arr1[i]=scn.nextInt();
          
        }
         int arr2[]=new int[n-1];
       
        for(int i=0;i<n-1;i++){
            arr2[i]=scn.nextInt();
           
        }
         int arr3[]=new int[n-2];
       
        for(int i=0;i<n-2;i++){
            arr3[i]=scn.nextInt();
            
        }
       Arrays.sort(arr1);
       Arrays.sort(arr2);
       Arrays.sort(arr3);
       
       int i=0;
       for( i=0;i<arr2.length;i++){
           if(arr1[i]!=arr2[i]){
               System.out.println(arr1[i]);
               break;
           }
       } 
       if(i==n-1){
            System.out.println(arr1[i]);
       }
        int j=0;
       for( j=0;j<arr3.length;j++){
           if(arr2[j]!=arr3[j]){
               System.out.println(arr2[j]);
               break;
           }
       } 
       if(j==n-2){
            System.out.println(arr2[j]);
       }
        
        
    }
   
}