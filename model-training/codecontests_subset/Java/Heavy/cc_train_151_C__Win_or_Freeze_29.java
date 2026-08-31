import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class kok {
	
	static boolean isPrime(long nb){
		for(long i = 2; i * i < nb + 1; i++)
			if(nb % i == 0)
				return false;
		return true;
	}
	
	static boolean isBadNumber(long number){
		for(long i = 2; i * i < number + 1; i++)
			if(number % i == 0)
				if(isPrime(i) && isPrime(number / i))
					return true;
				
		return false;
	}
	
	static long divide(long number){
		long first = -1, second = -1;
		long temp = number;
		
		for(long i = 2; i < number / 2 + 1 && first == - 1 || second == -1; i++)
			while(temp % i == 0){
				if(first == -1)
					first = i;
				else
					second = i;
				
				temp /= i;
				
				if(first > 0 && second > 0) break;
			}
		 
		return first * second;
	}
	
	public static void main(String[] args) throws IOException {
		FastReader sc = new FastReader(System.in); 
		
		long number = sc.nextL();
		
		if(number == 1 || isPrime(number)){
			System.out.println("1\n0");	
			return;
		}
		
		if(isBadNumber(number)){
			System.out.println("2");
			return;
		}
		

		long res = divide(number);

		
		System.out.println("1\n" + res);
		
	}
}


class FastReader {
	public BufferedReader reader;
    public StringTokenizer tokenizer;

    public FastReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    
    public int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
     public long nextL() throws IOException{
        return Long.parseLong(next());
    }
}
