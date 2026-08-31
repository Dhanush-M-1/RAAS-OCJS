import java.util.Scanner;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
public class XORinnaci
{
	public static void main(String[] args)
	{
		getXorinacci();
	
	}

	private static void getXorinacci(){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		String[] outputs = new String[t];
		int i = 0;
		while( t-- > 0 )
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			outputs[i++] = helper(a,b,n).toString();
		}
		for(String e : outputs)
			System.out.println(e);
	}

	private static BigInteger helper(int a, int b, int n)
	{
		BigInteger[] arr = new BigInteger[3];
		arr[0] = new BigInteger(Integer.toString(a));
		arr[1] = new BigInteger(Integer.toString(b));
		arr[2] = arr[0].xor(arr[1]);
		return arr[n % 3];
	}
		
		/*{
		List<BigInteger> arr = new ArrayList<>();	
		arr.add(new BigInteger(Integer.toString(a)));
		arr.add( new BigInteger(Integer.toString(b)));
		for( int i = 2 ; i <= n ; ++i )
		{
			arr.add(arr.get(i-1).xor(arr.get(i-2)));
		}
		return arr.get(n);
	
	}*/

}
