import java.util.*;
// import java.lang.*;
import java.io.*;

//           THIS TEMPLATE MADE BY AKSH BANSAL.

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        // ________________________________

        // int t = sc.nextInt();
        // StringBuilder output = new StringBuilder();

        // while (t-- > 0) {

        //     output.append(solver()).append("\n");
        // }

        // out.println(output);
        // _______________________________

        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList <Integer> a=new ArrayList();
		ArrayList <Integer> b=new ArrayList();
		ArrayList <Integer> c=new ArrayList();
		for(int i=0;i<n;i++)
		{
			int t=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			if(x==1 && y==1)
				a.add(t);
			else if(x==1 && y==0)
				b.add(t);
			else if(x==0 && y==1)
				c.add(t);
		}
		Collections.sort(b);
		Collections.sort(c);
		int j=0;
		while(j<b.size() && j<c.size())
		{
			a.add(b.get(j)+c.get(j));
			j++;
		}
		Collections.sort(a);
		if(a.size()<k)
				out.println(-1);
		else
		{
			int sum=0;
			for(int i=0;i<k;i++)
				sum+=a.get(i);
			out.println(sum);
		}
        // ________________________________
        out.flush();
    }

}