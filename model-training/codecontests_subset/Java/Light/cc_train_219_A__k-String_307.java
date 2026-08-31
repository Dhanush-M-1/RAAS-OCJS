import java.util.*;
import java.io.*;
public class kString {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		String word = br.readLine();
		char[] w = word.toCharArray();
		Arrays.sort(w);
		int cnt = 0;
		char cur = w[0];
		String aux = "";
		String ans = "";
		boolean flag = true;
		for (int i = 0; i < w.length; i++) {
			if(w[i] == cur) cnt++;
			else {
				if(cnt % k != 0) {
					flag = false;
					break;
				}
				for (int j = 0; j < cnt/k; j++) aux += cur + "";
				cur = w[i];
				cnt = 1;
			}
		}
		if(cnt % k != 0) flag = false;
		for (int j = 0; j < cnt/k; j++) aux += cur + "";
		if(flag) {
			for (int i = 0; i < k; i++) ans += aux;
			System.out.println(ans);
		}
		else System.out.println("-1");
	}
}
