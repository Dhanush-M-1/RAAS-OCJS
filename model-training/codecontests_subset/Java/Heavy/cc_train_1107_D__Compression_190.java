import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		char[][] a = new char[n][];
		for(int i = 0; i < n ; ++i) {
			StringBuilder sBuilder = new StringBuilder();
			String s = bufferedReader.readLine();
			for(int j = 0; j < n / 4; ++j) {
				char c = s.charAt(j);
				if(c >= 'A' && c <= 'F') {
					int m = 10 + (c - 'A');
					int add = 4 - Integer.toBinaryString(m).length();
					for(int k = 0; k < add; ++k) sBuilder.append('0'); 
					sBuilder.append(Integer.toBinaryString(m));
				}else {
					int add = 4 - Integer.toBinaryString(c - '0').length();
					for(int k = 0; k < add; ++k) sBuilder.append('0');
					sBuilder.append(Integer.toBinaryString(c - '0'));
				}
			}
			a[i] = sBuilder.toString().toCharArray();
		}
		
		int[][] sum = new int[n][n];
		for(int i = 0; i < n ; ++i)
			for(int j = 0 ; j < n ; ++j)
				sum[i][j] = a[i][j] - '0';
		
		for(int i = 0; i < n ; ++i)
			for(int j = 1; j < n; ++j)
				sum[i][j] += sum[i][j - 1];
		
		for(int j = 0; j < n ; ++j)
			for(int i = 1; i < n ; ++i)
				sum[i][j] += sum[i - 1][j];
		
		
		loop:
		for(int x = n; x > 0; --x) {
			if(n % x == 0) {
				for(int i = 0; i < n ; i += x) {
					for(int j = 0; j < n ; j += x) {
						int res = 0;
						res = sum[i + x - 1][j + x - 1] -
								((i > 0)?sum[i - 1][j + x - 1]:0) - 
								((j > 0)?sum[i + x - 1][j - 1]:0) + 
								((i > 0 && j > 0)?sum[i - 1][j - 1]:0);
						
						if(res != x * x && res != 0) {
							continue loop;
						}
					}
					
				}
				
				System.out.println(x);
				return;
			}
		}
	}	
}


