


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> l = solve(n);
		for (String s : l) {
			System.out.println(s);
		}


	
	}
	
	
	static List<String> solve(int n) {
		if (n==1) {
			return  Arrays.asList("a");
		} else {
			List<String> tmp = solve(n-1);
			List<String> ans = new ArrayList<>();
			for (String s : tmp) {
				char c = 'a';
				for (int i=0;i<n-1;i++) {
					c = (char)Math.max(c, s.charAt(i));
				}
				
				for (char j='a'; j<=c+1;j++) {
					ans.add(s+String.valueOf(j));
				}
			}
			return ans;
		}
		
	}


}



