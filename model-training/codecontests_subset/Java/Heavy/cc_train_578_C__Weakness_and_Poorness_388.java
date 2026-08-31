
import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
    	InputReader scan = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter pw = new PrintWriter(outputStream);
        int n = scan.nextInt();
        int x[] = new int[n];
        double l = -100000;
        double r = 100000;
        for(int i=0;i<n;i++){
        	x[i] = scan.nextInt();
        }
        int count = 100;
        while(count-->0)
        {
        	double m1 = l+(r-l)/3;
        	double m2 = r-(r-l)/3;
        	//pw.println(m);
        	if(maxsum(m1,x,n)>maxsum(m2,x,n))
        		l = m1;
        	else
        		r = m2;
        }
        pw.println(maxsum(l,x,n));
        pw.flush();
        pw.close();
    }
    static double maxsum(double m,int x[],int n)
    {
    	double sum1 = 0,sum2=0,ans=0;
    	for(int i=0;i<n;i++)
    	{
    		sum1+=(x[i]-m);
    		sum2+=(m-x[i]);
    		ans = Math.max(sum1, ans);
    		ans = Math.max(sum2, ans);
    		sum1 = Math.max(sum1, 0);
    		sum2 = Math.max(sum2, 0);
    	}
    	return ans;
    }
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream inputstream) {
		reader = new BufferedReader(new InputStreamReader(inputstream));
		tokenizer = null;
	}

	public String nextLine(){
		String fullLine=null;
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				fullLine=reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return fullLine;
		}
		return fullLine;
	}
	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}
	public long nextLong() {
		return Long.parseLong(next());
	}
	public int nextInt() {
		return Integer.parseInt(next());
	}
}
