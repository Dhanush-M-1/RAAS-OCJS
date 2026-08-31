import java.util.*;
import java.io.*;

public class a {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++)
				System.out.print(Integer.toString(i*j,n)+ " ");
			System.out.println();
		}
	}
}
