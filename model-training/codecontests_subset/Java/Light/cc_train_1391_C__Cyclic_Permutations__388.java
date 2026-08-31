import java.io.*;
public class CyclicPerm {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long temp = 1;
		for(int i = 2; i <= N; i++) {
			temp *= i;
			temp %= 1000000007;
		}
		long terp = 1;
		for(int i = 0; i <N-1; i++) {
			terp *= 2;
			terp %= 1000000007;
		}
		temp -= terp;
		if(temp < 0) {
			temp = 1000000007+temp;
		}
		temp %= 1000000007;
		System.out.println(temp);
	}

}
