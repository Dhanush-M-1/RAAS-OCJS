//https://codeforces.com/contest/371/problem/B
//B. Fox Dividing Cheese
import java.util.*;
import java.io.*;
public class CF_371_B{

	static int a, b;
	static int count_division_a(int i){
		int count = 0;
		while(a%i==0){
			a/=i;
			count++;
		}
		return count;
	}

	static int count_division_b(int i){
		int count = 0;
		while(b%i==0){
			b/=i;
			count++;
		}
		return count;
	}

	static int solve(){
		int a2 = count_division_a(2);
		int a3 = count_division_a(3);
		int a5 = count_division_a(5);

		int b2 = count_division_b(2);
		int b3 = count_division_b(3);
		int b5 = count_division_b(5);

		if(a!=b)
			return -1;
		else
			return Math.abs(a2-b2)+Math.abs(a3-b3)+Math.abs(a5-b5);
	} 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		sb.append(solve());

		pw.print(sb);
		pw.flush();
		pw.close();
	}
}