import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner sc = new MyScanner();
		int A = sc.nextInt();
		int B = sc.nextInt();
	
		TaskA tsk = new TaskA( A, B );
		System.out.println( tsk.sol() );

	}
	
	
	static public class TaskA {
		
		int A;
		int B;
		
		public TaskA( int A, int B ){
			this.A = A;
			this.B = B;
		}
		
		public int sol( ){
			
			
			int best = 0;
			int nm = 0;
			int vA;
			int vB;
			
			for( int i = 2; i <= Math.sqrt( B ); ++i ){
				vA = A / i;
				vB = B / i;
				
				if( A % i != 0 )
					++vA;
				
				if( best <= vB - vA + 1 ){
					best = vB - vA + 1;
					nm = i;
				}
			}
			if( best == 0 )
				nm = A;
			return nm;			
		}
			
	}
   
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
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
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }

	
}
