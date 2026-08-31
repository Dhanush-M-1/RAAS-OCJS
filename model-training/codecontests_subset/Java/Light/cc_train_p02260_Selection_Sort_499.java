import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int N[] = new int[n];
		int count = 0;
		int minj = 0;
		
		for (int k = 0; k <= n - 1; k++) {
			int x = scanner.nextInt();
			N[k] = x;
		} //ここまでで配列に要素を入れる
		
        for (int i = 0; i <= n - 1; i++) {
        	minj = i;
            for (int j = i; j <= n - 1; j++) {
                if (N[j] < N[minj]) {
                    minj = j;
                }
            }
            int a = N[i];
            N[i] = N[minj];
            N[minj] = a;
        if (minj != i) {
        	count++;
        }
        }
		for (int k = 0; k < n - 1; k++) {
			System.out.print (N[k] + " ");
			}
		System.out.println (N[n - 1]);
        System.out.println(count);
        }
}
