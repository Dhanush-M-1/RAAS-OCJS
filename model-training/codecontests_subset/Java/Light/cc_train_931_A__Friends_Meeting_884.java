import java.util.*;

public class JavaApplication60 {

    
    public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        int a,b,diff,n,sum=0;
        a=Sc.nextInt();
        b=Sc.nextInt();
        
        diff=Math.abs(a-b);
        n=diff/2;
        
        if(diff==1)
        {
            System.out.println(1);
        }
        else if(diff>1)
        {
            sum=(n)*(n+1);
            if(diff%2!=0)
            {
                sum=sum+n+1;
               
            }
             System.out.println(sum);
        }
       
    }
    
}
