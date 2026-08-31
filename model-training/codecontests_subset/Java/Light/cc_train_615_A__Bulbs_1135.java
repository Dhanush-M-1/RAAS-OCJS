import java.util.HashSet;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashSet<String> p = new HashSet<String>();
		int n = in.nextInt();
		int m = in.nextInt();
		String lol = in.nextLine();
		for (int i = 0; i<n; i++){
			int k = in.nextInt();
			for (int j = 0; j<k; j++){
				p.add(in.next());
			}
		}
		if (p.size()==m){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
