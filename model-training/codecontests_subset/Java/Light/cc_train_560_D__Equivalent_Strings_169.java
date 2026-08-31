import java.util.HashMap;
import java.util.Scanner;


public class D {
	public static String smallest(String s){
		if(s.length()%2==1) return s;
		String substr1 = smallest(s.substring(0, s.length()/2));
		String substr2 = smallest(s.substring(s.length()/2, s.length()));
		
		if(substr1.compareTo(substr2)<0) return substr1 + substr2;
		else return substr2+substr1;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();
		
		String smalla = smallest(a);
		String smallb = smallest(b);
		if(smalla.equals(smallb)){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}

}
