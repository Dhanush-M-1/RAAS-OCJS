import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.io.*;
import java.util.List;

public class Task0001 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> n = new ArrayList<Integer>();

		String s = in.nextLine();
		
		String g="";
		for (int i=0;i<s.length(); i++) {
			if(s.charAt(i)=='+'){
				n.add(Integer.parseInt(g));
				g="";
			}
			g+=s.charAt(i);
			
			
		}
		n.add(Integer.parseInt(g));
		Object[] o = n.toArray();
		Arrays.sort(o);
		for (int i = 0; i < o.length - 1; i++) {
			System.out.print(o[i]+ "+" );
		}
		System.out.print(o[o.length-1]);
	}
}