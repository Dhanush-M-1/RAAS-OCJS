import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class D {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		int d = fr.nextInt();
		long[] ia = new long[n];
		long[] presum = new long[n];
		ia[0] = fr.nextInt();
		presum[0] = ia[0];
		if(ia[0] > d) {
			System.out.println(-1);
			return;
		}
		for(int i = 1; i < n; i++){
			ia[i] = fr.nextInt();
			presum[i] = presum[i-1]+ia[i];
			if(presum[i] > d){
				System.out.println(-1);
				return;
			}
		}
		long[] maxdepo = new long[n];
		maxdepo[n-1] = presum[n-1];
		for(int i = n-2; i >= 0; i--){
			maxdepo[i] = Math.max(maxdepo[i+1], presum[i]);
		}
		for(int i = 0; i < n; i++){
			maxdepo[i] = d-maxdepo[i];
		}
		int v = 0;
		long depo = 0;
		for(int i = 0; i < n; i++){
			if(ia[i] == 0 && presum[i] + depo < 0){
				long t = -1*(presum[i] + depo);
				if(t > maxdepo[i] - depo){
					System.out.println(-1);
					return;
				}
				depo=maxdepo[i];
				v++;
			}
		}
		System.out.println(v);
	}
}

class FastReader{
	BufferedReader br;
	StringTokenizer st;

	FastReader(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next(){
		while(st==null || !st.hasMoreTokens()){
			try{
				st = new StringTokenizer(br.readLine());
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt(){
		return Integer.parseInt(next());
	}

	long nextLong(){
		return Long.parseLong(next());
	}

	double nextDouble(){
		return Double.parseDouble(next());
	}

	String nextLine(){
		String str = "";
		try{
			str = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return str;
	}
}

//source: http://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/