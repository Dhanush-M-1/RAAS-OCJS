import java.util.*;
import java.io.*;

public class cp {
    public static void main(String args[]) {

    	Scanner sc = new Scanner();

    	int n = sc.nextInt();
    	int pos1=1;
    	int pos2 = 1000000;

    	HashSet<Integer> h = new HashSet<>();
    	for(int i=0;i<n;i++)
    	{
    		h.add(sc.nextInt());
    	}

    	int picked = 0;
int time = 0;
    	while(picked!=n)
    	{
    		time++;
    		pos1++;
    		pos2--;
    		if(h.contains(pos1))
    			picked++;
    		if(h.contains(pos2))
    			picked++;
    	}
    	out.println(time);
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