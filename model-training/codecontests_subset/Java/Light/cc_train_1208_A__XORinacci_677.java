import java.io.*;
import java.util.*;

public class Xorinacci {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int getFibXor(int a, int b, int N) {
		if(N % 3 == 0)
			return a;
		if(N % 3 == 1)
			return b;
		return a ^ b;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			bw.write(getFibXor(a, b, N) + "\n");
		}
		bw.flush();
	}

}