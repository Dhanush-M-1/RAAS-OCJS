import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String[] names = in.nextLine().split(" ");
		int n = in.nextInt();
		in.nextLine();
		out.println(names[0] + ' ' + names[1]);
		for (int i = 0; i < n; i++) {
			String[] new_names = in.nextLine().split(" ");
			if (new_names[0].equals(names[0])) {
					names[0] = new_names[1];
			} else {
					names[1] = new_names[1];
			}
			out.println(names[0] + ' ' + names[1]);
		}
		out.close();
		in.close();
	}
	
}