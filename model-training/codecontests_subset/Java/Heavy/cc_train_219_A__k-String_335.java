import java.io.*;
import java.util.*;

public class KString{
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    public void run() throws Exception {
        //in = new BufferedReader(new FileReader("D.IN"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int k=nextInt();
        String s=next();
        char[] map=new char[26];
        for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)-'a']++;
		}
        for (int i = 0; i < 26; i++) {
			if(map[i]%k!=0) {System.out.println(-1); return;}
		}
        String res="";
        for (int i = 0; i < 26; i++) {
			int times=map[i]/k;
			for (int j = 0; j < times; j++) {
				res+=(char)('a'+i);
			}
		}
        String toPrint="";
        for (int i = 0; i < k; i++) {
			toPrint+=res;
		}
        System.out.println(toPrint);

        out.flush();
        out.close();
        in.close();
    }

    public static void main(String[] args) throws Exception {
        new KString().run();
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(in.readLine());
            } catch (Exception e) {
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }
}
