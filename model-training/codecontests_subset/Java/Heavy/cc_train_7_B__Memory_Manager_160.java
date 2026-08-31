import java.util.ArrayList;
import java.util.Scanner;

public class B {
	
	static int num = 0;
	static int M;
	
	static class memory {
		int x;
		int loc;
		int bytes;
		
		public memory(int loc, int bytes) {
			x = ++num;
			this.bytes = bytes;
			this.loc = loc;
		}
		
		@Override
		public String toString() {
			
			return loc + " " + bytes;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<memory> list = new ArrayList<memory>();
		
		int N = input.nextInt();
		M = input.nextInt();
		
		for (int i = 0; i < N; i++) {
			String command = input.next();
			if (command.equals("alloc")) {
				int result = add(list, input.nextInt());
				if (result == -1)
					System.out.println("NULL");
				else
					System.out.println(result);
			} else if (command.equals("defragment")) defrangement(list);
			else {
				int result = erase(list, input.nextInt());
				if (result == -1)
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
		}
	}
	
	static int erase(ArrayList<memory> list, int num) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).x == num) {
				list.remove(i);
				return 1;
			}
		}
		return -1;
	}
	
	static int add(ArrayList<memory> list, int bytes) {
		if (list.isEmpty()) {
			if (bytes <= M) {
				list.add(new memory(0, bytes));
				return num;
			}
			return -1;
		} else {
			int end = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).loc - end >= bytes) {
					list.add(i, new memory(end, bytes));
					return num;
				}
				end = list.get(i).loc + list.get(i).bytes;
			}
		
			
			memory mem = list.get(list.size() - 1);

			if (mem.loc + mem.bytes + bytes <= M) {
				list.add(new memory(mem.loc + mem.bytes, bytes));
				return num;
			}
			return -1;
		}
	}
	
	static void defrangement(ArrayList<memory> list) {
		int loc = 0;
		for (memory memory : list) {
			memory.loc = loc;
			loc += memory.bytes;
		}
	}
}
