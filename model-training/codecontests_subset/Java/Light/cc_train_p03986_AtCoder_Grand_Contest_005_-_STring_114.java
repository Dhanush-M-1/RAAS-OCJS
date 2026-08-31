import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Deque<Character> a = new LinkedList<Character>();

		for (int i = 0; i < s.length(); i++) {
			if (a.size() > 0 && a.peekLast() == 'S' && s.charAt(i) == 'T') {
				a.pollLast();
			} else {
				a.add(s.charAt(i));
			}
		}

		System.out.println(a.size());
	}
}
