import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.execute();
	}

	private void execute() {
		Scanner s = new Scanner(System.in);

		// ArrayList<String> list = new ArrayList<String>();
		// int maxSize = 0;
		// while (s.hasNextLine()) {
		// String next = s.nextLine();
		// if(next.length() > maxSize)
		// maxSize = next.length();
		// list.add(next);
		// }

		int num = Integer.valueOf(s.next());
		MAX_MEM = Integer.valueOf(s.next());

		for (int i = 0; i < num; i++) {
			String str = s.next();
			if (str.charAt(0) == 'a') {
				int ret = p7bAlloc(Integer.valueOf(s.next()));
				if (ret == -1) {
					System.out.println("NULL");
				} else {
					System.out.println(ret);
				}
			} else if (str.charAt(0) == 'e') {
				p7bErase(Integer.valueOf(s.next()));
			} else {
				p7bDefrag();
			}
		}
	}

	private class Mem implements Comparable {
		int id;
		int start;
		int size;

		@Override
		public int compareTo(Object arg0) {
			return this.start - ((Mem) arg0).start;
		}
	}

	private int MAX_MEM;
	List<Mem> blocks = new ArrayList<Mem>();
	int currId = 0;

	private int p7bAlloc(int n) {
		Collections.sort(blocks);
		if (blocks.size() != 0) {

			if(blocks.get(0).start > n)
			{
				Mem mem = new Mem();
				mem.id = ++currId;
				mem.start = 0;
				mem.size = n;
				
				blocks.add(mem);
				return currId;
			}
			
			for (int i = 0; i < blocks.size(); i++) {
				
				int nextPtr = 0;
				if (i == blocks.size() - 1) {
					nextPtr = MAX_MEM;
				} else {
					nextPtr = blocks.get(i + 1).start;
				}
				int relativeBlockSize = blocks.get(i).start
						+ blocks.get(i).size;
				int available = nextPtr - relativeBlockSize;
				if (n <= available) {
					Mem mem = new Mem();
					mem.id = ++currId;
					mem.start = relativeBlockSize;
					mem.size = n;
					
					blocks.add(mem);
					return currId;
				}
			}
		} else {
			if (n <= MAX_MEM) {
				Mem mem = new Mem();
				mem.id = ++currId;
				mem.start = 0;
				mem.size = n;

				blocks.add(mem);
				return currId;
			} else {
				return -1;
			}
		}

		return -1;
	}

	private void p7bErase(int n) {
		int toDelete = -1;
		for(int i = 0; i < blocks.size(); i++)
		{
			if(blocks.get(i).id == n)
			{
				toDelete = i;
			}
		}

		if(toDelete == -1)
		{
			System.out.println("ILLEGAL_ERASE_ARGUMENT");
		}
		else
		{
			blocks.remove(toDelete);
		}
	}

	private void p7bDefrag() {
		Collections.sort(blocks);
		int currPtr = 0;

		for(int i = 0; i < blocks.size(); i++)
		{
			Mem mem = blocks.get(i);
			mem.start = currPtr;
			currPtr += blocks.get(i).size;
		}
	}

}