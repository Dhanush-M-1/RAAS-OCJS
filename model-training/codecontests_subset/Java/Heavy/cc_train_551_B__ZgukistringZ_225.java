import java.io.*;
import java.util.*;

public class b1 {
    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        new b1().run();
    }

    public void solve() throws IOException {
		String s = nextToken();
		String a = nextToken();
		String b = nextToken();

		int have[] = new int[26];
		int need[] = new int[26];
		int need1[] = new int[26];

		Arrays.fill(need, 0);
		Arrays.fill(need1, 0);
		Arrays.fill(have, 0);

		for (int i = 0; i < s.length(); i++) {
			have[(int) s.charAt(i) - (int) 'a']++;
		}

		for (int i = 0; i < a.length(); i++) {
			need[(int) a.charAt(i) - (int) 'a']++;
		}

		for (int i = 0; i < b.length(); i++) {
			need1[(int) b.charAt(i) - (int) 'a']++;
		}

		int min = (int)1e5 + 1;
	
		for (int i = 0; i < 26; i++) {
			if (need[i] != 0){
				min = Math.min(min, have[i] / need[i]);
			}
		}
		
		int ans1 = 0;
		int ans2 = 0;
		
		for (int i = 0; i <= min; i++) {
			boolean flag = true;
			int can = (int) 1e5 + 1;
			for (int j = 0; j < 26; j++) {
				if (have[j] - i * need[j] < 0) {
					flag = false;
					break;
				}
				if (need1[j] != 0) {
					can = Math.min(can, (have[j] - need[j] * i) / need1[j]);
				}
			}
			if (flag) {
				if (can + i > ans1 + ans2) {
					ans1 = i;
					ans2 = can;
				}
			}
		}
		
		for (int i = 0; i < ans1; i++) {
			out.print(a);
		}
		
		for (int i = 0; i < ans2; i++) {
			out.print(b);
		}
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < have[i] - ans1 * need[i] - ans2 * need1[i]; j++) {
				out.print((char) (i + (int) 'a'));
			}
		}

    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in)); 
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
