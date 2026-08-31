import java.util.Scanner;
import java.math.BigInteger;
public class TheBestGift{
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		int [] arr = new int[m];
		BigInteger result = new BigInteger("" + n);
		result = result.multiply(new BigInteger("" + (n-1)));
		result = result.divide(new BigInteger("" + 2));
		int temp = 0;
		for(int i=0; i<n; i++){
			temp = reader.nextInt();
			arr[temp-1]++;
		}
		for(int i=0; i<m; i++){
			if(arr[i] >= 2){
				BigInteger temporary = new BigInteger("" + arr[i]);
				temporary = temporary.multiply(new BigInteger("" + (arr[i]-1)));
				temporary = temporary.divide(new BigInteger("" + 2));
				result = result.subtract(temporary);
			}
		}
		System.out.println(result);
	}
}