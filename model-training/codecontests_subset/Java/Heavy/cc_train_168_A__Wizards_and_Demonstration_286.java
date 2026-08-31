
import java.util.Scanner;


public class Wizard {
    public static void main(String args []){
        Scanner input = new Scanner(System.in);
        int n,x,y,res,r;
        double a,b,c,y1,n1;
        n=input.nextInt();
        x=input.nextInt();
        y=input.nextInt();
        y1=(double)y;
        n1=(double)n;
        a=(y1/100);
        b=n1*a;
        c=(int)b;
        if(b>c){
            b=b+1.00;
        }
        r=(int)b;
        res=r-x;
        if(res>0){
            System.out.println(res);
            
        }
        else
        {
            System.out.println(0);
        }
        
        
        
        
    }
    
}
