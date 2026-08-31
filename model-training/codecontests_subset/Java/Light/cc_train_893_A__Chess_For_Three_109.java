import java.util.Scanner;

//http://codeforces.com/contest/893/problem/A
public class Chess43 {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int spec = 3;
	int n =s.nextInt();
	for (int i = 0; i < n; i++) {
		int winner = s.nextInt();
		if(winner == spec) {
			System.out.println("NO");
			return;
		}
		spec = 6-spec-winner;
	}
	System.out.println("YES");
}
}
