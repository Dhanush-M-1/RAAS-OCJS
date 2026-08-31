import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String s = sc.readLine();
		int n = Integer.parseInt(sc.readLine());
		char[] arr = s.toCharArray();
		boolean fl = false, fr = false, sl = false, sr = false, ans = false;
		for (int i = 0; i < n; i++) {
			String a = sc.readLine();
			char[] e = a.toCharArray();
			if(e[0] == arr[0] && e[1] == arr[1]) {
				ans = true;
				break;
			}
			if(e[1] == arr[0]) {
				fr = true;
			}
			if(e[0] == arr[1]) {
				sl = true;
			}
		}
		if(ans || (fr && sl)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}