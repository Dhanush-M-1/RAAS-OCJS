import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class cf {
    public static void main(String[] args) {
        try {
            InputStream inputStream=System.in;
            OutputStream outputStream=System.out;
            //InputStream inputStream=new FileInputStream("file.in");
            //OutputStream outputStream=new FileOutputStream("file.out");
            InputReader in=new InputReader(inputStream);
            PrintWriter out=new PrintWriter(outputStream);
            Task task=new Task();
            task.run(in,out);
            out.close();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {System.out.print("File not found.");}
            else {e.printStackTrace();}
        }
    }
}

class InputReader {
    private BufferedReader br;
    private StringTokenizer st;
    public InputReader(InputStream stream) {
        br=new BufferedReader(new InputStreamReader(stream),32768);
        st=null;
    }
    public String next() {
        while (st==null || !st.hasMoreTokens()) {
            try {
                st=new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }
    public int nextInt() {return Integer.parseInt(next());}
    public long nextLong() {return Long.parseLong(next());}
    public double nextDouble() {return Double.parseDouble(next());}
    public int[] nextIntArray(int n) {
        int[] a=new int[n];
        for (int i=0;i<n;i++) {a[i]=nextInt();}
        return a;
    }
    public long[] nextLongArray(int n) {
        long[] a=new long[n];
        for (int i=0;i<n;i++) {a[i]=nextLong();}
        return a;
    }
}

class Task {
    public void run(InputReader in, PrintWriter out) {
		int n=in.nextInt(),k=in.nextInt();
		int a=in.nextInt(),b=in.nextInt(),c=in.nextInt(),d=in.nextInt();
		if (n==4) {out.print(-1);return;}
		if (k<n+1) {out.print(-1);return;}
		List<Integer> x=new ArrayList<Integer>();
		for (int i=1;i<=n;i++) {
			if (i!=a&&i!=b&&i!=c&&i!=d) {
				x.add(i);
			}
		}
		out.print(a+" "+c+" "+x.get(0)+" "+d+" ");
		for (int i=1;i<x.size();i++) {
			out.print(x.get(i)+" ");
		}
		out.print(b+"\n"+c+" "+a+" "+x.get(0)+" "+b+" ");
		for (int i=x.size()-1;i>0;i--) {
			out.print(x.get(i)+" ");
		}
		out.print(d);
	}
}
