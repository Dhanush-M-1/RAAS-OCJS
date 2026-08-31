import java.util.*;

public class mafia {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long sum = 0;
		long max = 0;
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		if(sum%(n-1) == 0)
			sum /= n-1;
		else {
			sum /= n-1;
			sum++;
		}
		sum = sum > max ? sum : max; 
		System.out.println(sum);
	}
}