import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
public class F565 {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		
		int N = in.nextInt();
		int[][] turns = new int[N][5];
		long[][][] dp = new long[N+1][10][4];
		
		for(int i = 0; i < turns.length; i++)
			for(int j = 0; j < 5; j++)
				turns[i][j] = -1;
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				for(int k = 0; k < dp[i][j].length; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		dp[0][0][0] = 0;
		
		for(int i = 0; i < N; i++) {
			int numCards = in.nextInt();
			for(int j = 0; j < numCards; j++) {
				int cost = in.nextInt();
				int damage = in.nextInt();
				update(turns, i, cost, damage);
			}
		}
		
//		System.out.println("turns:");
//		print(turns);
		
		for(int i = 0; i < dp.length - 1; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				for(int k = 0; k < dp[i][j].length; k++) {
					if(dp[i][j][k] == -1)
						continue;
					for(int c = 0; c < 4; c++) {
						long temp = -1;
						if(j + c >= 10) {
							long addOn = doDamage(turns[i], c, true);
							if(addOn == -1)
								continue;
							temp = dp[i][j][k] + addOn;
						}
						else {
							long addOn = doDamage(turns[i], c, false);
							if(addOn == -1)
								continue;
							temp = dp[i][j][k] + addOn;
						}
						
						dp[i+1][(j+c) % 10][c] = Math.max(temp, dp[i+1][(j+c) % 10][c]);
					}
				}
			}
		}
		
		long max = 0;
		for(int j = 0; j < 10; j++) {
			for(int k = 0; k < 4; k++) {
				max = Math.max(dp[N][j][k], max);
			}
		}
		
//		System.out.println("dp:");
//		print(dp);
		
		System.out.println(max);
	}
	
	public static long doDamage(int[] cards, int howMany, boolean doDouble) {
		if(howMany == 0)
			return 0;
		
		if(!doDouble) {
			if(howMany == 1) {
				long[] arr = {cards[2], cards[3], cards[4]};
				Arrays.sort(arr);
				return arr[2];
			}
			if(howMany == 2) {
				long temp = Math.max(cards[1], cards[3]);
				if(cards[2] == -1 || temp == -1)
					return -1;
				return temp + cards[2];
			}
			if(howMany == 3) {
				if(cards[0] == -1 || cards[1] == -1 || cards[2] == -1)
					return -1;
				long ans = cards[0];
				return ans + cards[1] + cards[2];
			}
		}
		else {
			if(howMany == 1) {
				long[] arr = {cards[2], cards[3], cards[4]};
				Arrays.sort(arr);
				if(arr[2] == -1)
					return -1;
				return 2 * arr[2];
			}
			if(howMany == 2) {
				long[] temp = {cards[1], cards[2], cards[3]};
				Arrays.sort(temp);
				
				if(temp[2] == -1 || temp[1] == -1)
					return -1;
				
				return 2*temp[2] + temp[1];
			}
			if(howMany == 3) {
				if(cards[0] == -1 || cards[1] == -1 || cards[2] == -1)
					return -1;
				
				long ans = 2 * cards[2];
				return ans + cards[1] + cards[0];
			}
		}
		
		return -1;
	}
	
	public static void update(int[][] maxCards, int index, int cost, int damage) {
		if(cost == 1) {
			if(damage > maxCards[index][0]) {
				maxCards[index][0] = damage;
				if(damage > maxCards[index][1]) {
					maxCards[index][0] = maxCards[index][1];
					maxCards[index][1] = damage;
					if(damage > maxCards[index][2]) {
						maxCards[index][1] = maxCards[index][2];
						maxCards[index][2] = damage;
					}
				}
			}
		}
		else if(cost == 2) {
			if(damage > maxCards[index][3]) {
				maxCards[index][3] = damage;
			}
		}
		else {
			if(damage > maxCards[index][4]) {
				maxCards[index][4] = damage;
			}
		}
	}
	
	public static long max3Sum(int[] a) {
		return ((long) a[0]) + a[1] + a[2];
	}
	
	public static long max2Sum(int[] a) {
		return a[2] + Math.max(a[1], a[3]);
	}
	
	public static long max1(int[] a) {
		long max = 0;
		for(int i : a)
			max = Math.max(i, max);
		
		return max;
	}
	
	public static void print(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void print(int[][][] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < a[i].length; j++) {
				for(int k = 0; k < a[i][j].length; k++) {
					System.out.print(a[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void print(long[][][] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < a[i].length; j++) {
				for(int k = 0; k < a[i][j].length; k++) {
					System.out.print(a[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Source: Matt Fontaine
	 */
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int chars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (chars == -1)
				throw new InputMismatchException();
			if (curChar >= chars) {
				curChar = 0;
				try {
					chars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (chars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}

}
/*
5
3
1 6
1 7
1 5
2
1 4
1 3
3
1 10
3 5
2 3
3
1 15
2 4
1 10
1
1 100
outputCopy
263



15
5
1 5
3 10
2 42
2 73
1 5
5
1 38
2 39
3 33
3 33
1 80
5
3 39
1 95
1 18
1 15
2 91
5
3 43
1 85
3 14
3 23
2 80
5
3 3
1 92
3 20
3 29
2 81
5
2 73
1 88
3 27
1 100
1 75
5
2 91
1 77
1 16
3 81
3 87
5
3 14
2 28
3 74
3 96
1 16
5
1 28
1 42
1 3
1 95
2 29
5
3 18
3 78
1 97
1 43
1 84
5
2 6
2 31
3 37
3 7
3 75
5
1 34
1 2
1 6
3 54
3 58
5
3 21
2 89
3 41
2 97
2 1
5
2 29
1 76
1 44
3 29
2 56
5
3 61
3 47
3 4
1 66
1 16

2323
*/