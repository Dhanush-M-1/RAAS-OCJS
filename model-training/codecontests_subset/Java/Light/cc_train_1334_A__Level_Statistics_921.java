import java.util.*;
import java.io.*;
 
public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		boolean bad = false;
		for(int i = 0; i < t; i++){
			bad = false;
			int n = sc.nextInt();
 
			int lp = 0;
			int lc = 0;
 
			for(int j = 0; j < n; j++){
				int p = sc.nextInt();
				int c = sc.nextInt();
				if((p - lp < 0 || c - lc < 0 || p - lp < c - lc) && !bad){
					bad = true;
				}
 
				lp = p;
				lc = c;
			}
 
			if(bad){
				System.out.println("NO");
			} else{
				System.out.println("YES");
			}
		}
	}
}