import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int A, B, C;		//生地の値段、トッピングの値段、生地のカロリー。
		int N = sc.nextInt();				//トッピングの種類数。
		int[] topping = new int[N];
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		for(int i=0; i<N; i++){
			topping[i] = sc.nextInt();
		}
		sort_down00(topping, N);
		for(int i=0; i<N; i++){
			if((C/A) <= ((C+topping[i])/(A+B))){
				C += topping[i];
				A += B;
			}
		}
		System.out.println((int)C/A);

	}
	
	static void sort_down00(int[] data, int n){
		int i;
		int idx;
		int work;
		for(i=0; i<n; i++){
			idx = max_idx00(data, i, n);
			work = data[i];
			data[i] = data[idx];
			data[idx] = work;
		}
		return;
	}
	
	static int max_idx00(int[] data, int from, int to){
		int i;
		int idx = from;
		for(i=from; i<to; i++){
			if(data[idx] < data[i]){
				idx = i;
			}
		}
		return idx;
	}

}