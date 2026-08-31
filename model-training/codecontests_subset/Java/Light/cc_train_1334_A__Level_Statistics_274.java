import java.util.Scanner;

public class CF1334PA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while ( t-- != 0) {
			int n = in.nextInt();
			int p[] = new int[n];
			int c[] = new int[n];
			
			for ( int i=0; i<n; i++) {
				p[i] = in.nextInt();
				c[i] = in.nextInt();
			}
			
			int plays = p[0];
			int clears = c[0];
			boolean flag = true;
			if ( clears > plays ) {
				flag = false;
			}
			for ( int i=1; i<n; i++) {
				if ( p[i] < plays || c[i] < clears) {
					flag = false;
					break;
				}
				if ( c[i] > clears && p[i] == plays) {
					flag = false;
					break;
				}
				if ( p[i] > plays && c[i] > clears && (p[i]-plays < c[i]-clears)) {
					flag = false;
					break;
				}
				plays = p[i];
				clears = c[i];
			}
			
			String res = flag == true ? "YES" : "NO";
			System.out.println(res);
		}

	}

}
