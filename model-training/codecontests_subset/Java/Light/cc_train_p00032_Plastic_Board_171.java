import java.util.*;

public class Main {
	private int rect = 0, lozen = 0;

	public static void main(String[] args) {
		new Main().run();
	}
	
	private void run() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			String[] st = str.split(",");
			int num[] = new int[3];
			for (int i = 0; i < 3; i++) {
				num[i] = Integer.parseInt(st[i]);
			}
			
			if (num[0] != num[1]) {
				if (num[0] * num[0] + num[1] * num[1] == num[2] * num[2]) rect++;
			}else {
				lozen++;
			}
			//debug();
		}
		debug();
	}
	
	private void debug() {
		System.out.println(rect);
		System.out.println(lozen);
	}

}