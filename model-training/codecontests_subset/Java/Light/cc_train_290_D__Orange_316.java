import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		s = s.toLowerCase();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)-'a' < n){
				sb.append(Character.toUpperCase(s.charAt(i)));
			}else{
				sb.append(s.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
