import java.util.*;
public class D {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.next();
		int n=in.nextInt();
		s=s.toLowerCase();
		String ans="";
		for(int i=0;i<s.length();i++){
			char x=s.charAt(i);
			if((int)x<n+97){ans+=(x+"").toUpperCase();}
			else{ans+=(x+"").toLowerCase();}
		}
		System.out.println(ans);
	}

}
