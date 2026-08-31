import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] s = input.nextLine().split("\\+");
		Arrays.sort(s);
		
		/*
		for(int i = 0; i < s.length; i++) {
			for(int j = 0; j < s.length-i-1; j++) {
				if(Integer.parseInt(s[j]) > Integer.parseInt(s[j+1])) {
					String temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
		*/
		
		String newString = "";
		for(int i = 0; i < s.length; i++) {
			newString += s[i];
			if(i < s.length-1) {
				newString += "+";
			}
		}
		
		System.out.println(newString);
	}
}

