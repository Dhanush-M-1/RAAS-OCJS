import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Contest {
	private static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		ArrayList<Long> f = factorize(n);
		if(f.size() <= 1)
			out.println("1\n0");
		else if(f.size() > 2)
			out.println("1\n" + (f.get(0)*f.get(1)));
		else
			out.println(2);
		out.flush();

	}

	private static ArrayList<Long> factorize(long n) {
		ArrayList<Long> factors = new ArrayList<>();
		if(n == 1)
			return factors;
		for(long i = 2; i * i <= n && factors.size() <= 3;i++) {
			while(n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if(n > 1)
			factors.add(n);
		return factors;
	}
}
