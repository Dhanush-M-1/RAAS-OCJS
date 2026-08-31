//package er87;

import java.util.Scanner;

public class third {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			
			double n = 4*sc.nextInt();
			double r = 1/(2.0*Math.sin(Math.PI/n));
			double s = 2*(Math.sqrt((r*r)-(0.5*0.5)));
			System.out.println(r);
			
		}

	}

}
