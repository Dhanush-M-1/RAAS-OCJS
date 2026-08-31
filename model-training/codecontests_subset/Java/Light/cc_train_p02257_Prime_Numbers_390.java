import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		int count = 0;
		
		String str;
		while((str = br.readLine()) != null){
			if(isPrime(Long.valueOf(str)))
				count++;
		}
		System.out.println(count);
	}
	
	private static boolean isPrime(long n){
		if(n < 2)
			return false;
		else if(n == 2)
			return true;
		
		if(n % 2 == 0)
			return false;
		
		for(long i = 3;i <= n / i; i += 2)
			if(n % i == 0)
				return false;
		return true;
		
	}
}