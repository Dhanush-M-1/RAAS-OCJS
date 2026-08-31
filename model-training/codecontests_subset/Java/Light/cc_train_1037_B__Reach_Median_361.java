
import java.util.Arrays;
import java.util.Scanner;

public class ManthanA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = in.nextInt();
		}
		in.close();
		Arrays.sort(arr);
		long ans = 0;
		int i = n/2;
		while(i < n && arr[i] < s)
		{
			
			ans+= Math.abs(arr[i]-s);
			arr[i] = s;
			i++;
		}
		i = n/2;
		while(i >= 0 && arr[i] > s)
		{
			ans+= Math.abs(arr[i]-s);
			arr[i] = s;
			i--;
		}
		System.out.println(ans);
		
	}

}
