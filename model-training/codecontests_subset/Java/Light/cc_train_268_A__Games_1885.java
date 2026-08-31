import java.util.Arrays;
import java.util.Scanner;
public class abdo  {
public static void main(String[] args){
Scanner abd = new Scanner(System.in);  
   int n=abd.nextInt();
   int[]w=new int[n];
   int[]x=new int[n];
   for(int i=0;i<n;i++){
       w[i]=abd.nextInt();
       x[i]=abd.nextInt();
   }
   Arrays.sort(x);
   Arrays.sort(w);
   int s=n-1,k=0,sum=0;
   for(int i=0;i<n;i++){    
       for(int j=0;j<n;j++){
         if(x[i]==w[j]){
           k++;
         }     
         }
     
   }
   System.out.println(k);
}}