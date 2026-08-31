import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();//トッピングの個数
		int A = s.nextInt();//生地の値段
		int B = s.nextInt();//トッピングの値段
		int C = s.nextInt();//生地のカロリー
		int[] result = new int[n];//合計カロリー
		int[] onedoller = new int[n+1];//1ドルあたりのカロリー
		int[] tcal = new int[n];//トッピングカロリー配列
		onedoller[0] = C/A;//トッピング何もなし
		
		for(int i=0; i<n; i++){//配列初期化
			result[i] = 0;
		}
		for(int i=0; i<n; i++){//カロリーの入力
			tcal[i] = s.nextInt();
		}
		for(int i=0; i<tcal.length-1; i++){//大きい順に並べ替え
			for(int j=i+1; j<tcal.length; j++){
				if(tcal[j]>tcal[i]){
					int temp = tcal[i];
					tcal[i] = tcal[j];
					tcal[j] = temp;
				}
			}
		}
		int sum = C;
		int c = 1;//トッピング数カウンター
		for(int i=0; i<tcal.length; i++){
			result[i] = tcal[i]+sum;
			sum = result[i];
			onedoller[i+1] = result[i]/(A+B*c);
			c++;
		}

		for(int i=0; i<onedoller.length-1; i++){//大きい順に並べ替え
			for(int j=i+1; j<onedoller.length; j++){
				if(onedoller[j]>onedoller[i]){
					int temp = onedoller[i];
					onedoller[i] = onedoller[j];
					onedoller[j] = temp;
				}
			}
		}
		System.out.println(onedoller[0]);
	}
}