import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        IOUtils ut = new IOUtils(System.in, System.out);
        new Solution(ut);
        ut.close();
    }
}

class Solution {
    IOUtils io;

    public Solution(IOUtils io) throws Exception {
        this.io = io;

        int[] fa = new int[26];
        int[] fb = new int[26];
        int[] fc = new int[26];

        String a = io.read();
        for (int i = 0; i < a.length(); i++) {
            fa[a.charAt(i) - 'a']++;
        }
        String b = io.read();
        for (int i = 0; i < b.length(); i++) {
            fb[b.charAt(i) - 'a']++;
        }
        String c = io.read();
        for (int i = 0; i < c.length(); i++) {
            fc[c.charAt(i) - 'a']++;
        }

        int mxm = 0, ansb = 0, ansc = 0;
        for (int bcnt = 0; ; bcnt++) {
            boolean bpos = true;
            for (int i = 0; i < 26; i++) {
                if (fa[i] < fb[i] * bcnt) bpos = false;
            }
            if (!bpos) break;

            int maxc = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (fc[i] > 0) {
                    maxc = Math.min(maxc, (fa[i] - bcnt * fb[i]) / fc[i]);
                }
            }
            if (mxm <= bcnt + maxc) {
                mxm = bcnt + maxc;
                ansb = bcnt;
                ansc = maxc;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ansb; i++) {
            sb.append(b);
            for (int j = 0; j < b.length(); j++) {
                fa[b.charAt(j) - 'a']--;
            }
        }
        for (int i = 0; i < ansc; i++) {
            sb.append(c);
            for (int j = 0; j < c.length(); j++) {
                fa[c.charAt(j) - 'a']--;
            }
        }
        for (int j = 0; j < 26; j++) {
            for (int k = 0; k < fa[j]; k++) {
                sb.append((char) ('a' + j));
            }
        }

        io.writeln(sb.toString());
    }
}

class IOUtils {
    public BufferedReader in;
    public PrintWriter out;
    StringTokenizer st = null;

    public IOUtils(InputStream inStream, OutputStream outStream) {
        in = new BufferedReader(new InputStreamReader(inStream));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outStream)));
    }

    private void read_input() throws Exception {
        while (st == null || !(st.hasMoreTokens())) {
            st = new StringTokenizer(in.readLine());
        }
    }

    public void close() throws Exception {
        out.flush();
        in.close();
        out.close();
    }

    public String read() throws Exception {
        read_input();
        return st.nextToken();
    }

    public int readInt() throws Exception {
        read_input();
        return Integer.parseInt(st.nextToken());
    }

    public long readLong() throws Exception {
        read_input();
        return Long.parseLong(st.nextToken());
    }

    public double readDouble() throws Exception {
        read_input();
        return Double.parseDouble(st.nextToken());
    }

    public void writeln() throws Exception {
        out.print("\n");
    }

    public void write(int i) throws Exception {
        out.print(i);
    }

    public void writeln(int i) throws Exception {
        out.println(i);
    }

    public void write(String i) throws Exception {
        out.print(i);
    }

    public void writeln(String i) throws Exception {
        out.println(i);
    }

    public void write(long i) throws Exception {
        out.print(i);
    }

    public void writeln(long i) throws Exception {
        out.println(i);
    }
}
