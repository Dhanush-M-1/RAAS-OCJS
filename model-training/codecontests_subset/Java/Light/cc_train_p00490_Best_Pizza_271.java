public class Main {

	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		int n = in.nextInt(); //トッピングの種類数
		int mny1 = in.nextInt(); //生地の値段
		int mny2 = in.nextInt(); //トッピングの値段
		int kal = in.nextInt(); //生地のカロリー
		int[] top = new int[n];
		for (int i=0; i<n; i++) {
			top[i] = in.nextInt(); //トッピングのカロリー
		}
		java.util.Arrays.sort(top);
		int kalsum = kal; //カロリーの合計
		int cnt = 0;
		for (int i=n-1; i>=0; i--) {
			int sum1 = kalsum / (mny1+mny2*cnt); // 現在のカロリー/money
			int sum2 = (kalsum + top[i]) / (mny1+mny2*(cnt+1)); // 次のカロリー/money
			if (sum1 > sum2) break;
			kalsum += top[i];
			cnt++;
		}
		System.out.println(kalsum/(mny1+mny2*cnt));
	}
}