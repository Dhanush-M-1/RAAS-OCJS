import java.util.*;
public class Velas{
	public static void main (String[]args){	
		Scanner sc = new Scanner(System.in);
		double a = sc.nextInt();
		double b = sc.nextInt();
		double s = 0;
		s = s + a;
		while ((a/b) >=0.2){
			a = a/b;
			s = s + a;
		}
		Double d = new Double(s);
		int i = d.intValue();
		System.out.println(i);
	}
}