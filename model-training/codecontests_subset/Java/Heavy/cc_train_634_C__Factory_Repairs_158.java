

import java.util.*;


public class Delivery {

	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int a = input.nextInt();
		int b = input.nextInt();
		int q = input.nextInt();
		
		FT fta = new FT(n);
		FT ftb = new FT(n);
		
		List<Long> results = new ArrayList<>();
		for (int i = 0; i < q; ++i) {
			int type = input.nextInt();
			if (type == 1) {
				int day = input.nextInt();
				int increment = input.nextInt();
				ftb.update(day, increment, b);
				fta.update(day, increment, a);
			} else {
				int p = input.nextInt();
				long bs = ftb.sum(p - 1);
				long as = fta.sum(n) - fta.sum(p + k - 1);
				results.add(as + bs);
			}
		}
		input.close();
		for (long result : results) System.out.println(result);
		
		
	}
	
	private static class FT {
		
		private long[] data;
		private long[] xs;
		
		public FT(int n) {
			this.data = new long[n + 1];
			this.xs = new long[n + 1];
		}
	
		
		public void update(int x, int value, int cap) {
			long actualIncrement = Math.min(value + xs[x], cap) - xs[x];
			xs[x] += actualIncrement;
			for (; x < data.length; x += lobit(x)) data[x] += actualIncrement;
		}
		
		
		public long sum(int x) {
			long sum = 0;
			for (; x > 0; x -= lobit(x)) sum += data[x];
			return sum;
		}
		
		private int lobit(int x) {
			return x & -x;
		}
		
		
		
		
		
	}
	
}
