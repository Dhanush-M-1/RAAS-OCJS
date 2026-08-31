import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class question1
{ 
	
	public static void main(String[] args) throws Exception, Exception {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		int t = Integer.parseInt(br.readLine());
		//System.out.println(3^4);
		while(t-->0) {
			String ab[] = br.readLine().split(" ");
			long a  = Long.parseLong(ab[0]);
			long b  = Long.parseLong(ab[1]);
			long n  = Long.parseLong(ab[2]);
			long arr[] = new long[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = a^b;
			long l = n%3;
			System.out.println(arr[(int)l]);
			
		}
	}
} 
