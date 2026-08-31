import java.io.*;
import java.util.*;

public class H {
	static int k;
	public static void main(String arg[])throws Exception{
		BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wff = new BufferedWriter(new OutputStreamWriter(System.out));
		
		k = Integer.parseInt(bff.readLine());
		
		int[][] mat = new int[k - 1][k - 1];
		
		for(int i = 1; i < k; i++)
			for(int j = i; j < k; j++){
				mat[i - 1][j - 1] = radix(i * j);
				mat[j - 1][i - 1] = mat[i - 1][j - 1];
			}
		
		for(int i = 0; i < k - 1; i++){
			for(int j = 0; j < k - 1; j++){
				if(j != 0)
					wff.write(" ");
				wff.write(mat[i][j] + "");
			}
			wff.newLine();
		}
		wff.flush();
	}
	static int radix(int n){
		return (n / k) * 10 + (n % k);
	}
}
