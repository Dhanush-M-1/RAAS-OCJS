import java.util.*;
public class Equaton {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double a=sc.nextDouble(),b=sc.nextDouble(),c=sc.nextDouble();
		double d= b*b -4*a*c;
		if(d<0 || a==0&&b==0&&c!=0)System.out.println(0);
		else if(a==0 && b!=0 ) {
			double x= (-c)/b;
			System.out.println(1);
			if(x==(-0))System.out.println(0);
			else System.out.println(x);
		}else if(a==0 && b==0 && c==0)System.out.println(-1);
		else if(d==0) {
			System.out.println(1);
			double x=(-b)/(2*a);
			if(x==-0)System.out.println(0);
			else System.out.println(x);
		}else if(d>0) {
			double x1= (-(b)-(Math.sqrt(d)))/(2*a),x2=(-(b)+(Math.sqrt(d)))/(2*a);
			System.out.println(2);
			if(x1==-0) {
				x1=0;
			}else if(x2==-0)x2=0;
			else if(x1==-0 && x2==-0) {
				x1=0;x2=0;
			}
			System.out.println(Math.min(x1, x2));
			System.out.println(Math.max(x1, x2));
		}
	}

}
