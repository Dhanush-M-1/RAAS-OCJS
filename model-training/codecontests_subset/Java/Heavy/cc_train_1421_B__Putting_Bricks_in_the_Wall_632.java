import java.io.*;
import java.util.*;
public class runner {
   public static void main (String[] args) {
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       while(t-->0){
       int n=sc.nextInt();
       char[][] arr=new char[n][n];
       for(int i=0;i<n;i++)
       {
           String s=sc.next();
           for(int j=0;j<n;j++)
               arr[i][j]=s.charAt(j);
       }
       if(arr[0][1]==arr[1][0]&&arr[n-1][n-2]==arr[n-2][n-1]&&arr[0][1]!=arr[n-1][n-2])
       {
           System.out.println(0);
       }
       else if(arr[0][1]==arr[1][0])
       {
           if(arr[n-1][n-2]!=arr[n-2][n-1])
           {
                        System.out.println(1);
                        System.out.println(arr[n-1][n-2]==arr[0][1]?(n+" "+(n-1)):((n-1)+" "+n));    
           }
           if(arr[n-1][n-2]==arr[n-2][n-1]&&arr[n-1][n-2]==arr[0][1])
           {
                        System.out.println(2);
                        System.out.println(1+" "+2);
                        System.out.println(2+" "+1);
           }              
           
     }
       else if(arr[0][1]!=arr[1][0])
       {
           if(arr[n-1][n-2]==arr[n-2][n-1])
           {
               System.out.println(1);
               if(arr[0][1]==arr[n-1][n-2])
                   System.out.println(1+" "+2);
               else
                   System.out.println(2+" "+1);
           }
           if(arr[n-1][n-2]!=arr[n-2][n-1])
           {
               System.out.println(2);
               System.out.println(1+" "+2);
               arr[0][1]=arr[1][0];
               if(arr[n-1][n-2]==arr[0][1])
                      System.out.println(n+" "+(n-1));
               else
                   System.out.println((n-1)+" "+n);
           }
       }
       }
   }
}
       
       