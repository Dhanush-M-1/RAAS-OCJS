//package practice1;
import java.lang.Math;
import java.util.Scanner;

public class Wizard {
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		
		
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		//System.out.println(n+ "      "+x+"    "+y);
		int result;
		double b=(y*n)/100.0;
		int a= (int) Math.ceil(b);
		//System.out.println(a+" "+b);
		result=a-x;
		System.out.println(result<0?0:result);
		
       
    }

}
