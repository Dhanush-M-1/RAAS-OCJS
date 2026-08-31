import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[]DN = new int[N];//一人の生徒の最小のマンハッタン距離
		int[]MN = new int[N];//一人の生徒の最小のマンハッタン距離の番号
		
		int[] a = new int[N];
		int[] b = new int[N];
		for(int i = 0;i<N;i++){
			a[i]=scan.nextInt();
			b[i]=scan.nextInt();
		}
		
		int[] c = new int[M];
		int[] d = new int[M];
		for(int i = 0;i<M;i++){
			c[i]=scan.nextInt();
			d[i]=scan.nextInt();
		}
		
		
		for(int i = 0;i<N;i++){//各生徒分繰り返す
			for(int j = 0;j<M;j++){//チェックポイントM個比較
				if(j==0){
					DN[i]=(Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]));
					MN[i]=j+1;
				}else{
					if(DN[i]>Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j])){
						DN[i]=Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
						MN[i]=j+1;//ここで配列の〇番目を一番目似合わせる
					}
				}
				
			}
		}
		
		
		
		
		
		
		for(int i =0;i<N;i++){//最後に生徒分の最小のマンハッタン距離だったチェックポイントを示す
			
			//System.out.println(DN[i]);
			System.out.println(MN[i]);
		}
		
		
		
		
		
		
		
		
	}

}
