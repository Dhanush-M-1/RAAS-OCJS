import java.util.Scanner;

public class P_20B {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double A = scan.nextDouble(), B = scan.nextDouble(), C = scan.nextDouble();
		double root1, root2, pred;
		
		if(A == 0 && B == 0) {
			if(C == 0)
				System.out.println("-1");
			else
				System.out.println("0");
		}
		else if(A == 0)
			System.out.println("1\n" + String.format("%.10f",(-C/B)).replace(",", "."));
		else if(B == 0) {
			if(C > 0)
				System.out.println("0");
			else if(C == 0)
				System.out.println("1\n" + String.format("%.10f", 0.0).replace(",", "."));
			else
				System.out.println("2\n" + 
						String.format("%.10f", -Math.sqrt(-C/A)).replace(",", ".") + "\n" + 
						String.format("%.10f", Math.sqrt(-C/A)).replace(",", "."));
		}
		else {
			pred = (B*B)-(4*(double)A*(double)C);
			if(pred < 0)
				System.out.println("0");
			else {
				root1 = (-B + Math.sqrt(pred))/(2*A);
				root2 = (-B - Math.sqrt(pred))/(2*A);
				if(root1 == root2)
					System.out.println("1\n" + String.format("%.10f", root1).replace(",", "."));
				else if(root1 > root2)
					System.out.println("2\n" + 
							String.format("%.10f", root2).replace(",", ".") + "\n" + 
							String.format("%.10f", root1).replace(",", "."));
				else
					System.out.println("2\n" + 
							String.format("%.10f", root1).replace(",", ".") + "\n" + 
							String.format("%.10f", root2).replace(",", "."));
			}
		}
	}
}
