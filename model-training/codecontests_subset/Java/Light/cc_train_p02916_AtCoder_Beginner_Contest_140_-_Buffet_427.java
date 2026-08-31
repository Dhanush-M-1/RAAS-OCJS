import java.util.Scanner;

// https://atcoder.jp/contests/abc140/tasks/abc140_b
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arrayA = makeArray(sc,N);
		int[] arrayB = makeArray(sc,N);
		int[] arrayC = makeArray(sc,N-1);
		sc.close();


		int ans = 0;
		for(int i:arrayA) {
			ans = ans + arrayB[i-1];
			if((i-1)>0&&arrayA[i-1]==arrayA[i-2]+1) {
				ans = ans + arrayC[arrayA[i-2]-1];
			}
		}

		System.out.println(ans);

	}

	public static int[] makeArray(Scanner sc,int N) {
		int[] array = new int[N];
		for(int i=0;i<N;i++) {
			array[i] = sc.nextInt();
		}
		return array;
	}

}
