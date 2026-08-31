import java.util.*;

public class EKG {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		// my position is minus one because of 0 indexed array.
		int myNum = in.nextInt() - 1;
		int[] position = new int[size];
		int[] behind = new int[size];
		Arrays.fill(behind, -1);
		// reading in positions and keeping a reverse array of whose behind you signaled by if there is a -1 since -1 is the line leader
		for(int i = 0; i < position.length; i++) {
			position[i] = in.nextInt() - 1;
			if(position[i] != -1) {
				behind[position[i]] = i;
			}
		}
		// follow bread crumbs back to source and keep track of the lengths of the line.
		// later on use dp to figure out where your placement can be in the line.
		ArrayList<Integer> cycles = new ArrayList<Integer>();
		int ourPos = 1;
		// each -1 marks the start of a new cycle.
	TO:for(int i = 0; i < size; i++) {
			if(position[i] == -1) {
				int length = 0;
				for(int c = i; c != -1; c = behind[c]) {
					if(c == myNum) {
						ourPos = length;
						continue TO;
					}
					length++;
				}
				cycles.add(length);
			}
		}
		boolean[] possible = new boolean[size];
		possible[0] = true;
		
		for(int len: cycles) {
			for(int k = possible.length - len - 1; k >= 0; k--) {
				if(possible[k]) {
					possible[k + len] = true;
				}
			}
		}
		for(int p = 0; p < possible.length; p++) {
			if(possible[p]) 
				System.out.println(p + ourPos + 1);
		}
	}
}

















