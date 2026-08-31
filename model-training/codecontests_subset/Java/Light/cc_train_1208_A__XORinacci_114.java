import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T  =  scanner.nextInt();
		for(int i =0;i<T;i++) {
			int a  =scanner.nextInt();
			int b = scanner.nextInt();
			int n = scanner.nextInt();
			int res =0;
			if (n%3 == 0) {
				System.out.println(a);
			}else if (n%3==1) {
				System.out.println(b);
			}else {
				System.out.println(a^b);
			}
		}
		scanner.close();
	}
}