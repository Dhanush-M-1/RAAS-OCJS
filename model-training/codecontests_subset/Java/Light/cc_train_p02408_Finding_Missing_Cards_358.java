import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			int n = sc.nextInt();
			int i;
			int j;

			String array[] = new String[52];

			for(i = 0; i < 52; i++) {

				if(i < 13) {
					array[i] = "S" + " " + (i + 1);
				} else if(i < 26) {
					array[i] = "H" + " " + (i + 1 - 13);
				} else if(i < 39) {
					array[i] = "C" + " " + (i + 1 - 26);
				} else {
					array[i] = "D" + " " + (i + 1 - 39);
				}

			}

			for(i = 0; i < n; i++) {

				String b = sc.next();
				int a = sc.nextInt();

				for(j = 0; j < 52; j++) {
					if(array[j].equals(b + " " + a)) {
						array[j] = "1";
					}
				}
			}

			for(i = 0; i < 52; i++) {
				if(array[i] != "1") {
					System.out.println(array[i]);
				}
			}

	}
}