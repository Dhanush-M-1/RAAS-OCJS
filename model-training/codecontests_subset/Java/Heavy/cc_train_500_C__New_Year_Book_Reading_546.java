import java.io.*;
import java.util.*;


public class SolutionC {
	public void solve(){
		int n = nextInt(), m = nextInt();
		int[] w = new int[n], ord = new int[m];
		boolean[] h = new boolean[n];
		ArrayList<Book> ar = new ArrayList<Book>();
		for (int i = 0; i < n; i++) {
			w[i] = nextInt();
		}
		for (int i = 0; i < m; i++) {
			ord[i] = nextInt();
			if(!h[ord[i] - 1]){
				h[ord[i] - 1] = true;
				ar.add(new Book(ord[i], w[ord[i] - 1]));
			}
		}
		for(int i = 0 ; i < n ; i++){
			if(!h[i])
				ar.add(new Book(i + 1, w[i]));
		}
		

		long sum = 0;
		for(int i = 0 ; i < m ; i++){
			int j = 0;
			long pSum = 0;
			for(int k = 0 ; k < n ; k++){
				if(ar.get(k).id == ord[i]){
					j = k;
					break;
				}else{
					pSum += ar.get(k).w;
				}
			}
			sum+=pSum;
//			System.out.println("Size "+ar.size());
//			System.out.println("pSUm "+pSum);
			Book b = ar.get(j);
			ar.remove(j);
			ar.add(0, b);
		}
		out.println(sum);
	}
	class Book{
		int id, w;
		public Book(int i, int j){
			id = i;
			w = j;
		}
	}
	public void run(){
		solve();
		out.close();
	}
	public static void main(String args[]){
		new SolutionC().run();
	}
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	String line;
	StringTokenizer st;
	public String nextLine(){
		try {
			line = bf.readLine();
			st = new StringTokenizer(line);
		} catch (IOException e) {
			return null;
		}
		return line;
	}
	public String nextString(){
		while (st == null || !st.hasMoreElements()) {
            try {
                line = bf.readLine();
                st = new StringTokenizer(line);
            } catch (IOException e) {
                return null;
            }
        }
        return st.nextToken();
	}
	public int nextInt(){
		return Integer.parseInt(nextString());
	}
	public long nextLong(){
		return Long.parseLong(nextString());
	}
	public double nextDouble(){
		return Double.parseDouble(nextString());
	}
}
