import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class no2 {

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(read.readLine());
		
		StringTokenizer str = new StringTokenizer(read.readLine());
		int[] num = new int[n];
		Stack<Integer> odd = new Stack<>();
		Stack<Integer> even = new Stack<>();
		for ( int i = 0; i < n; i++ )
			num[i] = Integer.parseInt(str.nextToken());
		Arrays.sort(num);
		for ( int i = 0; i < n; i++ ) {
			if ( num[i] % 2 == 0 )
				even.add(num[i]);
			else
				odd.add(num[i]);
		}
		
		while ( !even.isEmpty() && !odd.isEmpty() ) {
			even.pop(); odd.pop();
		}
		
		if ( !even.isEmpty() ) {
			even.pop();
		} else if ( !odd.isEmpty() ) {
			odd.pop();
		}
		long sum = 0;
		while ( !even.isEmpty() ) {
			sum += even.pop();
		}
		while ( !odd.isEmpty() ) {
			sum += odd.pop();
		}
		System.out.println(sum);
	}

}
