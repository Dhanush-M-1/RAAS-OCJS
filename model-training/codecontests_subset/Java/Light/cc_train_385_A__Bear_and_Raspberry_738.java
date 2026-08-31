import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int c = Integer.parseInt(s[1]);
		int max = 0;
		s= br.readLine().split(" ");
		for(int i = 0 ; i < n-1 ; i++){
			int tmp1 = Integer.parseInt(s[i]);
			int tmp2 = Integer.parseInt(s[i+1]);
			if(max < (tmp1 - tmp2 - c))
				max = tmp1 - tmp2 - c;
		}
		System.out.println(max);
	}
}