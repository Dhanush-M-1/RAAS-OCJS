import java.io.*;
import java.util.*;
public class sol {
   public static void main(String args[] )  {
      try{
      Scanner scan=new Scanner(System.in);
      int t=scan.nextInt();
      while(t-->0){
         int k=scan.nextInt();
         int n=scan.nextInt();
         int m=scan.nextInt();
         int previous =-1;
         int[] a=new int[n];
         int[] b=new int[m];
         for(int i=0;i<n;i++)a[i]=scan.nextInt();
         for(int i=0;i<m;i++)b[i]=scan.nextInt();
         int i=0,j=0;
         boolean x=true;
         List<Integer> list=new ArrayList<>();
         while(i<n && j<m){
            if(a[i]<b[j]){
               if(a[i]>k){
                  x=false;
                  break;
               }else{
                  if(a[i]==0)k++;
                  list.add(a[i]);
               }
               i++;
            }else{
               if(b[j]>k){
                  x=false;
                  break;
               }else{
                  if(b[j]==0)k++;
                  list.add(b[j]);
               }
               j++;
            }
         }
         if(x==false){
            System.out.println(-1);
         }else{
            while(i<n){
               if(a[i]==0){
                  list.add(0);
                  k++;
               }
               else if(a[i]>k){
                  x=false;
                  break;
               }
               else list.add(a[i]);
               i++;
            }
            if(x==true)
            while(j<m){
               if(b[j]==0){
                  list.add(0);
                  k++;
               }
               else if(b[j]>k){
                  x=false;
                  break;
               }
               else list.add(b[j]);
               j++;
            }
            if(x==false)System.out.println(-1);
            else {
               for(int ii: list)System.out.print(ii+" ");
               System.out.println();
            }
         }
      }
   }catch(Exception e){
      return;
   }
   }


}