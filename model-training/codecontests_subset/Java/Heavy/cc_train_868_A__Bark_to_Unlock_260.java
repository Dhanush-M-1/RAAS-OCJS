import java.io.*;
import java.util.*;

public class Bark{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String pass = sc.next();
        boolean first = false;
        boolean last = false;
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String t = sc.next();
            if(pass.charAt(0)==t.charAt(1)){
                last=true;
            }
            if(pass.charAt(1)==t.charAt(0)){
                first=true;
            }
            if(t.equals(pass)){
                last=true;
                first=true;
            }   
        }
        if(first && last)
            pw.println("YES");
        else
            pw.println("NO");
        pw.close();
    }
    static class Scanner {
	StringTokenizer st;
	BufferedReader br;
        
	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}
        
	public Scanner(String file) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(file));
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
		return Double.parseDouble(next());
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

    }
}

