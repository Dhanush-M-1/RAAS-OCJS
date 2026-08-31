import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class ReachMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyScanner input =new MyScanner();
		int n = input.nextInt();
		int s = input.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n;i++)arr[i] = input.nextInt();
		Arrays.sort(arr);
	
		int z = n/2;
		if(arr[z]<s){
			long total=0;
			total+=(s-arr[z]);
			for(int j=n/2+1;j<n;j++){
				total+=Math.max(s-arr[j],0);
			}
			System.out.println(total);
		}
		else if(arr[z]>s){
			long total=0;
			total+=(arr[z]-s);
			for(int j=n/2-1;j>=0;j--){
				total+=Math.max(arr[j]-(s),0);
			}
			System.out.println(total);
		}
		else{
			System.out.println(0);
		}
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}


}
