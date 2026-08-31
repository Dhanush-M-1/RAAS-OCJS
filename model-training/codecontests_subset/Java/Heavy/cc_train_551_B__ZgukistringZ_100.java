import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Artem Gilmudinov
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Reader in = new Reader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, Reader in, PrintWriter out) {
        String a, b, c;
        a = in.rl(); b = in.rl(); c = in.rl();
        int[][] cnt = new int[3][26];
        cnt[0] = getCnt(a);
        cnt[1] = getCnt(b);
        cnt[2] = getCnt(c);
        int[] temp = new int[26];
        int cnt1, cnt2;
        cnt1 = cnt2 = 0;
        for(int i = 0; i < a.length(); i++) {
            for(int j = 0; j < 26; j++) {
                temp[j] = cnt[0][j];
            }
            for(int j = 0; j < 26; j++) {
                temp[j] -= i * cnt[1][j];
            }
            boolean flag = true;
            for(int j = 0; j < 26; j++) {
                if(temp[j] < 0) {
                    flag = false;
                }
            }
            if(!flag) {
                break;
            }
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < 26; j++) {
                if(cnt[2][j] != 0) {
                    min = Math.min(min, temp[j] / cnt[2][j]);
                }
            }
            if(i + min > cnt1 + cnt2) {
                cnt1 = i;
                cnt2 = min;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt1; i++) {
            sb.append(b);
            for(int j = 0; j < 26; j++) {
                cnt[0][j] -= cnt[1][j];
            }
        }
        for(int i = 0; i < cnt2; i++) {
            sb.append(c);
            for(int j = 0; j < 26; j++) {
                cnt[0][j] -= cnt[2][j];
            }
        }
        for(int j = 0; j < 26; j++) {
            for(int z = 0; z < cnt[0][j]; z++) {
                sb.append((char)('a' + j));
            }
        }
        out.println(sb);
    }

    public int[] getCnt(String a) {
        int[] cnt = new int[26];
        for(int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i) - 'a']++;
        }
        return cnt;
    }
}

class Reader {
    private BufferedReader in;

    public Reader(InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
    }

    public String rl() {
        try {
            return in.readLine();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}

