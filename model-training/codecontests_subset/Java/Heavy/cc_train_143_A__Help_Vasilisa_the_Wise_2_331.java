import java.util.Scanner;

public class CF999div2A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int r1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			int d1 = sc.nextInt();
			int d2 = sc.nextInt();
			int a,b,c,d ;
			a=(r1+c1-d2)/2;
			b=(r1+d2-c1)/2;
			c=(c1+d2-r1)/2;
			d=(d1+c2-r1)/2;
			if(a<1 |a>9 |b<1 |b>9|c<1|c>9 |d<1|d>9)
			 System.out.println("-1");
			else if(a==b | a==c |a==d | b==c |b==d|c==d  ) 
				System.out.println("-1");
			else if(a+b!=r1 | c+d!=r2 | a+c!=c1 |b+d!=c2 |a+d!=d1 |b+c!=d2) 
				System.out.println("-1");
 			else     
 				System.out.println(a+" "+b +"\n"+c+" "+d);			
		
	}
}
