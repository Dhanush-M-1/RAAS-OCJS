import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner read = new Scanner(System.in);

		String[] cad = read.nextLine().split("\\+");
		
		ArrayList numbers = new ArrayList<Integer>();
		for (int i = 0; i < cad.length; i++) numbers.add(Integer.parseInt(cad[i]));
		
		Collections.sort(numbers);

		for (int i = 0; i < numbers.size()-1; i++) System.out.print(""+numbers.get(i)+(char)43);
		System.out.print(numbers.get(numbers.size()-1));
	}
		
}