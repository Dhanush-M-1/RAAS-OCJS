import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Chat {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		int count = 0;
		// String s= "David";
		// System.out.println(s.substring(1, s.length()));

		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (s.charAt(0) == '+')
				list.add(s.substring(1, s.length()));
			else if (s.charAt(0) == '-')
				list.remove(list.indexOf(s.substring(1, s.length())));
			else {
			
				String temp[] = s.split(":");
				if(temp.length>1){
				int length = temp[1].length();
				count += (length * list.size());
			}
			}
		}
		sc.close();
		System.out.println(count);
	}
}
