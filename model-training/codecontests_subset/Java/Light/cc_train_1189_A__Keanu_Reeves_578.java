import java.util.*;
import java.io.*;

public class Keanu_Reeves {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		char [] arr =br.readLine().toCharArray();
		int ones=0 ,zeros=0;
		for (int i=0;i<n;i++) {
			if (arr[i]=='1')
				ones++;
			else {
				zeros++;
			}
		}
		if (zeros==ones) {
			System.out.println(2);
			for (int i=0;i<n-1;i++) {
				System.out.print(arr[i]);
			}
			System.out.print(" ");
			System.out.println(arr[n-1]);
		}else {
			System.out.println(1);
			for (int i=0;i<n;i++) {
				System.out.print(arr[i]);
			}
		}
	}
}
