import java.util.*;
import java.io.*;

public class cp {
    public static void main(String args[]) {

    	Scanner sc = new Scanner();

    	int t = sc.nextInt();

    	while(t-->0)
    	{
    		int n = sc.nextInt();
    		
    		int max = 0;
    		int min = Integer.MAX_VALUE;

    		for(int i=0;i<n;i++)
    		{
    			int a = sc.nextInt();
    			int b = sc.nextInt();
    			max = Math.max(max,a);
    			min = Math.min(min,b);
    		}
    		out.println(Math.max(0,max-min));
    	}
    	out.close();
    }
    static	PrintWriter out=new PrintWriter(System.out);
	static class Scanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String nextLine() {
			while (!st.hasMoreTokens())
				try { 
                                        st=new StringTokenizer(br.readLine());				               
                                } catch (IOException e) {}
			return st.nextToken();
		}
		char nextChar() {
			char c = '$';
				try { 
                                        c = (char)br.read();			               
                                } catch (IOException e) {}
			return c;
		}		
		int nextInt() {
			return Integer.parseInt(nextLine());
		}
		double nextDouble() {
			return Double.parseDouble(nextLine());
		}
		long nextLong() {
			return Long.parseLong(nextLine());
		}
	}
}