import java.util.*;
public class CF219A_KString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		String s = in.next();
		int n = s.length();
		int[] f = new int[26];
		for(int i = 0; i < n; i ++)
			f[s.charAt(i) - 'a']++;
		boolean pos = true;
		for(int i = 0; i < 26; i++){
			if(f[i] % k != 0)
				pos = false;
		}
		if(!pos){
			System.out.println(-1);
			return;
		}
		String unit = "";
		for(int i = 0; i < 26; i ++){
			f[i]/= k;
			for(int j = 0; j < f[i]; j ++)
				unit+=(char)(i+'a');
		}
		for(int i = 0; i < k; i ++)
			System.out.print(unit);	
	}
}