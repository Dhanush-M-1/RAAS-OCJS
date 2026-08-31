import java.io.*; 
import java.util.*; 
public class lask{
    public static void main(String args[]) 
    { 
       Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
         int a[]=new int[n];
         int b[]=new int[n];
         int i;
         for(i=0;i<n;i++){
             a[i]=sc.nextInt();
             b[i]=sc.nextInt();
         }
         int max=a[0];
         int sum=0;
         for(i=1;i<n-1;i++){
             if(a[i]-b[i]>max){
                 sum++;
                 max=a[i];
             }
             else if(a[i]+b[i]<a[i+1]){
                 sum++;
                 max=a[i]+b[i];
             }
             else{
                 max=a[i];
             }
         }
         if(n==1)
         System.out.println("1");
         else
         System.out.println(sum+2);
          
      }
     
            
    
} 