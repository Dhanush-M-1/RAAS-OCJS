import java.util.Scanner;

public class R313Div2D {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String a=in.next();
		String b=in.next();
		in.close();
		System.out.println(sort(a).equals(sort(b))?"YES":"NO");
	}
	static String sort(String s){
		if(s.length()%2==1)
			return s;
		String a=sort(s.substring(0,s.length()/2));
		String b=sort(s.substring(s.length()/2));
		return a.compareTo(b)<=0?a+b:b+a;
	}
}
