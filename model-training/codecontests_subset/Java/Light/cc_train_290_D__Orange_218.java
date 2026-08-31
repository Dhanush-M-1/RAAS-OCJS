import static java.lang.System.*;
import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc = new Scanner(in);
		
		char[] str = sc.next().toLowerCase().toCharArray();
		int num = sc.nextInt();
		
		for(char c: str) {
			if(c < 'a'+num) out.print(Character.toUpperCase(c));
			else out.print(c);
		}
		out.println();
	}

}
