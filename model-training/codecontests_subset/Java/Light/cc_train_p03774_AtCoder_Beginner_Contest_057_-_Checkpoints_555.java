import java.util.*;
public class Main{
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int N = sc.nextInt();
   int M = sc.nextInt();
   int[] a= new int[N];
   int[] b= new int[N];
   for(int i=0;i<N;i++)
   {
     a[i]=sc.nextInt();
     b[i]=sc.nextInt();
   }
   int[] x= new int[M];
   int[] y= new int[M];
   for(int i=0;i<M;i++)
   {
     x[i]=sc.nextInt();
     y[i]=sc.nextInt();
   }
   int anstmp=1;
   int tmp;
   for(int i = 0;i<N;i++)
   {
     anstmp=1;
     tmp = Math.abs(a[i]-x[0])+Math.abs(b[i]-y[0]);
     for(int k = 1;k<M;k++)
     {
       if(tmp>Math.abs(a[i]-x[k])+Math.abs(b[i]-y[k])) 
       {
         tmp = Math.abs(a[i]-x[k])+Math.abs(b[i]-y[k]);
         anstmp = k+1;
       }
     }
   System.out.println(anstmp);     
   }
 }
}