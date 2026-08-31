import java.util.Scanner;
public class Main{
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   int N = sc.nextInt();
   int[] A = new int[N];
   for(int i=0;i<N;i++ )
   {
     A[i]  = sc.nextInt();
   }
   int[] B = new int[N];
   for(int i=0;i<N;i++ )
   {
     B[i]  = sc.nextInt();
   }
      int[] C = new int[N-1];
   for(int i=0;i<N-1;i++ )
   {
     C[i]  = sc.nextInt();
   }
   int count=0;
   int total = 0;
   for(int i = 0; i<N ; i++)
   {

     if(i>=1 && A[i-1] +1 == A[i])
     {
      total = total+ B[A[i]-1] +C[A[i] -2];
      
     }
     else
     {
      total += B[A[i]-1];
       
     }  

   }
   
System.out.println(total);   
   
 }
}