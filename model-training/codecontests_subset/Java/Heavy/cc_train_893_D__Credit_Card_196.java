import java.util.*;

public class ER33Dsubmission {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int d = scan.nextInt();
		int[] arr = new int[n];
		int[] sum = new int[n];
		ST maxims = new ST(n);
		for(int i = 0; i < n; i++) arr[i] = scan.nextInt();
		sum[0] = arr[0];
		if(sum[0] > d){
			System.out.println(-1);
			return;
		}
		//System.out.println("sum");
		for(int i = 1; i < n; i++){
			sum[i] = arr[i]+sum[i-1];
			maxims.increment(i, i, sum[i]);
			//System.out.println(i+" "+sum[i]);
			if(sum[i] > d){
				System.out.println(-1);
				return;
			}
		}
		//System.out.println("------");
		//System.out.println(maxims.maximum(1, n));
		int ans = 0;
		int money = 0;
		for(int i = 0; i < n; i++){
			if(arr[i] == 0){
				if(money < 0){
					//int add = 0-money;
					//maxims.increment(i, n, add);
					//System.out.println("maxims");
					int max = maxims.maximum(i, n);
					if(max > d){
						System.out.println(-1);
						return;
					}
					int add = d-max;
					if(money + add < 0){
						System.out.println(-1);
						return;
					}
					maxims.increment(i, n, add);
//					for(int j = 0; j < n; j++){
//						System.out.println(j+" "+maxims.maximum(j, j));
//					}
					money += add;
					ans++;
				}
			}
			money += arr[i];
			money = Math.min(d, money);
		}
		System.out.println(ans);
	}
	
	static class ST{

		int n;
		int[] lo, hi, max, delta;

		public ST(int y){
			n = y;
			lo = new int[4*n+1];
			hi = new int[4*n+1];
			max = new int[4*n+1];
			delta = new int[4*n+1];
			init(1, 0, n-1);
		}

		public void increment(int a, int b, int val){
			increment(1, a, b, val);
		}

		public int maximum(int a, int b){
			return maximum(1, a, b);
		}

		public void init(int i, int a, int b){
			lo[i] = a;
			hi[i] = b;
			if(a == b) return;
			int m = (a+b)/2;
			init(2*i, a, m);
			init(2*i+1, m+1, b);
		}

		void prop(int i){
			delta[2*i] += delta[i];
			delta[2*i+1] += delta[i];
			delta[i] = 0;
		}

		void update(int i){
			max[i] = Math.max(max[2*i]+delta[2*i], max[2*i+1]+delta[2*i+1]);
		}

		void increment(int i, int a, int b, int val){ //Lazy Propagation Incrementation
			//No cover
			if(b < lo[i] || hi[i] < a){
				return;
			}
			//Full cover
			if(a <= lo[i] && hi[i] <= b){
				delta[i] += val;
				return;
			}
			//Partial cover
			prop(i);
			increment(2*i, a, b, val); //go to left subtree
			increment(2*i+1, a, b, val); //go to right subtree
			update(i);
		}

		int maximum(int i, int a, int b){
			if(b < lo[i] || hi[i] < a){
				return Integer.MIN_VALUE;
			}
			if(a <= lo[i] && hi[i] <= b){
				return max[i]+delta[i];
			}
			prop(i);
			int minLeft = maximum(2*i, a, b);
			int minRight = maximum(2*i+1, a, b);
			update(i);
			return Math.max(minLeft, minRight);
		}
	}
}

/*
7 10
-5 0 9 -10 0 10 0
*/