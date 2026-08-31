
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException,IOException {
		
		Stdin in = new Stdin();
		PrintWriter out = new PrintWriter(System.out);
		int n=in.readInt();
		int m=in.readInt();
		int w[]=new int[n];
		int cost=0;
		for(int i=0;i<w.length;i++)
			w[i]=in.readInt();
		int b[]=new int[m];
		LinkedList<Integer>stack=new LinkedList<Integer>();
		LinkedList<Integer>move=new LinkedList<Integer>();
		for(int i=0;i<b.length;i++){
			b[i]=in.readInt()-1;
			if(i>0){
				if(stack.peek()!=b[i]){
					while(!stack.isEmpty()&&stack.peekFirst()!=b[i]){
						cost+=w[stack.peekFirst()];
						move.add(stack.removeFirst());
					}
					if(!stack.isEmpty()&&stack.peekFirst()==b[i])
						move.addFirst(stack.removeFirst());
					else
						move.addFirst(b[i]);
					while(!move.isEmpty())
						stack.addFirst(move.removeLast());
				}				
			}else
				stack.add(b[i]);
			
			
		}
		out.println(cost);
		out.flush();
		out.close();

	}

	private static class Stdin {
		InputStreamReader read;
		BufferedReader br;

		StringTokenizer st = new StringTokenizer("");

		private Stdin() {
			read = new InputStreamReader(System.in);
			br = new BufferedReader(read);

		}

		private String readNext() throws IOException {

			while (!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		private int readInt() throws IOException, NumberFormatException {

			return Integer.parseInt(readNext());

		}

		private long readLong() throws IOException, NumberFormatException {

			return Long.parseLong(readNext());

		}
	}
}
