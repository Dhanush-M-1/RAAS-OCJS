import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Round158_B {

    char[] tmp;
    // Jan 31
    // Feb 28 (29 in leap)
    // Mar 31
    // April 30
    // May 31
    // Jun 30
    // July 31
    // Aug 31
    // Sep 30
    // Oct 31
    // Nov 30
    // Dec 31
    int mon[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public boolean check() {
        // dd-mm-yyyy
        if (tmp[2] != '-' || tmp[5] != '-')
            return false;
        for (int i = 0; i < 10; i++) {
            if (i != 2 && i != 5) {
                if (!(tmp[i] >= '0' && tmp[i] <= '9'))
                    return false;
            }
        }
        int day = (tmp[0] - '0') * 10 + (tmp[1] - '0');
        int month = (tmp[3] - '0') * 10 + (tmp[4] - '0');
        int year = (tmp[6] - '0') * 1000 + (tmp[7] - '0') * 100
                + (tmp[8] - '0') * 10 + (tmp[9] - '0');
        if (year < 2013 || year > 2015)
            return false;
        if (month < 1 || month > 12)
            return false;
        if (day > 0 && day <= mon[month - 1])
            return true;
        return false;
    }

    public void solve() throws Exception {

        InputReader in = new InputReader();
        char[] a = in.next().toCharArray();
        int N = a.length;
        tmp = new char[10];
        String[] answer = new String[N];
        int next = 0;
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();

        for (int i = 0; i < N - 10 + 1; i++) {
            for (int j = 0; j < 10; j++) {
                tmp[j] = a[i + j];
            }
            if (check()) {
                StringBuffer s = new StringBuffer("");
                for (int k = 0; k < 10; k++)
                    s.append(tmp[k]);
                Integer x = hash.get(s.toString());
                if (x != null) {
                    hash.put(s.toString(), x + 1);
                } else {
                    hash.put(s.toString(), 1);
                    answer[next++] = s.toString();
                }
            }
        }
        int max = 0;
        String ans = "";
        for (int i = 0; i < next; i++) {
            int x = hash.get(answer[i]);
            if (x > max) {
                max = x;
                ans = answer[i];
            }
        }
        System.out.println(ans);

    }
    

    public static void main(String[] args) throws Exception {
        new Round158_B().solve();

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer st;

        public InputReader() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(in.readLine());

        }

        public String next() throws IOException {

            while (!st.hasMoreElements())
                st = new StringTokenizer(in.readLine());
            return st.nextToken();
        }

        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }
    }

}
