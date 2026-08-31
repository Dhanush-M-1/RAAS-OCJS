import java.util.*;
public class Main {
	public static void main(String[] args) {
		C();
	}
	
	public static void A() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(Math.min(A*N, B));
	}
	
	//calc harshad
	public static int calchar(int x) {
		int sum = 0;
		String num = ((Integer) x).toString();
		for(int i=0;i<num.length();i++) {
			sum += Character.getNumericValue(num.charAt(i));
		}
		return sum;
	}
	
	public static void B() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = calchar(n);
		if(n%sum==0) System.out.println("Yes");
		else System.out.println("No");
	}
	/*
	 *  F i,j,k 店iが曜日jの時間帯kに開いているか
	 *  ci 本店と店iが同時に開いている時間帯の数
	 *  店の利益 P_1,c1 + Pncn  利益の最大値を求める
	 *  全部で 2^10通り 1000なので容易に行うことが可能
	 *  というか、時間帯ごとに関係はないので、10こ確かめる　（利益が正ならひらく）
	 *  また、利益が最大の時間帯を保持しておき、どうやっても利益がマイナスならそれを返す
	 *  ではない、何個かぶるかが重要 以下では、2^10
	 */
	public static void C() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int F[][] = new int[N][10];
		int P[][] = new int[N][11];
		for(int i=0;i<N;i++) {
			for(int j=0;j<10;j++) {
				F[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<11;j++) {
				P[i][j] = sc.nextInt();
			}
		}
		int counter = 1;
		int ret = Integer.MIN_VALUE;
		for(;counter<1024;counter++) {
			int nowsc = calcscore(counter,F,P);
			//System.out.println(nowsc);
			if(ret < nowsc) ret = nowsc;
		}
		System.out.println(ret);
	}
	// 2進数を受け取り、対応する曜日、時間帯が開催されているとして、スコアを返す 10桁 0001.. ~ 111.. 00000はない
	public static int calcscore(int bin, int[][] F, int [][] P) {
		int score = 0;
		int[] c = new int[F.length]; // 各店と同時に開いている回数
		for(int i=0;i<10;i++) {
			// if open
			if((bin & (1<<i)) != 0) {
				for(int j=0;j<F.length;j++) {
					if(F[j][i] == 1) c[j]++; 
				}
			}
		}
		for(int i=0;i<F.length;i++) {
			score += P[i][c[i]];
		}
		return score;
	}
	
	public static void D() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		List[] lis = new List[C];
		for(int i=0;i<C;i++) {
			lis[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<N;i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int c = sc.nextInt()-1;
			//if(c>C) System.out.println("N");
			lis[c].add(s);
			lis[c].add(t);
		}
		int[] sum = new int[20000];
		for(int i=0;i<C;i++) {
			updatesum(sum,lis[i]);
		}
		int max = 0;
		for(int i=0;i<20000;i++) {
			if(max < sum[i]) max = sum[i];
		}
		System.out.println(max);
		
	}
	//チャネルのsitiのlistを受け取り、sumの配列を更新する
	public static void updatesum(int[] sum, List<Integer> sche) {
		int[] temp = new int[sum.length];
		for(int i=0;i<sche.size();i+=2) {
			int st = sche.get(i)*2-1;
			int ed = sche.get(i+1)*2;
			for(int j=st;j<ed;j++) {
				temp[j] = 1;
			}
		}
		for(int i=0;i<sum.length;i++) {
			sum[i] += temp[i];
		}
	}
}