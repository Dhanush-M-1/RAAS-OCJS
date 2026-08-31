import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] S = new int[N + 1];

		for(int i = 1 ; i <= N ; i++){
			S[i] = sc.nextInt();
		}
		sc.close();

		int ans = 0;
		for(int i = 1 ; i <= N ; i++){
			ans+=S[i]-1;
		}
		System.out.println(ans);
	}

}
