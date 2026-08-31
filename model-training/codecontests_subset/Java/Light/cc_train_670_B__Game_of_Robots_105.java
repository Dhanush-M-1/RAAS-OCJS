import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class tmp {
	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int i = 0;
		while (k > ++i)
			k -= i;
		k--;
		for (i = 0; i < n; i++)
			if (i == k)
				System.out.println(sc.nextInt());
			else
				sc.nextInt();
	}
}