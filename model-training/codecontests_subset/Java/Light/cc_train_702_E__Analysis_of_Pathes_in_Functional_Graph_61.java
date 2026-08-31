import java.util.*;

public class E{
	static int _to[],_min[];
	static long _sum[];
	static int to[],min[];
	static long sum[];
	static int N;
	static void f(long k){
		if(k == 1){
			to = new int[N];
			min = new int[N];
			sum = new long[N];
			for(int i = 0; i < N; i++){
				to[i] = _to[i];
				min[i] = _min[i];
				sum[i] = _sum[i];
			}
		}else{
			f(k/2);
			int nextto[] = new int[N];
			int nextmin[] = new int[N];
			long nextsum[] = new long[N];
			for(int i = 0; i < N; i++){
				nextto[i] = to[to[i]];
				nextmin[i] = Math.min(min[i],min[to[i]]);
				nextsum[i] = sum[i] + sum[to[i]];
			}

			if(k%2 == 1){
				for(int i = 0; i < N; i++){
					nextmin[i] = Math.min(nextmin[i],_min[nextto[i]]);
					nextsum[i] = nextsum[i] + _sum[nextto[i]];
					nextto[i] = _to[nextto[i]];
				}
			}

			to = nextto;
			min = nextmin;
			sum = nextsum;
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		_to = new int[N];
		_min = new int[N];
		_sum = new long[N];

		long k = sc.nextLong();
		for(int i = 0; i < N; i++)
			_to[i] = sc.nextInt();
		for(int i = 0; i < N; i++)
			_sum[i] = _min[i]  = sc.nextInt();

		f(k);

		for(int i = 0; i < N; i++)
			System.out.println(sum[i] + " " + min[i]);
	}	
}