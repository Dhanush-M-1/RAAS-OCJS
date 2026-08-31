
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main{
	public static void main(String args[]) throws NumberFormatException,IOException {
		Stdin in=new Stdin();
		PrintWriter out = new PrintWriter(System.out);
		int n=in.readInt();
		int c=in.readInt();
		int []x=new int[n];
		for(int i=0;i<x.length;i++)
			x[i]=in.readInt();
		int max=0;
		for(int i=0;i<x.length-1;i++)
				max=Math.max(max,x[i]-x[i+1]-c);
			
		out.print(max);
		out.flush();
	}
	private static class Stdin {
		InputStreamReader read;
		BufferedReader br;

		StringTokenizer st=new StringTokenizer("");
		private Stdin() {
			read = new InputStreamReader(System.in);
			br = new BufferedReader(read);
			
		}

		private String readNext() throws IOException{
			
			while(!st.hasMoreTokens())
				st=new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		private int readInt() throws IOException ,NumberFormatException{
			
			return Integer.parseInt(readNext());
			
		}

		private long readLong() throws IOException ,NumberFormatException{
			
			return Long.parseLong(readNext());
			
		}	
	}
}
