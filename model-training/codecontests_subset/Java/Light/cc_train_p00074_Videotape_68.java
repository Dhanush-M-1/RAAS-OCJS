import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	private Scanner sc;

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			String[] nico = sc.nextLine().split(" ");
			int t = Integer.parseInt(nico[0]);
			int h = Integer.parseInt(nico[1]);
			int s = Integer.parseInt(nico[2]);
			if ((t == -1) && (h == -1) && (s == -1)) break;

			int r1 = 7200 - (t * 3600 + h * 60 + s);
			int r3 = r1 * 3;
			
			DecimalFormat df = new DecimalFormat("00");
			System.out.println(df.format(r1 / 3600) + ":" + df.format(r1 % 3600 / 60) + ":" + df.format(r1 % 60));
			System.out.println(df.format(r3 / 3600) + ":" + df.format(r3 % 3600 / 60) + ":" + df.format(r3 % 60));
		}
	}
}