import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        int a[] = new int[60];
        Vector<Integer> b=new Vector<>();
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
            int x=a[i];
            while (x != 0) {
                b.add(x);
                x /= 2;

            }
        }
        int ans = (int)1e9;
        for (int j = 0; j < b.size(); j++) {
            Vector<Integer> c = new Vector<>();
            for (int i = 1; i <= n; i++) {
                int x = a[i], cnt = 0;
                while (x > b.get(j)) {
                    x /= 2;
                    cnt++;
                }
                if (x == b.get(j)) {
                    c.add(cnt);
                }
            }
            if (c.size() < k) continue;
            Collections.sort(c, Comparator.naturalOrder());
            int sum=0;
            for(int i=0;i<k;i++){
                sum+=c.get(i);
            }
            ans = Math.min(ans,sum );
        }
        out.printf("%d\n", ans);
        out.flush();
    }
}

  	 	  				    	    	     			 	