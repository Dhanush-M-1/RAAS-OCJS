import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int x = Integer.parseInt(input[1]);
		int y = Integer.parseInt(input[2]);
		char[] arr = br.readLine().trim().toCharArray();
		int i;
		int cnt = 0;
		
		
		for (i=n-x ; i<=n-1 ; i++) {
			if (i==n-1-y) {
				if (arr[i]=='0')
					cnt++;
			}else {
				if (arr[i]=='1')
					cnt++;
			}
		}

		
		System.out.println(cnt);
	}
}
