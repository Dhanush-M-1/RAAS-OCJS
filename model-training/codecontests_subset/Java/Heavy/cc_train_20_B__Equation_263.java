import java.util.Scanner;
public class equation {
    public static void main(String[] args) {
        double k,w,x,a=100000.0,b=100000.0,u;
        Scanner sc = new Scanner(System.in);
        u = sc.nextDouble();
        w = sc.nextDouble();
        x = sc.nextDouble();
        k=(double)((w*w)-4.000000*u*x);
        if(u==0&&w==0&&x==0)
            System.out.print("-1");
        else if((u==0 && w==0)||k<0)
            System.out.print("0");
        else if(u==0)
            {a=(double)((0-x))/w;
                System.out.print("1\n"+a+"00000");
            }
        else            if(k>0.0)
        {
            a=(-w+Math.sqrt(k))/(2.0*u);
            b=(-w-Math.sqrt(k))/(2.0*u);
            if(a<b)System.out.print("2\n"+a+"0000000\n"+b+"000000");
            else System.out.print("2\n"+b+"000000\n"+a+"000000");
        }
        else if(k==0.0)
             {
                a=-w/(2.0*u);
                System.out.print("1\n"+a+"00000");
             }
            
        
    }
}

