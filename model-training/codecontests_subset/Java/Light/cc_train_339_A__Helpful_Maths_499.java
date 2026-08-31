import java.util.Scanner;
import java.util.Arrays;

public class HelpMaths {
	public static void main (String[] args) {
		Scanner in = new Scanner (System.in);
		String s = in.nextLine();
		int x = 0;
		char[] toSort = new char[s.length()/2+1];
		
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i)!='+') {
				toSort[x] = s.charAt(i);
				x++;
			}
		}
		
		Arrays.sort(toSort);
		System.out.print(toSort[0]);	
		
		for (int i=1; i<x; i++) {
			System.out.print('+');
			System.out.print(toSort[i]);
		}
		
	}
}