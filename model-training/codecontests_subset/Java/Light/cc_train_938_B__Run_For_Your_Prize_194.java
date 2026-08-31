import java.util.*;
import java.io.*;

public class Solution{
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = Integer.MIN_VALUE;
		int l = 1;
		int r = 1000000;
		for(int i = 1 ; i <= n ; i++){
			int pos = sc.nextInt();
			int d = Math.min(pos - l,r - pos);
			ans = Math.max(d, ans);
		}
		
		System.out.println(ans);
	}
		
}