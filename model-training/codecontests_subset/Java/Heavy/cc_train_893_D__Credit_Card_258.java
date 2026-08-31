import java.io.*;
import java.util.*;

public class D33_1 {
    public static void main(String[] args) {
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter(System.out);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; ++i) {
        	a[i] = in.nextInt();
        }
        int bal[] = new int[n];
        bal[0] = a[0];
        for(int i = 1; i < n; ++i) {
        	bal[i] = bal[i - 1] + a[i];
        }
        int maxSufBal[] = new int[n];
        maxSufBal[n - 1] = bal[n - 1];
        for(int i = n - 2; i >= 0; --i) {
        	maxSufBal[i] = Integer.max(maxSufBal[i + 1], bal[i]);
        }
        int cur = 0;
        int days = 0;
        for(int i = 0; i < n; ++i) {
        	if(bal[i] > d) {
        		System.out.println(-1);
        		return;
        	}
        	if(a[i] == 0 && bal[i] + cur < 0) {
        		int delta = d - maxSufBal[i] - cur;
        		if(bal[i] + cur + delta < 0) {
        			System.out.println(-1);
        			return;
        		}
        		cur += d - maxSufBal[i] - cur;
        		days++;
        	}
        }
        System.out.println(days);
    }

    public static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }
    
    static class InputReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public InputReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
