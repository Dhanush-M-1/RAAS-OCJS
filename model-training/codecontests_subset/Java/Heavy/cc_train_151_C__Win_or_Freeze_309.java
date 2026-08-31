
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class WinOrFreeze {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long q = Long.parseLong(in.readLine().trim());
		int n = (int) ( 2 *Math.sqrt(q) );
		boolean[] sieve = new boolean[n];
		Arrays.fill(sieve, true);
		sieve[0] = sieve[1] = false;
		ArrayList<Long> primes = new ArrayList<Long>();
		
		for(int i = 2; i < n ; ++i){
			long sq = ((long) i) * ((long) i);
			if(sieve[i]){
				primes.add((long) i);
				if( (sq < n)){
					for(int j = i*i; j < n ; j+=i){
						sieve[j] = false;
					}
				}
			}
		}
		if(q < 4){
			out.println("1\n0");
		} else {
			int[] cnt = new int[primes.size()];
			boolean oneWins = false;
			int count = 0;
			long qr = q;
			for(int i = 0; q > 1 && i < primes.size(); ++i){
				while(q % primes.get(i) == 0){
					q /= primes.get(i);
					cnt[i]++;
					count++;
				}
			}
			if(count > 2|| (count == 2 && q != 1 &&q != qr ))
				oneWins = true;
			if(q == qr || ((qr < n) && sieve[(int)qr])){
				out.println("1\n0");
			} else if(!oneWins) {
				out.println(2);
			} else {
				out.println(1);
				long res = 1;
				int prod = 0;
				for(int i = 0; prod < 2 && i < primes.size(); ++i){
					if(cnt[i] > 1){
						res = primes.get(i) * primes.get(i);
						prod = 2;
					} else if( cnt[i] !=0){
						res *= primes.get(i);
						prod++;
					}
				}
				out.println(res);
			}
		}
		in.close();
		out.close();
	}
}
