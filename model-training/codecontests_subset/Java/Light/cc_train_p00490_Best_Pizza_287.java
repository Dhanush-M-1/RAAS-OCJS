import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc = new Scanner (System.in);

		//トッピングの種類の数を入力
		int n = sc.nextInt();

		//生地の値段を入力
		int a = sc.nextInt();

		//トッピングの値段を入力
		int b = sc.nextInt();

		//生地のカロリーを入力
		int c = sc.nextInt();

		//トッピングのカロリーの配列
		int [] d = new int [n];

		//for文用変数
		int i, j;

		//降順ソート用変数
		int temp;

		//カロリーの最大値用変数
		int max = 0;

		//カロリー用変数
		int calorie;

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

		//「最高のピザ」のカロリー数を求める
		for (i = 0; i < n; i++) {

			//カロリーの合計用変数を宣言・初期化
			int sum = 0;

			for (j = 0; j < i; j++) {

				//カロリーの合計
				sum += d[j];

				//生地とトッピングの組み合わせのカロリー数の計算
				calorie = (c + sum) / (a + i * b);

				//最大値を求める
				if (max < calorie) {
					max = calorie;
				}
			}
		}

		//「最高のピザ」のカロリー数を出力
		System.out.println(max);

	}

}