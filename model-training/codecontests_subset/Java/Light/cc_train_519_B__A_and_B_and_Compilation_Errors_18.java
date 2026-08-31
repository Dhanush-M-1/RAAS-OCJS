import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] sum = new int[3];
		for(int j=0; j < 3; ++j){
			String[] input = bf.readLine().split(" ");
			for (int i = 0; i < n-j; i++)
				sum[j] += Integer.parseInt(input[i]);
		}
		System.out.println(sum[0]-sum[1]);
		System.out.println(sum[1]-sum[2]);
	}

}
