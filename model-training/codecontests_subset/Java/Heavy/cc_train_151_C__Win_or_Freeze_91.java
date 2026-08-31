import java.util.List;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author codeKNIGHT
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        long q=in.nextLong();
        if(q==1)
        {
            out.println(1);
            out.println(0);
            return;
        }
        List<Long> factors=primeFactors(q);
        if(factors.size()==1)
        {
            out.println(1);
            out.println(0);
        }
        else if(factors.size()==2)
        {
            out.println(2);
        }
        else {
            out.println(1);
            out.println(factors.get(0)*factors.get(1));
        }

	}
    public boolean isPrime(long n)
    {

    if(n<=2)
    return true;
    if(n%2==0)
    return false;
    int i,sqrt=(int)Math.sqrt(n);
    for(i=3;i<=sqrt;i+=2)
    {
        if(n%i==0)
        return false;
    }
    return true;
    }
    public static List<Long> primeFactors(long numbers) {
		long n = numbers;
		List<Long> factors = new ArrayList<Long>();
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}
}

