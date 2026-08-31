import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in= new Scanner (System.in);
		double n=in.nextDouble();
		double x=in.nextDouble();
		double y=in.nextDouble();
		double a=n/100;
		double b=Math.ceil(a*y);
		if (b<=x) {
			System.out.println("0");
		} else {
			double r=b-x;
			
			System.out.println((int)r);
		}
	}

}