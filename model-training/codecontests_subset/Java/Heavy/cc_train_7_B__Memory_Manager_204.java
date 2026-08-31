import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class B {

	public static void main(String[] args) {
		new B().run();
	}
	
	class Block implements Comparable<Block> {
		int begin, length, index;
		boolean erased;
		@Override
		public int compareTo(Block o) {
			return begin - o.begin;
		}
	}
	
	int index;
	int n;
	boolean[] free;
	ArrayList<Block> blocks;

	private void run() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		n = sc.nextInt();
		free = new boolean[n];
		Arrays.fill(free, true);
		index = 1;
		blocks = new ArrayList<Block>();
		for (int i = 0; i < t; i++) {
			String cmd = sc.next();
			if (cmd.equals("alloc")) {
				Block b = alloc(sc.nextInt());
				if (b == null) {
					System.out.println("NULL");
				} else {
					System.out.println(index - 1);
				}
				continue;
			}
			if (cmd.equals("erase")) {
				erase(sc.nextInt());
				continue;
			}
			if (cmd.equals("defragment")) {
				defragment();
			}
		}
		sc.close();
	}

	private void defragment() {
		Collections.sort(blocks);
		int last = 0;
		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			b.begin = last;
			last += b.length;
		}
		Arrays.fill(free, true);
		for (int i = 0; i < last; i++) {
			free[i] = false;
		}
	}

	private void erase(int block) {
		Block erase = null;
		int toDel = -1;
		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			if (b.index == block) {
				erase = b;
				toDel = i;
			}						
		}
		if (erase == null) {
			System.out.println("ILLEGAL_ERASE_ARGUMENT");
		} else {
			for (int i = 0; i < erase.length; i++) {
				free[erase.begin + i] = true;
			}
			blocks.remove(toDel);
		}
	}

	private Block alloc(int length) {
		for (int i = 0; i < n; i++) {
			boolean ok = true;
			for (int j = 0; j < length; j++) {
				if (i + j >= n || free[i + j] == false) {
					ok = false;
				}
			}
			if (ok) {
				for (int j = 0; j < length; j++) {
					free[i + j] = false;
				}
				Block b = new Block();
				b.begin = i;
				b.length = length;
				b.index = index++;
				blocks.add(b);
				return b;
			}
		}
		return null;
	}

}
