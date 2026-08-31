    import java.io.*;
    import java.util.*;
    public class Main {

    	public static void main(String[] args) throws IOException{
    		PrintWriter pw = new PrintWriter(System.out);
    		Scanner sc = new Scanner(System.in);
    		int n = sc.nextInt();
    		String s = sc.next();
    		int l = -1;
    		int r = -1;
    		for(int i=1;i<n;i++) {
    			if(s.charAt(i)<s.charAt(i-1)) {
    				l = i;
    				r = i+1;
    				break;
    			}
    		}
    		if(l==-1 || r==-1)
    			pw.println("NO");
    		else{
    			pw.println("YES");
    			pw.println(l+ " " + r);
    		}
    		pw.flush();
    		pw.close();
    	}
    }
    class Scanner {
        StringTokenizer st;
        BufferedReader br;
     
        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }
     
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
     
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
     
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
     
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
     
        public String nextLine() throws IOException {
            return br.readLine();
        }
     
        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }
     
        public boolean ready() throws IOException {
            return br.ready();
            
        }
    }