import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		//データ読み込み
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();	
		}
		
		//入れ替えの回数を記録するカウンター
		int counter = 0;
		
		for(int i = 0; i < n; i++){
			//各iごとに最小の値が格納されている配列番号の変数
			int minj = i;
			
			for(int j = i + 1; j < n; j++){
				if(a[j] < a[minj]){
					minj = j;
				}
			}
			
			//i番目に格納されている値が、最小でない場合、入れ替え
			if(minj != i){
				int temp = a[i];
				a[i] = a[minj];
				a[minj] = temp;
				
				//入れ替え回数の加算
				counter++;
			}
		}
		
		//結果の出力
		System.out.print(a[0]);
		for(int i = 1; i < n; i++){
			System.out.print(" " + a[i]);
		}
		System.out.print("\n");
		System.out.println(counter);
	}
}
