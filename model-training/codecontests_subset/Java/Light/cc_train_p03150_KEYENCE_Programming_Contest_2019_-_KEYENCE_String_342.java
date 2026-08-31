import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		boolean ans = false;
		
		if(input.contains("keyence")) {
			if(input.indexOf("keyence") == 0 || input.lastIndexOf("keyence") == input.length()-1) {
				ans = true;
			}
		}
		
		if(input.contains("k") && input.indexOf("k") == 0 && input.contains("eyence") && input.lastIndexOf("eyence") == input.length()-6) {
			ans = true;
		}
				
		if(input.contains("ke") && input.indexOf("ke") == 0 && input.contains("yence") && input.lastIndexOf("yence") == input.length()-5) {
			ans = true;
		}
		
		if(input.contains("key") && input.indexOf("key") == 0 && input.contains("ence") && input.lastIndexOf("ence") == input.length()-4) {

			ans = true;
		}
		
		if(input.contains("keye") && input.indexOf("keye") == 0 && input.contains("nce") && input.lastIndexOf("nce") == input.length()-3) {
			ans = true;
		}
		
		if(input.contains("keyen") && input.indexOf("keyen") == 0 && input.contains("ce") && input.lastIndexOf("ce") == input.length()-2) {
			ans = true;
		}
		
		if(input.contains("keyenc") && input.indexOf("keyenc") == 0 && input.contains("e") && input.lastIndexOf("e") == input.length()-1) {
			ans = true;
		}
		
		if(ans) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
