import java.util.HashSet;
import java.util.Scanner;

public class TaskA {
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		HashSet<String> set = new HashSet<String>();
		set.add(in.next());
		set.add(in.next());
		
		for(String s : set){
			System.out.print(s + " ");
		}
		System.out.println();
		int n = in.nextInt();
		for(int i = 0; i < n ; i++){
			set.remove(in.next());
			set.add(in.next());
			for(String s : set){
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
