import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int[] a = new int[n];
		str = br.readLine().split(" ");
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(str[i]);
		str = br.readLine().split(" ");
		int q = Integer.parseInt(str[0]);
		for(int i = 0; i < q; i++){
			str = br.readLine().split(" ");
			int b = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			int t = Integer.parseInt(str[2]);
			for(int j = 0; j < (e - b); j++){
				int bf = a[b + j];
				a[b + j] = a[t + j];
				a[t + j] = bf;
			}
		}
		for(int i = 0; i < n; i++){
			System.out.print(a[i]);
			if(i != n - 1) System.out.print(" ");
		}
		System.out.print("\n");
	}
}

