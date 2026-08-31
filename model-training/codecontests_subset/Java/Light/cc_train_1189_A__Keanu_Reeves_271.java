import java.util.*;

public class c1 {
	public static void main(String args[]) {	 
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String s=in.next();
		int z=0,o=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0')z++;
			else o++;
		}
		if(z!=o) {
			System.out.println("1\n"+s);
		} else {
			System.out.println("2\n"+s.charAt(0)+" "+s.substring(1,s.length()));
		}
	}
}
