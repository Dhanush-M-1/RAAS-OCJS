import java.util.*;
import java.io.*;
import java.lang.*;

public class programA {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		String string = br.readLine();
		int count = 0;
		for(int i = string.length()-1;i>=0;i--) {
			if(string.length() - 1 - i  == y) {
				if(string.charAt(i) == '0') count++;
			}
			else if(string.length() - 1 - i < x) {
				if(string.charAt(i) == '1') count++;
			}
		}
		System.out.print(count);
	}

}