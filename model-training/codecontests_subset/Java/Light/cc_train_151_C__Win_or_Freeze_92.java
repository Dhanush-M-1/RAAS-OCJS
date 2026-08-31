import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
   public static void main(String[] args) throws IOException
   {
	   (new Main()).solve();
   }
   public void Main() {
   }
   

   void solve()  throws IOException {
	  //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   Scanner in = new Scanner(System.in);
	  PrintWriter out = new PrintWriter(System.out);
     // Scanner in = new Scanner(new FileReader("input.txt"));
	//  PrintWriter out = new PrintWriter("output.txt");
	long q = in.nextLong();
	boolean flag = true;
	long d = 0;
	for (long i = 2; i*i <= q; i++) {
		if (q % i == 0) {
			flag = false;
			d = i;
			break;
		}
	}
	if (flag) {
		out.println(1);
		out.println(0);
	} else {
		boolean f  = true;
		long s = q / d;
		long d2 = 0;
		for (long i = 2; i*i <= s; i++) {
			if (s % i == 0) {
				f = false;
				d2 = i;
				break;
			}
		}		
		if (f) {
			out.println(2);
		} else {
			out.println(1);
			out.println(d*d2);
		}
	}
	
	 
	 out.close(); 
   }     

};
