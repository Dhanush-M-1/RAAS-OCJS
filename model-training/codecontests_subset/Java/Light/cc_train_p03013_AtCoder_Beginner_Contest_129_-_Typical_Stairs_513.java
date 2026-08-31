import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		//故障している階段の段数を入れ込む配列宣言
		//初期値にfalseを入れておく。
		//壊れたところにtrue;
		boolean[] dest = new boolean[N];
		Arrays.fill(dest, false);
		for(int i = 0; i<M;i++) {
			int b = sc.nextInt();
			dest[b-1] = true;
		}
		long waru = 1000000007;
		//登れた階段の通りの値を確保する配列宣言
		//[0]は一段目と数える
		long[] anser = new long[N];

		if(N==1) {
			System.out.println(N);
		}else {
			//1,2段目の処理
			anser[0] = !dest[0]? 1:0;
			anser[1] = !dest[1]? anser[0]+1:0;
			//3段目からN段目までの処理
			for(int i = 2; i<N ; i++) {
				if(!dest[i]) {
					anser[i] = (anser[i-2] + anser[i-1]) % waru;
				}
			}
			System.out.println(anser[N-1]);
		}
	}
}