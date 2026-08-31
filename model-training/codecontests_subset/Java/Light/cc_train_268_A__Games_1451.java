import java.util.Scanner;


public class Task268a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] h = new int [n];
		int [] g = new int [n];
		
		for (int i = 0; i < n; i++) {
			h[i] = in.nextInt();
			g[i] = in.nextInt();
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {			
				if (i != j && h[i] == g[j]) {
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
