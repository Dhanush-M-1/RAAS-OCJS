import java.util.Hashtable;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Hashtable<String, int[]> card = new Hashtable<String, int[]>();

		String[] priority = {"S", "H", "C", "D"};

		int[] s = new int[13];
		card.put("S", s);
		int[] h = new int[13];
		card.put("H", h);
		int[] c = new int[13];
		card.put("C", c);
		int[] d = new int[13];
		card.put("D", d);

		for(int i = 0; i < n; i++) {
			String name = scan.next();
			int value = scan.nextInt();
			card.get(name)[value - 1] = -1;
		}

		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				if(card.get(priority[i])[j] == 0) {
					System.out.println(priority[i] + " " + (j + 1));
				}
			}
		}

		scan.close();
	}
}
