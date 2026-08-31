import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Orange {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toLowerCase();
		String res = "";
		int a = Integer.parseInt(br.readLine());
		for (int i=0;i<s.length();i++){
			if ((int)s.charAt(i)<a+97)
				res+=(s.charAt(i)+"").toUpperCase();
			else res+=(s.charAt(i)+"").toLowerCase();
		}
		System.out.println(res);
	}
	
}
