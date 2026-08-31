import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class my_class {	
	public static void main(String[] args) {
		Scanner ololo = new Scanner(System.in);
		int n;
		char b;
		String str, str2 = "";
		str = ololo.nextLine();
		n = ololo.nextInt();
		str = str.toLowerCase();
		for(int i = 0; i < str.length(); i++){
			b = str.charAt(i);
			if(b < (n + 97)){
				b = Character.toUpperCase(b);
				str2 = str2 + b;
			}
			else{
				str2 += b;
			}
		}
		System.out.println(str2);
	}	
}
