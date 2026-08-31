import java.util.Scanner;

/**
 * https://abc072.contest.atcoder.jp/tasks/arc082_b
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] a = new int[N];
		for(int i=0; i<N; i++) a[i] = Integer.parseInt(sc.next());
		sc.close();
		
		int ans = 0;
		for(int i=0; i<N-1; i++){
			if(a[i]==i+1){
				a[i] = a[i+1];
				a[i+1] = i+1;
				ans++;
			}
		}
		if(a[N-1]==N) ans++;
		System.out.println(ans);
		
	}

}