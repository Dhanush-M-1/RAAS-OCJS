import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		int value = 0;
		for (char c : arr) {
		    if (c == 'S') {
		        value++;
		    } else {
		        value = Math.max(0, value - 1);
		    }
		}
		System.out.println(value * 2);
	}

}
