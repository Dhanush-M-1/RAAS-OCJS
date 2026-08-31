import java.util.Arrays;
import java.util.Scanner;
  
public class force {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = new String();
		String newString = "";
		
		do {
			str = s.nextLine();
	    }while((str.length() < 1) || (str.length() > 100));
		char[] array = new char[0];
		str = str.replaceAll("[+]", "");
		array = str.toCharArray();
		Arrays.sort(array);
		
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) {
				newString += array[i];
				break;
			}
			newString += array[i] + "+";
		}
		System.out.println(newString);
    }
}
