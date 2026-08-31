import java.util.Arrays;
import java.util.Scanner;


public class Main{
	static int n;
	static int [][] f;
	static int [][] p;
	static int []a;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		f = new int[n][10];
		for(int i = 0;i < n;i++){
			for(int j = 0;j < 10;j++){
				f[i][j] = sc.nextInt();			//店の状態
			}
		}
		p = new int[n][11];
		for(int i = 0;i < n; i++){
			for(int j = 0; j< 11; j++){
				p[i][j] = sc.nextInt();			//利益の入力
			}
		}
		sc.close();
		a = new int [10];			//姉さんの店の状態を入れる配列
		ans = Integer.MIN_VALUE;		//intの最小値
		dfs(0);
		System.out.println(ans);
	}
	static void dfs(int index){
		if(index == 10){
			if(Arrays.toString(a).equals("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]"))return;
			memo();
			return;

		}else{
			a[index] = 0;
			dfs(index + 1);
			a[index] = 1;
			dfs(index + 1);

		}
	}

	static void memo(){
		int partAns = 0;
		for(int i = 0;i < n;i++){
			int count = 0;
			for(int j = 0; j < 10;j++){
				if(a[j] == 1&& f[i][j] == 1){			//姉さんの店と店iが空いてたらカウントプラス１
					count++;
				}
			}
			partAns += p[i][count];
		}
		ans = Math.max(partAns, ans);
	}
}
