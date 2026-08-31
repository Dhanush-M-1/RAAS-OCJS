import java.util.Scanner;

/**
 * https://abc057.contest.atcoder.jp/tasks/abc057_b
 */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int M = Integer.parseInt(sc.next());
		Point[] s = new Point[N];
		Point[] p = new Point[M];
		for(int i=0; i<N; i++) s[i] = new Point(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
		for(int i=0; i<M; i++) p[i] = new Point(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
		sc.close();
		
		int[] ans = new int[N];
		for(int i=0; i<N; i++){
			long min = Long.MAX_VALUE;
			for(int j=0; j<M; j++){
				long d = Math.abs(s[i].x-p[j].x)+Math.abs(s[i].y-p[j].y);
				if(min>d){
					min = d;
					ans[i] = j+1;
				}
			}
		}
		
		for(int a:ans) System.out.println(a);
		

	}
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}