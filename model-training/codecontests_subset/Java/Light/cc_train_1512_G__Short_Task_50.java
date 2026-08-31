import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Practice {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());int[] arr = new int[10000009];long[] arr2 = new long[10000009];arr[1] = 1;
		for (int i = 2; i < 10000002; i++) {
			for (int j = (i); j < 10000002; j = j + i) arr2[j] += i;
			if (arr2[i] <= 10000000 && arr[(int) arr2[i] + 1] == 0) arr[(int) arr2[i] + 1] = i;}
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((arr[n] == 0)?-1:arr[n]);
		}}}
