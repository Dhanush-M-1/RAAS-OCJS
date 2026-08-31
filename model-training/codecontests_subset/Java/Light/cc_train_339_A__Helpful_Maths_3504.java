import java.util.*;

public class HelpfulMaths {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int a=0, b=0, c=0;

		for (int i=0; i<str.length(); i+=2) {
			if(str.charAt(i) == '1') 
				a++;
			else if(str.charAt(i) == '2')
				b++;
			else
				c++;
		}
		String s = "";
		for(; a!=0; a--)
			s+="1+";
		for(; b!=0; b--)
			s+="2+";
		for(; c!=0; c--)
			s+="3+";

		System.out.println(s.substring(0,s.length()-1));
	}
}