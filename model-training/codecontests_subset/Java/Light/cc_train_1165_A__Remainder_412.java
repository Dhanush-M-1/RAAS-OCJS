import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Remainder {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		
		String s = in.readLine();
		
		String ss[] = s.split("\\s+");
		
		int n = Integer.parseInt(ss[0]);
		int x = Integer.parseInt(ss[1]);
		int y = Integer.parseInt(ss[2]);
		
		String str = in.readLine();
		
		str = str.substring(n-x);
		
//		System.out.println(str);
		
		StringBuffer sb = new StringBuffer();
		sb.append("1");
		for(int i = 0 ; i < y ; i++) {
			sb.append("0");
		}
		sb.reverse();
		while(sb.length()<str.length()) {
			sb.append("0");
		}
		sb.reverse();
		
		int ans = 0;
		s = sb.toString();
		for(int i = 0 ;i < str.length() ; i++) {
			if(s.charAt(i)!= str.charAt(i)) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
