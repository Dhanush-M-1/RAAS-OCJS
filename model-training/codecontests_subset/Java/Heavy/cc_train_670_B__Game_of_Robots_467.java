import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B670 {

	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		long n = Integer.parseInt(a[0]);
		long k = Integer.parseInt(a[1]);
		int[] arr = new int[(int) n];
		a = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(a[i]);
		}
		long r = (int)(-1 + Math.sqrt(1 + 8*k))/2;
		k = k - r*(r+1)/2;
		//System.out.println(r +" "+k);
		if(k == 0)
			System.out.println(arr[(int)r-1]);
		else System.out.println(arr[(int)k-1]);
		
		
	}

}