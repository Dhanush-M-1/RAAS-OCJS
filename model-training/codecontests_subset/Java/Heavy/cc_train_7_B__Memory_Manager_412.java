import java.util.Arrays;
import java.util.Scanner;

public class MemoryManager {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		Memory mem = new Memory(m);
		for (; t > 0; t--) {
			String line = scan.nextLine();
			if (line.startsWith("alloc")) {
				int n = Integer.parseInt(line.split(" ")[1]);
				int num = mem.alloc(n);
				if (num < 0) {
					System.out.println("NULL");
				} else {
					System.out.println(num);
				}
			} else if (line.startsWith("erase")) {
				int n = Integer.parseInt(line.split(" ")[1]);
				if (mem.erase(n)) {
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
				}
			} else if (line.startsWith("defragment")) {
				mem.defrag();
			}
		}
	}

	private static class Memory {
		int[] mem;
		int num = 0;

		public Memory(int size) {
			mem = new int[size];
			Arrays.fill(mem, -1);
		}

		void defrag() {
			int index = 0;
			for (int i = 0; i < mem.length; i++) {
				if (mem[i] > -1) {
					mem[index] = mem[i];
					if (index != i) {
						mem[i] = -1;
					}
					index++;
				}
			}
		}

		boolean erase(int num) {
			if (num < 0) {
				return true;
			}
			boolean flag = true;
			for (int i = 0; i < mem.length; i++) {
				if (mem[i] == num) {
					mem[i] = -1;
					flag = false;
				}
			}
			return flag;
		}

		int alloc(int size) {
			int index = freeIndex(size);
			if (index < 0) {
				return -1;
			}
			num++;
			Arrays.fill(mem, index, index + size, num);
			return num;
		}

		int freeIndex(int size) {
			int max = 0;
			int count = 0;
			int index = -1;
			for (int i = 0; i < mem.length; i++) {
				int m = mem[i];
				if (m < 0) {
					count++;
				} else {
					if (max < count) {
						max = count;
						index = i - max;
					}
					count = 0;
				}
			}
			if (max < count) {
				max = count;
				index = mem.length - max;
			}
			return max >= size ? index : -1;
		}

		@Override
		public String toString() {
			return Arrays.toString(mem);
		}
	}
}
