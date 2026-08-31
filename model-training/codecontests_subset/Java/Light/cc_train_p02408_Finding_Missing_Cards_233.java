import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String des[] = {"S", "H", "C", "D"};
		String str = ("");
		boolean have[][] = new boolean[des.length][13];
		int i, j, k;
		int num = 0;
		try (Scanner sc = new Scanner(System.in)) {
			for(j = 0; j < des.length; j++) {
				for(k = 0; k < 13; k++) {
					have[j][k] = true;
				}
			}
			int n = sc.nextInt();
			for(i = 0; i < n; i++) {
				str = sc.next();
				num = sc.nextInt() - 1;
				for(j = 0; j < des.length; j++) {
					for(k = 0; k < 13; k++) {
						if(des[j].equals(str) && num == k) {
						have[j][k] = false;
						}
					}
				}
			}
			for(j = 0; j < des.length; j++) {
				for(k = 0; k < 13; k++) {
					if(have[j][k]) {
						System.out.println(String.format(des[j] + " " + (k + 1)));
					}
				}
			}
		}
	}
}

