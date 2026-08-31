import java.lang.*;
import java.util.*;
import java.io.*;

public class _temp2 {
	public static void main(String[] args)  throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int c = Integer.parseInt(st[1]);
		st = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st[i]);
		}
		int count = 0;
		for(int i=0;i<n-1;i++){
			count = Math.max(count,arr[i]-arr[i+1]);
		}
		System.out.println(count-c<0?0:count-c);
	}
}