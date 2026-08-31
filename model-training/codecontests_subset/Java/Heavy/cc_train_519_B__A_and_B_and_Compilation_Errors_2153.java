import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompilationErrors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		scan.nextLine();
		int acum1 = 0;
		int acum2 = 0;
		int acum3 = 0;
		
		String[] a = scan.nextLine().split(" ");
		String[] b = scan.nextLine().split(" ");
		String[] c = scan.nextLine().split(" ");
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (String q: a) {
			A.add(Integer.parseInt(q));
		}
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (String q: b) {
			B.add(Integer.parseInt(q));
		}
		ArrayList<Integer> C = new ArrayList<Integer>();
		for (String q: c) {
			C.add(Integer.parseInt(q));
		}
		
		for (int q: A) {
			acum1 += q;
		}
		
		for (int q: B) {
			acum2 += q;
		}
		
		for (int q: C) {
			acum3 += q;
		}
		
		System.out.println(Math.abs(acum1-acum2));
		System.out.println(Math.abs(acum2-acum3));
		scan.close();	
	}
	
}