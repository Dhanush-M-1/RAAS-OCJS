import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class C146 {	
	static PrintWriter out;
	
	public void solve(){				
		Scanner sc = new Scanner(System.in);		
		long N = sc.nextInt();
		if( N == 1)
			out.println(1);
		else if(N == 2)
			out.println(2);
		else if(N == 6)
			out.println( 5 * 4 * 3);
		else{
			if( N % 2 == 1){
				out.println( N * (N-1) * (N-2));
			}
			else{
				long tmp = N * (N-1);
				int t = 3;
				while( N % t == 0){
					t += 2;
				}
				tmp *= (N-t);
				
				out.println( Math.max( tmp, (N-1) * (N-2) * (N-3)) );
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out = new PrintWriter(new OutputStreamWriter(System.out));
		new C146().solve();
		out.close();
	}

}
