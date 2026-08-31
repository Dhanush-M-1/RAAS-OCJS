import java.io.*;
import java.util.*;
public class Sol{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int ar[] = new int[n];
      int ar1[] = new int[n-1];
      int ar2[] = new int[n-2];
      long sum = 0, sum1 = 0, sum2 = 0;
      for(int i=0; i<n; i++) {
         ar[i] = sc.nextInt();
         sum += ar[i]; 
      }
      for(int i=0; i<n-1; i++) {
         ar1[i] = sc.nextInt();
         sum1 += ar1[i];
      }
      for(int i=0; i<n-2; i++) {
         ar2[i] = sc.nextInt();
         sum2 += ar2[i];
      }
      System.out.println(sum - sum1);
      System.out.println(sum1 - sum2);
   }
}