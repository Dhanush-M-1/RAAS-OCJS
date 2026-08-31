import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            double a = scan.nextDouble();
            double l = scan.nextDouble();
            double x = scan.nextDouble();
            System.out.printf("%.9f\n",Helon(a,l,l) + 2*Helon(l,(l+x)/2.0,(l+x)/2.0));
        }
    }
    
    public static double Helon(double a,double b,double c){
    	double m = 0;
    	double s = (a+b+c)/2.0;
    	m = Math.sqrt(s*(s-a)*(s-b)*(s-c));
    	return m;
    }
}