import java.util.Scanner;

public class Task1 {
		int r1;
		int r2;
		int c1;
		int c2;
		int d1;
		int d2;
	
	public static void main (String[] args) {
		Task1 mt=new Task1();
		Scanner theIn=new Scanner(System.in);
		mt.r1=theIn.nextInt();
		
		mt.r2=theIn.nextInt();
		
		mt.c1=theIn.nextInt();
		
		mt.c2=theIn.nextInt();
		
		mt.d1=theIn.nextInt();
		
		mt.d2=theIn.nextInt();
		
		if ((mt.d2<=0) || (mt.d1<=0) || (mt.c2<=0) || (mt.c1<=0) ||  (mt.r2<=0) || (mt.r1<=0)) {
			System.out.println("-1");
			return;
		}
		
		int a;
		int b;
		int c;
		int d;
		
		if (!(mt.r1+mt.r2==mt.c1+mt.c2)) {
			System.out.println("-1");
			return;
		};
		
		a=(mt.d1+mt.c1-mt.r2)/2;
		if ((a*2)!=(mt.d1+mt.c1-mt.r2)) {
			System.out.println("-1");
			return;
		}
		b=(2*mt.r1-mt.d1-mt.c1+mt.r2)/2;
		if ((b*2)!=(2*mt.r1-mt.d1-mt.c1+mt.r2)) {
			System.out.println("-1");
			return;
		}
		c=(mt.c1-mt.d1+mt.r2)/2;
		if ((c*2)!=(mt.c1-mt.d1+mt.r2)) {
			System.out.println("-1");
			return;
		}
		d=(mt.r2-mt.c1+mt.d1)/2;
		if ((d*2)!=(mt.r2-mt.c1+mt.d1)) {
			System.out.println("-1");
			return;
		}
		
		if (!((a==b)|| (a==c) || (a==d) || (b==c) || (b==d) || (c==d)) && (a>0) && (b>0) && (c>0) && (d>0) && (a<=9) && (b<=9) && (c<=9) && (d<=9)) {
			System.out.println(a+" "+b);
			System.out.println(c+" "+d);
		} else {
			System.out.println("-1");
			return;
		}
	}
}