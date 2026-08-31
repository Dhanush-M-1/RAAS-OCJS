import java.util.*;
public class RoundN111 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = 0, ans=0;
		while(in.hasNextLine()){
			String n = in.nextLine();
			if(n.charAt(0)=='+')c++;
			else 
				if(n.charAt(0)=='-') c--;
			else{
				String[] s = n.split(":");
				if(s.length>=2)
					ans+=c*s[1].length();
			}

		}
		System.out.println(ans);
	}
}