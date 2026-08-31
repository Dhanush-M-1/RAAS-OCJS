import java.util.*;
import java.lang.Math;

public class main{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        double A = s.nextDouble();
        double B = s.nextDouble();
        double C = s.nextDouble();
        double D = B*B - 4*A*C;
        if(A==0 && B==0 && C==0) System.out.println(-1);
        else if((A==0 && B==0) || D<0 ) System.out.println(0);
        else if(A==0){
            System.out.println(1);
            System.out.printf("%.5f",-(1*C)/(double)B);
        }else{
            if(D==0){
                System.out.println(1);
                System.out.printf("%.5f",-(1*B)/(2*A));
            }else{
                double a = (-1*B + Math.sqrt(D))/(2*A);
                double b = (-1*B - Math.sqrt(D))/(2*A);
                System.out.println(2);
                System.out.printf("%.5f\n",Math.min(a,b));
                System.out.printf("%.5f",Math.max(a,b));
            }
        }
    }
}
   