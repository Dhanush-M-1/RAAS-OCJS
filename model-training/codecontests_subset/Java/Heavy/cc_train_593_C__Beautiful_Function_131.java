import java.util.*;
import java.io.*;
public class C {
	static int[] X, Y, R;
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		X = new int[n];
		Y = new int[n];
		R = new int[n];
		StringTokenizer st;
		for(int i = 0; i < n; i++){
			int x, y, r;
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			X[i] = x;
			Y[i] = y;
			R[i] = r;
		}
		int[] A = new int[n], B = new int[n];
		int preva = X[0]%2==0?X[0]:X[0]-1;
		int prevb = Y[0]%2==0?Y[0]:Y[0]-1;
		for(int i = 1; i < n; i++){
			int a = X[i]%2==0?X[i]:X[i]-1;
			int b = Y[i]%2==0?Y[i]:Y[i]-1;
			A[i] = a-preva;
			B[i] = b-prevb;	
			preva = a; prevb = b;
		}
		int[] C = new int[n], D = new int[n];
		for(int i = 1; i < n; i++){
			C[i-1] += A[i]/2;
			C[i] -= A[i]/2;
			D[i-1] += B[i]/2;
			D[i] -= B[i]/2;
		}
		Function f = new Function();
		Function g = new Function();
		int _f = 0, _g = 0;
		for(int i = 0; i < n; i++){
			if(C[i] >= 0) f.add(String.format("+(%d*abs((t-%d)))", C[i], i));
			else f.add(String.format("-(%d*abs((t-%d)))", -C[i], i));
			if(D[i] >= 0) g.add(String.format("+(%d*abs((t-%d)))", D[i], i));
			else g.add(String.format("-(%d*abs((t-%d)))", -D[i], i));
			_f -= C[i]*i; _g -= D[i]*i;
		}
		if((X[0]+_f) >= 0) f.add(String.format("+%d", (X[0]+_f)));
		else f.add(String.format("%d", (X[0]+_f)));
		if((Y[0]+_g) >= 0) g.add(String.format("+%d", (Y[0]+_g)));
		else g.add(String.format("%d", (Y[0]+_g)));
		System.out.println(f);
		System.out.println(g);
	}
	
	static class Function{
		public StringBuilder sb = new StringBuilder();
		public Function(){
			sb.append("0");
		}
		public void add(String k){
			sb.insert(0, "(").append(k).append(")");
		}
		public String toString(){
			return sb.toString();
		}
	}

}
