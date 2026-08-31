import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().solve(new Scanner(System.in));
	}

	public void solve(Scanner sc) {
		int n = Integer.parseInt(sc.next());
		int answer = 0;
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(sc.next());
			answer += a-1;
		}
		
		System.out.println(answer);
	}
}