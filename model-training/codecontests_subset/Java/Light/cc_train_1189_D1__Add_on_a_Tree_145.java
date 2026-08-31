import java.util.Scanner;

public class TaskD {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] deg = new int[n];
		for(int i=0;i<n-1;i++) {
			int a = s.nextInt()-1;
			int b = s.nextInt()-1;
			deg[a]++;
			deg[b]++;
		}
		for(int i=0;i<n;i++) {
			if(deg[i] == 2) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
