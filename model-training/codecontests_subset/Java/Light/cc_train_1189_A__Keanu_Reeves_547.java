import java.util.*;
import java.io.*;

public class Keanu{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String s = sc.next();

		int z = 0,o = 0;
		for(int i=0;i<s.length();i++){

			if(s.charAt(i) == '0')
				z++;
			else
				o++;

		}

		if(z != o){
			System.out.println("1");
			System.out.println(s);
		}
		else{
			System.out.println("2");
			System.out.print(s.charAt(0) + " ");
			for(int i=1;i<s.length();i++)
				System.out.print(s.charAt(i));
		}

	}
}