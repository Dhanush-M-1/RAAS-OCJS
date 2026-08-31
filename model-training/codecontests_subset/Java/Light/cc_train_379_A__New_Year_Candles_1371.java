
import java.util.Scanner;


public class NewYearCandles {

   
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        int a,b;
        
        a=input.nextInt();
        b=input.nextInt();
        
        
        int sum=a;
        int div=0;
        int rem=0;
        
        
            while(a >= b)
            {
        div = a / b;
        sum += div;
        rem = a % b;
        a = div + rem;
            }
             System.out.println(sum);
        
        
       
        
    }
    
}