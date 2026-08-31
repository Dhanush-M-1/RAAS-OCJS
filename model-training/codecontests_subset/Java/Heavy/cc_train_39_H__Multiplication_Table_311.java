import java.util.*;
import java.io.*;
	public class yahia {
		static int n ;
		public static void main (String [] Yahia_Mostafa) throws Exception {
			Scanner sc =new Scanner(System.in);
			 n =sc.nextInt();
			StringBuilder sBuilder=new StringBuilder();
			for (int i =1;i<=n-1;++i) {
				for (int j =1 ;j<n;++j) {
					sBuilder.append(convert(i*j)+" ");
				}
				sBuilder.append("\n");
			}
			System.out.println(sBuilder);
		}
		static StringBuilder convert (int num) {
			StringBuilder x =new StringBuilder();
			while (num>0) {
				x.append(num%n);
				num/=n;
			}
			return x.reverse();
		}
		static class Scanner {
			StringTokenizer stringTokenizer;
			BufferedReader bfBufferedReader;
			public Scanner(InputStream system) {
				bfBufferedReader=new BufferedReader(new InputStreamReader( system));
			}
			 public Scanner(String file) throws Exception {
		            bfBufferedReader = new BufferedReader(new FileReader( file));
		        }
		 
		        public String next() throws IOException {
		            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
		                stringTokenizer = new StringTokenizer( bfBufferedReader.readLine());
		            return stringTokenizer.nextToken();
		        }
		 
		        public String nextLine() throws IOException {
		            return bfBufferedReader.readLine();
		        }
		 
		        public int nextInt() throws IOException {
		            return Integer.parseInt(next());
		        }
		 
		        public double nextDouble() throws IOException {
		            return Double.parseDouble(next());
		        }
		 
		        public char nextChar() throws IOException {
		            return next().charAt(0);
		        }
		 
		        public Long nextLong() throws IOException {
		            return Long.parseLong(next());
		        }
		 
		        public boolean ready() throws IOException {
		            return bfBufferedReader.ready();
		        }
		 
		        public void waitForInput() throws InterruptedException {
		            Thread.sleep(3000);
		        }
		    }
		}