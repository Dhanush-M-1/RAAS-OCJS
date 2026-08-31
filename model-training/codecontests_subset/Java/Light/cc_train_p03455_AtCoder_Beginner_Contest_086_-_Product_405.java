import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args){
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = a * b;
		if(c % 2 == 0)
			System.out.println("Even");
		else
			System.out.println("Odd");
	}
}