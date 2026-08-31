import java.util.Scanner;


public class AAndBAndCompilationErrors {

 
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     int x=input.nextInt();
     int[] a= new int[x];
     int sum=0;
     int sum1=0;
     int sum2=0;
     for(int i=0 ; i<x ; i++)
     {
         a[i]=input.nextInt();
         sum=sum+a[i];
     }
     int[] w = new int[x-1];
        for(int j=0 ; j<x-1 ; j++)
     {
         w[j]=input.nextInt();
         sum1=sum1+w[j];
     }
          int[] z = new int[x-2];
        for(int j=0 ; j<x-2 ; j++)
     {
         z[j]=input.nextInt();
         sum2=sum2+z[j];
     }
        int ww=sum-sum1;
        int zz=sum1-sum2;
        System.out.println(ww);
        System.out.println(zz);
        
     
     
    }
    
}
