import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodeForce {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		List<String> store = new ArrayList<String>();
		String input = scanner.nextLine();
		StringBuffer buffer = new StringBuffer();
		if(input.length()>1) {
			store.addAll(Arrays.asList(input.split("\\D")));
			Collections.sort(store);
			store.forEach(a -> buffer.append(a + "+"));
			buffer.replace(buffer.length()-1, buffer.length(), "");
			System.out.println(buffer);
		}else {
			System.out.println(input);
		}
		
	}

}