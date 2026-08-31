import java.util.*;
import java.math.*;
import java.io.*;
public class experiment {
	 static class FastReader {
	        BufferedReader br;
	        StringTokenizer st;
	 
	        public FastReader()
	        {
	            br = new BufferedReader(
	                new InputStreamReader(System.in));
	        }
	 
	        String next()
	        {
	            while (st == null || !st.hasMoreElements()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                }
	                catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }
	 
	        int nextInt() { return Integer.parseInt(next()); }
	 
	        long nextLong() { return Long.parseLong(next()); }
	 
	        double nextDouble()
	        {
	            return Double.parseDouble(next());
	        }
	 
	        String nextLine()
	        {
	            String str = "";
	            try {
	                str = br.readLine();
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
	            return str;
	        }
	    }
		
		 public static void main(String[] args) throws IOException  {
			FastReader sc = new FastReader();
			PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
			int t  = sc.nextInt();
			while( t-- >0) {
				int k = sc.nextInt();
				int n = sc.nextInt();
				int m = sc.nextInt();
				Queue<Integer> fst = new LinkedList<>();
				Queue<Integer> scnd = new LinkedList<>();
				boolean check = true;
				ArrayList<Integer> ans = new ArrayList<>();
				for( int i = 0; i < n;i++) {
					fst.add(sc.nextInt());
				}
				for( int i = 0; i< m ;i++) {
					scnd.add(sc.nextInt());
				}
				while( !fst.isEmpty() || !scnd.isEmpty()) {
					if( !fst.isEmpty() && !scnd.isEmpty()) {
						if( fst.peek() <= k) {
							if( fst.peek() == 0) {
								k++;
							}
							ans.add(fst.poll());
							
						}
						else if( scnd.peek() <= k) {
							if( scnd.peek() == 0) {
								k++;
							}
							ans.add(scnd.poll());
						}
						else {
							check = false;
							break;
						}
						
					}
					else if( !fst.isEmpty()) {
						if( fst.peek() <= k) {
							if( fst.peek() == 0) {
								k++;
							}
							ans.add(fst.poll());
						}
						else {
							check = false;
							break;
						}
					}
					else {
						if( scnd.peek() <= k) {
							if( scnd.peek() == 0) {
								k++;
							}
							ans.add(scnd.poll());
						}
						else {
							check = false;
							break;
						}
					}
				}
				if( check) {
					for( int x : ans) {
						out.print(x + " ");
					}
					out.println();
				}
				else {
					out.println(-1);
				}
			}
			out.flush();
				
		}
}