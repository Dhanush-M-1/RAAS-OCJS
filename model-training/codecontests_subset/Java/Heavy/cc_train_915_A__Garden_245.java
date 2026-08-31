import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] arr = str.split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		
		String str1 = br.readLine();
		String[] strArr1 = str1.split(" ");
		
		int[] arrN = new int[n];
		
		for(int i = 0 ; i < n; i++){
			arrN[i] = Integer.parseInt(strArr1[i]);
		}
		solve(n,k,arrN);
	}

	private static void solve(int n, int k, int[] arrN) {
		Arrays.sort(arrN);
		
		for(int i = n-1 ; i>=0 ; i--){
			if(k%arrN[i] == 0){
				System.out.println(k/arrN[i]);
				break;
			}
		}
	}
}