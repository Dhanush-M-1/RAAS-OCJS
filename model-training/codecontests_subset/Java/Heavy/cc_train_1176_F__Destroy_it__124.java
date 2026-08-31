import java.io.*;
import java.util.*;
public class DestroyIt {
	public static void main(String[] args) {
		FastScanner scanner = new FastScanner();
		PrintWriter out = new PrintWriter(System.out, false);
		int N = scanner.nextInt();
		long[] dp = new long[10];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for(int i = 0; i < N; i++) {
			long[] ndp = Arrays.copyOf(dp, 10);
			int K = scanner.nextInt();
			ArrayList<Long> one = new ArrayList<>();
			ArrayList<Long> two = new ArrayList<>();
			ArrayList<Long> three = new ArrayList<>();
			for(int j = 0; j < K; j++) {
				int c = scanner.nextInt();
				long d = scanner.nextInt();
				if (c == 1) one.add(d);
				else if (c==2) two.add(d);
				else three.add(d);
			}
			Collections.sort(one, Collections.reverseOrder());
			Collections.sort(two, Collections.reverseOrder());
			Collections.sort(three, Collections.reverseOrder());
			//add one card
			long bone = Long.MIN_VALUE/6, btwo = Long.MIN_VALUE/6, bthree = Long.MIN_VALUE/6;
			if (!one.isEmpty()) bone = one.get(0); if (!two.isEmpty()) btwo = two.get(0);
			if (!three.isEmpty()) bthree = three.get(0);
			long maxOne = Math.max(bone, Math.max(btwo, bthree));
			for(int x = 0; x < 10; x++) {
				if (dp[x] == -1) continue;
				int next = (x + 1) % 10;
				if (next == 0) ndp[next] = Math.max(ndp[next], dp[x] + 2L*maxOne);
				else ndp[next] = Math.max(dp[x] + maxOne, ndp[next]);
			}
			//best adding two cards
			long sone = Long.MIN_VALUE/6;
			if (one.size() > 1) sone = one.get(1);
			long maxTwo = Math.max(sone + bone, bone + btwo);
			if (maxTwo > 0) {
				long maxVal = Long.MIN_VALUE;
				if (maxTwo == sone + bone) {
					maxVal = Math.max(sone, bone);
				}
				if (maxTwo == bone + btwo) {
					maxVal = Math.max(maxVal, Math.max(bone, btwo));
				}
				for(int x = 0; x < 10; x++) {
					if (dp[x] == -1) continue;
					int next = (x + 2) % 10;
					if (next == 0 || next == 1) {
						ndp[next] = Math.max(ndp[next], dp[x] + 2L*maxVal + (maxTwo-maxVal));
					}
					else {
						ndp[next] = Math.max(ndp[next], dp[x] + maxTwo);
					}
				}
			}
			//best adding three cards
			long tone = Long.MIN_VALUE/6;
			if (one.size() > 2) tone = one.get(2);
			long maxThree = bone + sone + tone;
			if (maxThree > 0) {
				for(int x = 0; x < 10; x++) {
					if (dp[x] == -1) continue;
					int next = (x + 3) % 10;
					if (next <= 2) {
						ndp[next] = Math.max(ndp[next], dp[x] + 2L*bone + (maxThree-bone));
					}
					else ndp[next] = Math.max(ndp[next], dp[x] + maxThree);
				}
			}
			dp = ndp;
		}
		long ans = -1;
		for(int i =0; i < 10; i++) {
			 ans = Math.max(ans, dp[i]);
		}
		out.println(ans);
		out.flush();
		out.close();
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner() { br = new BufferedReader(new InputStreamReader(System.in));}
		String next() {
			while(st == null || !st.hasMoreTokens()) {
				try { st = new StringTokenizer(br.readLine());
				} catch(IOException e) {e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
	}
}
