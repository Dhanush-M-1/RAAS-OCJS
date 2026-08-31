import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class F {
	static byte[] buf = new byte[1<<26];
    static int bp = -1;	
	
	public static void main(String[] args) throws IOException {

		/**/
		DataInputStream in = new DataInputStream(System.in);
		/*/
		DataInputStream in = new DataInputStream(new FileInputStream("src/f.in"));
		/**/
		
		in.read(buf, 0, 1<<26);
		int n = nni();
		int m = nni();
		int[] which = new int[m+1];
		ArrayList<ArrayList<Integer>> ch = new ArrayList<>();
		int[] tpz = new int[m+1];
		int[] p2s = new int[m+1];
		boolean[] hone = new boolean[m+1];
		p2s[0] = 1;
		for (int i = 1; i <= m; ++i) {
			p2s[i] = (p2s[i-1]*2)%1000000007;
		}
		ArrayList<Integer> ansList = new ArrayList<>();
		for (int i = 0; i <= m; ++i) {
			ch.add(new ArrayList<>());
			which[i] = i;
			ch.get(i).add(i);
			++tpz[i];
		}
		for (int i = 1; i <= n; ++i) {
			int k = nni();
			if (k==1) {
				int u = which[nni()];
				if (hone[u])
					continue;
				hone[u] = true;
				ansList.add(i);
			} else {
				int u = which[nni()];
				int v = which[nni()];
				if (u==v)
					continue;
				if (hone[u]&&hone[v])
					continue;
				if (tpz[u]<tpz[v]) {
					int t = v;
					v = u;
					u = t;
				}
				for (int v2 : ch.get(v)) {
					which[v2] = u;
					ch.get(u).add(v2);
					++tpz[u];
				}
				hone[u] |= hone[v];
				ansList.add(i);
			}
		}
		long ans = 1;
		for (int i = 0; i <= m; ++i) {
			if (which[i]!=i)
				continue;
			ans *= hone[i]?p2s[tpz[i]]:p2s[tpz[i]-1];
			ans %= 1000000007;
		}
		System.out.println(ans+" "+ansList.size());
		System.out.println(String.join(" ", ansList.stream().map(a -> ""+a).collect(Collectors.toList())));
	}
	
	public static int nni() {
        int ret = 0;
        byte b = buf[++bp];
        while (true) {
            ret = ret*10+b-'0';
            b = buf[++bp];
            if (b<'0'||b>'9') {
            	while (buf[bp+1]=='\r'||buf[bp+1]=='\n'||buf[bp+1]==' ') {++bp;}
            	break;
            }
        }
        return ret;
    }
}