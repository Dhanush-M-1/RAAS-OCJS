import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

	public static void main(String[] args) throws IOException {

		StringBuilder buider = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();

		String nums;

		int count=0;
		for(int i=0; i<Integer.parseInt(n); i++){
			 nums = br.readLine();
			if(new BigInteger(nums).isProbablePrime(3)){
				count++;
			}
		}

		System.out.println(count);

	}

}