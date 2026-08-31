import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();//トッピングの種類数
		int base = sc.nextInt();//生地の値段
		int topping = sc.nextInt();//トッピングの値段
		int basec = sc.nextInt();//生地のカロリー
		int tp[] = new int[x];//トッピングのカロリーの配列
		int i;
		double bc = basec/base;//1ドルあたりの生地のカロリー
		double max = bc;//ベストピザ
		double sum = 0;//合計
		double bunshi = basec;
		double bunbo = base;
		for(i = 0; i < x; i++){
			tp[i] = sc.nextInt();//トッピングのカロリー
		}
		Arrays.sort(tp);//昇順に並び替え
		for(i = x-1; 0 <= i; i--){
			bunshi = bunshi + tp[i];
			bunbo = bunbo + topping;
			sum = bunshi/bunbo;
			if(max <= sum){
				max = sum;
			}
		}
		System.out.println((int)max);
	}

}