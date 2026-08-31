import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class FoxDividingCheese {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long a=Integer.parseInt(st.nextToken());
		long b=Integer.parseInt(st.nextToken());
		long g=gcd(a,b);
		a/=g;
		b/=g;
		int ctr=0;
		while(a%2==0){
			a/=2;
			ctr++;
		}
		while(a%3==0){
			a/=3;
			ctr++;
		}
		while(a%5==0){
			a/=5;
			ctr++;
		}
		while(b%2==0){
			b/=2;
			ctr++;
		}
		while(b%3==0){
			b/=3;
			ctr++;
		}
		while(b%5==0){
			b/=5;
			ctr++;
		}
		if(a!=b)
			bw.append("-1\n");
		else
			bw.append(ctr+"\n");
		bw.flush();
	}
	static long gcd(long a, long b){
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
	}
}
