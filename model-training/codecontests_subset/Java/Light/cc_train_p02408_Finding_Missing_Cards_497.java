import java.util.*;

public class Main {
	public static void main(String args[]) {
		char design[] = {'S', 'H', 'C', 'D'};
		HashMap<Character, boolean[]> trump = new HashMap<Character, boolean[]>();

		for (char d : design)
			trump.put(d, new boolean[13]);

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 0; i < n; i++){
			char d = scan.next().charAt(0);
			int r = scan.nextInt();

			trump.get(d)[r-1] = true;
		}

		for (char d : design){
			boolean t[] = trump.get(d);
			for (int i = 0; i < t.length; i++)
				if(!t[i])
					System.out.println(String.format("%c %d", d, i+1));
		}
	}
}

