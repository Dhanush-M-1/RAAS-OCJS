import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r1 = scn.nextInt();
		int r2 = scn.nextInt();
		int c1 = scn.nextInt();
		int c2 = scn.nextInt();
		int d1 = scn.nextInt();
		int d2 = scn.nextInt();
		int a = (r1+c1-d2)/2;
		int b = (r1+c2-d1)/2;
		int c = (r2+c1-d1)/2;
		int d = (r2+c2-d2)/2;
		if(a<1||a>9||a==b||a==c||a==d)
			System.out.println(-1);
		else if(b<1||b>9||b==c||b==d)
			System.out.println(-1);
		else if(c<1||c>9||c==d)
			System.out.println(-1);
		else if(d<1||d>9)
			System.out.println(-1);
		
		else
			if(a+b==r1&&c+d==r2&&a+c==c1&&b+d==c2&&a+d==d1&&b+c==d2)
			{
				System.out.println(a+" "+b);
				System.out.println(c+" "+d);
			}
			else 
				System.out.println(-1);
	}

}
		    	      	      	    	  			