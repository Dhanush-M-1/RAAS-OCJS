//package olymp2;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		in.nextLine();
		String num = in.nextLine();
		int counter = 0;
		
		
		
		for(int i = n-x; i<n;i++)
			if(i==n-y-1) {
				if(num.charAt(i)!='1')
					counter++;
			}
			else if(num.charAt(i)!='0')
					counter++;


		out.print(counter);
		

		
	
		
		in.close();
		out.close();
		out.flush();
	}

}
