		import java.util.*;
		import java.io.*;
		import java.text.*;
		import java.math.*;
		
		public class Codeforces{
			boolean multipleTC=false;
			int INF=(int)1e9+7;
			
			void solve( int tc )throws Exception{
				
				int n = ni(), m=ni();
				int[]a = ia(n);
				Arrays.sort(a);
				
				int sm = -1, bg = -1, eq = -1;
				for( int i=0; i<n; i++ ){
					if( bg==-1 && (a[i]>m) )bg=i;
					if( a[i]<m ) sm=i;
					if( eq==-1 && a[i]==m ) eq=i;
				}
				long ans=0;
				int med = n>>1;
				if( eq==med ){ pn(0); return; }
				if( sm>=med ){
					for( int i=sm; i>=med; i-- )ans+=m-a[i];
				}else if( bg<=med ){
					for( int i=bg; i<=med; i++ )ans+=a[i]-m;
				}
				pn(ans);
			}
			
			void run() throws Exception{
				in = new FastReader();
				out = new PrintWriter( System.out );
				for( int i=1, t=(multipleTC)?ni():1 ; i<=t; i++ )solve(i);
				out.flush();
				out.close();
			}
			
			
			public static void main( String[]args )throws Exception{
				new Codeforces().run();
			}
			
			FastReader in;
			PrintWriter out;
			
			long[]la( int n )throws Exception{ long[]a=new long[n]; for( int i=0; i<n; i++ )a[i]=nl(); return a; }
			int[]ia( int n )throws Exception{ int[]a=new int[n]; for( int i=0; i<n; i++ )a[i]=ni(); return a; }
			int gcd( int a, int b ){ return (b==0)?a:gcd(b,a%b); }
			void p(Object o){ out.print(o); }
			void pn(Object o){ out.println(o); }
			void pni(Object o){ out.println(o); out.flush(); }
			String n(){ return in.next(); }
			int ni() throws Exception{ return Integer.parseInt(in.next()); }
			long nl() throws Exception{ return Long.parseLong(in.next()); }
			
			class FastReader{
				BufferedReader br;
				StringTokenizer st;
				public FastReader(){
					br=new BufferedReader(new InputStreamReader(System.in));
				}
				String next(){
					while( st==null || !st.hasMoreElements() ){
						try{
							st = new StringTokenizer( br.readLine() );
						}catch( IOException e ){
							e.printStackTrace();
						}
					}return st.nextToken();
				}
				String nextLine(){
					String str = "";
					try{
						str = br.readLine();
					}catch( IOException e ){
						e.printStackTrace();
					}return str;
				}
			}
		}
