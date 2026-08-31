

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
public static double sqrtt(double x)  
{  
    if(x<0) return -Math.sqrt(-x);  
    else return Math.sqrt(x);  
}  
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
        int flag=0,count=0;
       if(a==0&&b==0) {  
            if(c==0) System.out.println("-1");
            else System.out.println("0"); 
        }  
        else if(a==0&&c==0) {  
            System.out.println("1");
            System.out.println("0");
        }  
        else if(b==0&&c==0) {  
           System.out.println("1");
           System.out.println("0"); 
        }  
        else if(a==0) {  
            System.out.println("1");
            System.out.format("%.6f\n",-c/b);  
        }  
        else {  
            double tem=b*b-4*a*c;  
            if(tem<0) System.out.println("0");  
            else if(tem==0) {  
                System.out.println("1");
                System.out.format("%.6f\n",(-b/(2*a)));  
            }  
            else {  
                System.out.println("2"); 
               double x1=(-b-sqrtt(tem))/(2*a);  
               double x2=(-b+sqrtt(tem))/(2*a);  
                if(x1>x2) {
                    double t=x1;
                    x1=x2;
                    x2=t;
                }  
                System.out.format("%.6f\n%.6f\n",x1,x2);  
            }  
       
    }
    }
}

