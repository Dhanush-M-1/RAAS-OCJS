import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;

public class Main {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test ++) {
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			List<Integer> arr = new ArrayList<>();
			for (int i = 0; i < n; i ++)
			    arr.add(Integer.parseInt(s[i]));
			/* 	ai + aj <= ak (dhundhna hain)
			*/
			// fix ak from back
			boolean flag = arr.get(0) + arr.get(1) <= arr.get(n-1);
			if (flag)System.out.println("1 2 "+n);
			else System.out.println("-1");
		}
	}
}
