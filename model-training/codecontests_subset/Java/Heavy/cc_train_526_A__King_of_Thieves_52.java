import java.io.*;
import java.util.*;
import java.math.*;

public class ZeptoLabs_A {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		int n = Integer.parseInt(br.readLine().trim());
		char [] dungeon = br.readLine().toCharArray();
		System.out.println(getAns(dungeon));
	}
	public static String getAns(char [] d) {
		int n = d.length;
		for(int i = 1;i <= n-1;i++) {
			for(int start = 0;start < n-i;start++) {
				boolean ans = true;
				for(int j = 0;j < 5 && ans;j++) {
					if(start+i*j < n && d[start+i*j] != '*')
						ans = false;
					if(start+i*j >= n)
						ans = false;
				}
				if(ans)
					return "yes";
			}
		}
		return "no";
	}
}