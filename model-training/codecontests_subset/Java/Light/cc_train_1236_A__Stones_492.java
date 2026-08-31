import java.util.*;
import java.math.*;
public class Main{
        public static void main(String [] args){
	Scanner sc=new Scanner(System.in);
      
       int t=sc.nextInt();
       while(t-->0){
                  int a=sc.nextInt();
                         int b=sc.nextInt();       int c=sc.nextInt();
                         int ans=0;
                         int t1=c/2;
                         int min1=Math.min(b, t1);
                         ans+=min1*3;
                         b=b-min1;
                         if(b>0){
                             int min2=Math.min(a, b/2);
                             ans+=min2*3;
                         }
                         System.out.println(ans);
                         
                         
       }
       
          
       
           
       
      
      
}
}