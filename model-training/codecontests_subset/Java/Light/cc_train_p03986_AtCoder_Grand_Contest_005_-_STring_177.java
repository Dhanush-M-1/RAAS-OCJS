
import java.util.Scanner;

public class Main {

	static Scanner scanner;
	public static void main(String[] args) {
	    scanner = new Scanner(System.in);

	    String S=gs();
	    
	    int s=0;
	    int st=0;
        for(int i=0; i<S.length();i++) {
        	char c=S.charAt(i);
        	if(c=='T'&&s>0) {
        		st++;
        		s--;
        	} else if(c=='S') {
        		s++;
        	}
        }


        System.out.println(S.length() - 2*st);

		//System.out.println();
	}

	// 文字列として入力を取得
	public static String gs() {
		return scanner.next();
	}

	// intとして入力を取得
	public static int gi() {
		return Integer.parseInt(scanner.next());
	}

	// longとして入力を取得
	public static long gl() {
		return Long.parseLong(scanner.next());
	}

	// doubleとして入力を取得
	public static double gd() {
		return Double.parseDouble(scanner.next());
	}
}