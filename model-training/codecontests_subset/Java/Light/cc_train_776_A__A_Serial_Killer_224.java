import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] names = scan.nextLine().split(" "); 
		Set<String> abc = new HashSet<>();
		abc.add(names[0]);
		abc.add(names[1]);
		int n = scan.nextInt();
		scan.nextLine();
		StringBuilder result = new StringBuilder(names[0] + " " + names[1] + "\n");
		for(int i = 0; i < n; i++) {
			String[] names_i = scan.nextLine().split(" ");
			abc.remove(names_i[0]);
			abc.add(names_i[1]);
			for(String name : abc) {
				result.append(name + " ");
			}
			result.append("\n");
		}
		System.out.println(result);
	}
}
