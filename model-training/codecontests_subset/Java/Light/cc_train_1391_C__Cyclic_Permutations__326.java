import java.util.*;
import java.io.*;
public class Main {

	static ArrayList<Integer> primes = new ArrayList<>();
	static ArrayList<Integer> prefix = new ArrayList<>();
	public static void main(String[] args)throws IOException {

		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		//****
		// br = new BufferedReader(new FileReader("input.txt"));
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		//****
		int t = 1;
		int mod = (int)(1e9 + 7);
		StringBuffer ans = new StringBuffer();
		while (t-- > 0) {

			int n = Integer.parseInt(br.readLine().trim());
			long answer = bin(2, n - 1, mod);
			
			long fact = (long)factmod(n,mod);

// 			System.out.println(answer+" "+fact);
			long res = (fact%mod-answer%mod)%mod;
			if(res<0)
			res=(res+mod)%mod;
			ans.append(res );
			ans.append("\n");
		}
		System.out.print(ans);













		//To Comment
		// out.flu/sh();
	}
	static long bin( long a,  long b,  long mod) {
		a %= mod;
		long result = 1;
		while (b > 0) {
			if (b % 2 == 1)
				result = result * a % mod;
			a = a * a % mod;
			b >>= 1;
		}
		return result;
	}
	
	static long factmod(long n, long p) {
     if (n >= p) 
        return 0; 
  
    long result = 1; 
    for (long i = 1; i <= n; i++) {
         result = (result * i) % p; 
    }
       
  
    return result; 
    }
}
