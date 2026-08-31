import java.util.*;
public class help{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int r1=in.nextInt();
		int r2=in.nextInt();
		int c1=in.nextInt();
		int c2=in.nextInt();
		int d1=in.nextInt();
		int d2=in.nextInt();

		int d=(c2+r2-d2)/2;
		int a=d1-d;
		int c=r2-d;
		int b=d2-c;

		if(a<1||a>9||b<1||b>9||c<1||c>9||d<1||d>9||a==b||a==c||a==d||b==c||b==d||c==d||a+b!=r1||c+d!=r2||a+c!=c1||b+d!=c2||a+d!=d1||b+c!=d2){
			System.out.println(-1);
		}
		else{
			System.out.println(a+" "+b);
			System.out.println(c+" "+d);	
		}
		
	}
}