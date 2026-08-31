import java.util.Scanner;

public class WizardsandDemonstration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double n = in.nextDouble();
		double x = in.nextDouble();
		double y = in.nextDouble();
		double temp= Math.ceil(y*n/100);
		if(temp>x)
			System.out.println((int)(temp-x));
		else
			System.out.println(0);
	}

}
