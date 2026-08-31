import java.io.PrintWriter;
import java.util.Scanner;

public class MultTable {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		for(int i = 1; i < k; i++)
			for(int j = 1; j < k; j++) {
				out.print(Integer.toString(i * j, k));
				if(j == k - 1)
					out.println();
				else
					out.print(" ");
			}
		
		out.flush();
		out.close();
	}
}
