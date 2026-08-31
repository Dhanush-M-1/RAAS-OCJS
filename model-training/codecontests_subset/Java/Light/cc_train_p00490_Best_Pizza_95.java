import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc = new Scanner (System.in);


		//トッピングの種類の数・生地の値段・トッピングの値段・生地のカロリーを入力
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		//トッピングのカロリー用配列
		int [] d = new int [n];

		//ループ・ソート用
		int i, j;
		int temp;

		//カロリー計算・カロリーの最大値用
		int calorie;
		int max = 0;

		//トッピングのカロリーを入力
		for (i = 0; i < n; i++) {
			d[i] = sc.nextInt();
		}
		
		//トッピングのカロリーを降順にソート
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (d[i] < d[j]) {
					temp = d[i];
					d[i] = d[j];
					d[j] = temp;
				}
			}
		}
		
		//「最高のピザ」を求めて出力
		if (n == 0) {
			System.out.println(a);
		} else {
			for (i = 0; i < n; i++) {
				int sum = c;
				for (j = 0; j < i; j++) {
					sum += d[j];
					calorie = (int) (sum / (a + i * b));
					if (max < calorie) {
						max = calorie;
					}
				}
			}
			System.out.println(max);
		}

	}

}