import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a  = new int[N];
		
		for (int i=0; i<N; i++){
			a[i] = sc.nextInt();
		}
		
		int ret = 0;
		for(int i=0; i<N; i++){
			
			int temp;
			
			// 自身の数字が順番と同じ場合
			if (i+1 == a[i]){
				ret++;
				// 先頭の場合
				if (i+1 == 1){
					a[i] = a[i+1];
					a[i+1] = 1;
				}
//				// 前と入れ替え可能か
//				else if (a[i-1] != i-1){
//					temp = a[i-1];
//					a[i-1] = a[i];
//					a[i] = temp;
//				}
				// 最後が同じ場合
				else if (i == N-1){
					temp = a[i-1];
					a[i-1] = a[i];
					a[i] = temp;
				}
				// 後ろと入れ替える
				else {
					temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
				}
				
			}
			
		}
		
		System.out.println(ret);
		
	}

}
