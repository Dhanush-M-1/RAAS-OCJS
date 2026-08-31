import java.util.*;
import java.io.*;

public class Main{

    BufferedReader in;
    StringTokenizer str = null;
    PrintWriter out;

    private String next() throws Exception{
    	while (str == null || !str.hasMoreElements())
    	    str = new StringTokenizer(in.readLine());
    	return str.nextToken();
    }
    
    private int nextInt() throws Exception{
	   return Integer.parseInt(next());
    }

    int n,m;
    char []a;
    int []l, r, u, d;

    int cur, max, cnt;

    public void run() throws Exception{
    	in = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(System.out);
        n = nextInt();
        m = nextInt();
        a = new char[n * m];
        int at = 0;
        for(int i = 0; i < n; ++i) {
            String s = next();
            for(int j = 0; j < m; ++j) {
                a[at++] = s.charAt(j);
            }
        }
        l = new int[n * m];
        r = new int[n * m];
        u = new int[n * m];
        d = new int[n * m];

        int left[] = new int[n * m];
        int right[] = new int[n * m];
        int up[] = new int[n * m];
        int down[] = new int[n * m];

        for(int i = 0; i < n; ++i) {
            int last = -1;
            for(int j = 0; j < m; ++j) {
                left[i * m + j] = last;
                if (a[i * m + j] != '.') last = i * m + j;
            }
            last = -1;
            for(int j = m - 1; j >= 0; --j) {
                right[i * m + j] = last;
                if (a[i * m + j] != '.') last = i * m + j;
            }
        }

        for(int j = 0; j < m; ++j) {
            int last = -1;
            for(int i = 0; i < n; ++i) {
                up[i * m + j] = last;
                if (a[i * m + j] != '.') last = i * m + j;
            }
            last = -1;
            for(int i = n - 1; i >= 0; --i) {
                down[i * m + j] = last;
                if (a[i * m + j] != '.') last = i * m + j;
            }
        }

        // System.out.println("left = " + Arrays.toString(left));
        // System.out.println("right = " + Arrays.toString(right));
        // System.out.println("up = " + Arrays.toString(up));
        // System.out.println("down = " + Arrays.toString(down));

        cur = 0;
        max = 0;
        cnt = 0;
        l = left.clone();
        r = right.clone();
        d = down.clone();
        u = up.clone();
        for(int i = 0; i < n * m; ++i) {
            if (a[i] == '.') continue;
            dfs(i);
        }

        out.println(max + " " + cnt);
        out.close();
    }

    private void dfs(int i) {
        if (i == -1) return;
        ++cur;
        if (cur > max) {
            max = cur;
            cnt = 1;
        }else if (cur == max) {
            ++cnt;
        }

        if (l[i] > -1) r[l[i]] = r[i];
        if (r[i] > -1) l[r[i]] = l[i];
        if (u[i] > -1) d[u[i]] = d[i];
        if (d[i] > -1) u[d[i]] = u[i];

        if (a[i] == 'U') {
            dfs(u[i]);
        }else if (a[i] == 'D') {
            dfs(d[i]);
        }else if (a[i] == 'R') {
            dfs(r[i]);
        }else if (a[i] == 'L') {
            dfs(l[i]);
        }

        if (l[i] > -1) r[l[i]] = i;
        if (r[i] > -1) l[r[i]] = i;
        if (u[i] > -1) d[u[i]] = i;
        if (d[i] > -1) u[d[i]] = i;

        cur--;
    }

    public static void main(String args[]) throws Exception{
	   new Main().run();
    }
}