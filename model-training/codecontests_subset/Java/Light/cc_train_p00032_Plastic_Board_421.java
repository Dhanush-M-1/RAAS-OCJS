import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int hishi=0, tyou=0;
		while(cin.hasNext()){
			String str = cin.next();
			String[] s = str.split(",");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			if(a == b){
				hishi++;
			}
			if(a*a+b*b==c*c){
				tyou++;
			}
			
		}
		System.out.println(tyou);
		System.out.println(hishi);
	}

}