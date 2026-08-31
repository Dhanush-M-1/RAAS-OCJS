import java.util.*;
import java.io.*;

public class R565F
{

	public static void main(String[] args){
		JS scan = new JS();
		int n = scan.nextInt();
		long[][] dp = new long[n+1][10];
		for(int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
		for(int i = 0; i < 10; i++) dp[0][0] = 0;
		long max = 0;
		for(int i = 1; i <= n; i++) {
			int k = scan.nextInt();
			Card[] deck = new Card[k];

			for(int j = 0; j < k; j++) {
				deck[j] = new Card(scan.nextInt(), scan.nextInt());
			}
			Arrays.sort(deck);
			ArrayList<Long> bestOne = new ArrayList<Long>();
			long best2 = 0;
			long best3 = 0;
			for(int j = 0; j < k; j++) {
				if(deck[j].cost == 1) {
					if(bestOne.size() < 3) {
						bestOne.add((long)deck[j].dmg);
					}
				}
				if(deck[j].cost == 2) {
					if(best2 == 0) {
						best2 = deck[j].dmg;
					}
				}
				if(deck[j].cost == 3) {
					if(best3 == 0) {
						best3 = deck[j].dmg;
					}
				}
			}
			for(int j = 0; j < 10; j++) {
				if(dp[i-1][j] > -1) {
					//1 move
					long move = 0;
					if(bestOne.size() >= 1) {
						move = Math.max(move, bestOne.get(0));
					}
					if(best2 != 0) {
						move = Math.max(move, best2);
					}
					if(best3 != 0) {
						move = Math.max(move, best3);
					}
					if(move != 0) {
						if(j+1 >= 10) {
							dp[i][(j+1)%10] =  Math.max(dp[i][(j+1)%10], dp[i-1][j]+2*move);
						}
						else {
							dp[i][j+1] = Math.max(dp[i][j+1], dp[i-1][j]+move);
						}
					}


					//2 move
					if(j+2 >= 10) {
						move = 0;
						if(bestOne.size() >= 2) {
							move = bestOne.get(0)*2+bestOne.get(1);
						}
						if(bestOne.size() >= 1 && best2 != 0) {
							long big = Math.max(bestOne.get(0), best2);
							long sml = Math.min(bestOne.get(0), best2);
							move = Math.max(move, big*2+sml);
						}
						
						if(move != 0) {
							dp[i][(j+2)%10] = Math.max(dp[i][(j+2)%10], dp[i-1][j]+move);
						}
					}
					else {
						move = 0;
						if(bestOne.size() >= 2) {
							move = bestOne.get(0)+bestOne.get(1);
						}
						if(bestOne.size() >= 1 && best2 != 0) {
							long big = Math.max(bestOne.get(0), best2);
							long sml = Math.min(bestOne.get(0), best2);
							move = Math.max(move, big+sml);
						}
						if(move != 0) {
							dp[i][j+2] = Math.max(dp[i][j+2], dp[i-1][j]+move);
						}
					}

					//3 move
					move = 0;
					if(bestOne.size() == 3) {
						if(j+3 >= 10) {
							dp[i][(j+3)%10] = Math.max(dp[i][(j+3)%10], dp[i-1][j]+bestOne.get(0)*2+bestOne.get(1)+bestOne.get(2));
						}
						else {
							dp[i][j+3] = Math.max(dp[i][j+3], dp[i-1][j]+bestOne.get(0)+bestOne.get(1)+bestOne.get(2));
						}
					}
					
					//0 move
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				}
			}
			for(int j = 0; j < 10; j++) {
				//System.out.println(j+" "+dp[i][j]);
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}

	static class Card implements Comparable<Card>{

		int cost;
		int dmg;

		public Card(int cost, int dmg) {
			this.cost = cost;
			this.dmg = dmg;
		}

		@Override
		public int compareTo(Card o){
			return o.dmg-this.dmg;
		}
	}

	static class JS{
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public JS() {
			in = new BufferedInputStream(System.in, BS);
		}

		public JS(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}

		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}				
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}

		public int nextInt() {
			return (int)nextLong();
		}

		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
	}
}
