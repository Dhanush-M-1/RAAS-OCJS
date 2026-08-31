import java.util.Scanner;

public class CommonSubsequence1382A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		
		for (int i = 0; i < n; i++) {
			int a1 = in.nextInt();
			int a2 = in.nextInt();
			
			int[] n1 = new int[a1];
			int[] n2 = new int[a2];
			for (int j = 0; j < a1; j++) {
				n1[j] = in.nextInt();
			}
			boolean ok = false;
			for (int j2 = 0; j2 < a2; j2++) {
				int a= in.nextInt();
				for (int j = 0; j < a1; j++) {
					if (n1[j] == a) {
						if (!ok) {
							System.out.println("YES");
							System.out.println("1 "+ a);
							ok = true;
							break;
						}
					}
				}
				
			}	
			if (!ok) {
				System.out.println("NO");
			}

			
		}
			
	}
}