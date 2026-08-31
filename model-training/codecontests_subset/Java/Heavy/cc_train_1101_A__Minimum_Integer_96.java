import static java.lang.Math.ceil;
import static java.lang.Math.max;
import static java.lang.Math.sqrt;
 import java.util.Scanner;
    public class prob2 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            long t;
            t=input.nextInt();
               int n,a,b,m=0,l,r,d,sum=0,sum1=0,sum2=0;
             while(t-->0){
                l=input.nextInt();
                 r=input.nextInt();
                    d=input.nextInt();
                if(l>d){
                    System.out.println(d);}
                else{
                    sum=r+d;
                    sum1=r%d;
                    sum2=sum-sum1;
                     System.out.println(sum2);}         
    }
    
    }
   }

         
            
          
  
          
  
            
       