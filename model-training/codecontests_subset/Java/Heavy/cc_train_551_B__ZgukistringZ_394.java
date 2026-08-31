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
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String a = in.next();
        String b = in.next();
        String c = in.next();
        int index1[] = calc(a, b, c);
        int index2[] = calc(a, c, b);
        if (index1[0] > index2[0]) {
            out.println(ret(a, b, c, index1[1]));
        } else {
            out.println(ret(a, c, b, index2[1]));
        }

    }

    private int[] calc(String a, String b, String c) {
        int ca[] = new int[26];
        for (char ch : a.toCharArray()) {
            ca[ch - 'a']++;
        }
        int cb[] = new int[26];
        int cc[] = new int[26];
        for (char ch : b.toCharArray()) {
            cb[ch - 'a']++;
        }
        for (char ch : c.toCharArray()) {
            cc[ch - 'a']++;
        }
        int countb = 0;
        while (true) {
            if (canGetString(ca, cb)) {
                sub(ca, cb);
                countb++;
            } else break ;
        }
        int countc = 0;
        while (true) {
           if (canGetString(ca, cc)) {
               sub(ca, cc);
               countc++;
           } else break;
        }
        int max = countc + countb;
        int index = 0;

        int cbb = 0;
        int ccc = 0;
        for (int i = 0;i < countb;i++) {
            add(ca, cb);
            cbb++;
            while (true) {
                if (canGetString(ca, cc)) {
                    sub(ca, cc);
                    ccc++;
                } else break;
            }
            if (countb - cbb + countc + ccc > max) {
                max = countb - cbb + countc + ccc;
                index = i + 1;
            }
        }
        return new int[]{max, index};
    }
    private String ret(String a, String b, String c, int index) {
        StringBuilder sb = new StringBuilder();
        int ca[] = new int[26];
        for (char ch : a.toCharArray()) {
            ca[ch - 'a']++;
        }
        int cb[] = new int[26];
        int cc[] = new int[26];
        for (char ch : b.toCharArray()) {
            cb[ch - 'a']++;
        }
        for (char ch : c.toCharArray()) {
            cc[ch - 'a']++;
        }
        int countb = 0;
        while (true) {
            if (canGetString(ca, cb)) {
                sub(ca, cb);
                countb++;
            } else break ;
        }
        int countc = 0;
        while (true) {
            if (canGetString(ca, cc)) {
                sub(ca, cc);
                countc++;
            } else break;
        }
        int max = countc + countb;

        int cbb = 0;
        int ccc = 0;
        int tb = countb;
        int tc = countc;
        int copyCa[] = ca;

        for (int i = 0; i < index; i++) {
            add(ca, cb);
            cbb++;
            while (true) {
                if (canGetString(ca, cc)) {
                    sub(ca, cc);
                    ccc++;
                } else break;
            }
            if (countb - cbb + countc + ccc > max) {
                max = countb - cbb + countc + ccc;
                tb = countb - cbb;
                tc = countc + ccc;
                copyCa = ca;
            }
        }
        for (int i = 0;i < tb;i++) {
            sb.append(b);
        }
        for (int i = 0;i < tc;i++) {
            sb.append(c);
        }
        for (int i = 0;i < copyCa.length;i++) {
            while (copyCa[i]-- != 0) sb.append((char)('a' + i));
        }
        return sb.toString();

    }

    private boolean canGetString(int ca[], int t[]) {
        for (int i = 0; i < 26;i++) {
            if (ca[i] < t[i]) return false;
        }
        return true;
    }

    private void add(int ca[], int t[]) {
        for (int i = 0; i < ca.length;i++) {
            ca[i] += t[i];
        }
    }
    private void sub(int ca[], int t[]) {
        for (int i = 0; i < ca.length;i++) {

            ca[i] -= t[i];
            if(ca[i] < 0) throw new RuntimeException("less then zero");
        }
    }
}

class InputReader {
	private BufferedReader br;
	private StringTokenizer st;
	public InputReader(InputStream in) {
		br=new BufferedReader(new InputStreamReader(in));
		try {
			st=new StringTokenizer(br.readLine());
		} catch (IOException ignored) {

		}
	}

	public boolean readLine() {
		try {
			st=new StringTokenizer(br.readLine());
		} catch (IOException e) {
			return false;
		}
		return true;
	}

    public String next(){
		if(!st.hasMoreTokens()) readLine();
		return st.nextToken();
	}

}
