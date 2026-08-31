import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p915A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), k = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(scan.nextInt());
		}
		for (int i = 0; i < list.size(); i++) {
			if (k%list.get(i)!=0) {
				list.remove(i);
				i--;
			}
		}
		Collections.sort(list);
		System.out.println(k/list.get(list.size()-1));
	}

}
