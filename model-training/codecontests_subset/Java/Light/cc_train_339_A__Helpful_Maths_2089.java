import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Scanner scan;

	public static void main(String[] args) {
	
		scan = new Scanner(System.in);
		
		String s= scan.next();
		String s2="";
		char []x =s.toCharArray();
		Arrays.sort(x);
		for (int i = 0; i < s.length(); i++) {
				if(x[i]!='+')
							{if(s.length()-i!=1)
							{
								s2+=x[i]+" ";
							}
							else{s2+=x[i];}
				}
		}
		s2=s2.replaceAll(" ","+");
			System.out.println(s2);

}
}


