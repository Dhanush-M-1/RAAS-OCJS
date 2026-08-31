/* +_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+
   +_+_+_+ Captain Levi's Code +_+_+_+_+_+_+_+_+
   +_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+  */

   import java.util.*;
   import java.io.*;

   public class codeforces{
       public static void main(String[] args){

        int i,j,k,n,t,store,flag,ans;
        Scanner sc = new Scanner(System.in);
        double sum;
        n = sc.nextInt();
        k = sc.nextInt();
        store = sc.nextInt();

        sum = 0;
        sum = Math.ceil((double)(store*n)/100);

        if(k>sum)
        System.out.println("0");
        else
        System.out.println((int)(sum-k));
       
       }
   }