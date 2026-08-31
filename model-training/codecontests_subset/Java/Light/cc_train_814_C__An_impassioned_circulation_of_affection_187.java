import java.io.*;
import java.util.*;

public class garland {
	 
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] word = in.next().toCharArray();
		int q = in.nextInt();
		int[] nums = new int[q];
		char[] letter = new char[q];
		for (int i = 0; i < q; i++) {
			nums[i] = in.nextInt();
			letter[i] = in.next().charAt(0);
		}
		int[][] vals = new int[n+1][26];
 
		for (int j = 0; j < 26; j++) {
			for (int i = 1; i <= n; i++) {
				int ans = 0;
				int r = 0;
				int allow = i;
				for (int l = 0; l < n; l++) {
 
					while (r < n && (allow > 0 || word[r] == j+'a')) {
						if (word[r] != j + 'a') {
							allow--;
 
						}
						r++;
					}
					
					ans = Math.max(ans, r - l);
					
					if(word[l] != j + 'a')
					{
						allow++;
					}
				}
				
				vals[i][j] = ans;
			}
		}
		for(int i = 0; i < q; i++)
		{
			System.out.println(vals[nums[i]][letter[i]-'a']);
		}
	}
	
}
