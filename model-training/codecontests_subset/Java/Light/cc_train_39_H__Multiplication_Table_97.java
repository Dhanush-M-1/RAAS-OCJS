import java.util.*;
// warm-up
public class MultiplicationTable {

	static void solve() {
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		for (int i=1; i<k; i++) {
			for (int j=1; j<k; j++) {
				System.out.print(Integer.toString(i*j,k)+" ");
			}
			System.out.println();
		}
		sc.close();	
	}

	public static void main(String args[]) {
		solve();
	}

}
