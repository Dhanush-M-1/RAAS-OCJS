import java.util.Scanner;

public class WizardsAndDemonstration {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		short n = scanner.nextShort();
		short w = scanner.nextShort();
		short p = scanner.nextShort();
		int r = (int)(Math.ceil(((p*n)/100.0)));
		System.out.println(r > w ? r - w : 0);
		scanner.close();
	}
}