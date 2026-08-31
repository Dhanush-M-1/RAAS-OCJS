import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MemoryManager {
	
	static LinkedList<Block> memory;
	
	static int alloc(int size) {
		
		for (int i = 0; i < memory.size(); i++) {
			
			Block block = memory.get(i);
			
			if (block.id == 0 && block.size >= size) {
				
				block.size -= size;
				
				Block newBlock = new Block(size);
				memory.add(i, newBlock);
				return newBlock.id;
			}
		}
		return 0;
	}
	
	static boolean erase(int id) {
		
		for (int i = 0; i < memory.size(); i++) {
			
			Block block = memory.get(i);
			
			if (id > 0 && block.id == id) {
				block.id = 0;
				merge(i);
				return true;
			}
		}
		return false;
	}
	
	static void defrag() {
		
		int free = 0;
		for (int i = 0; i < memory.size(); i++) {
			
			Block block = memory.get(i);
			
			if (block.id == 0) {
				free += block.size;
				memory.remove(block);
				i--;
			}
		}
		
		memory.addLast(new Block(0, free));
	}
	
	static boolean merge(int i) {
		
		boolean merged = false;
		Block block = memory.get(i);
		
		if (i + 1 < memory.size()) {
			Block nextBlock = memory.get(i + 1);
			
			if (block.id == 0 && nextBlock.id == 0) {
				block.size += nextBlock.size;
				memory.remove(i + 1);
				merged = true;
			}
		}
		
		if (i - 1 >= 0) {
			Block prevBlock = memory.get(i - 1);
			
			if (block.id == 0 && prevBlock.id == 0) {
				block.size += prevBlock.size;
				memory.remove(i - 1);
				merged = true;
			}
		}
		return merged;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		
		ArrayList<String> commands = new ArrayList<String>(m);
		memory = new LinkedList<Block>();
		memory.add(new Block(0, m));
		
		for (int i = 0; i < t; i++)	commands.add(in.nextLine());
		in.close();
		
		for (int i = 0; i < t; i++) {
			
			if (commands.get(i).startsWith("alloc")) {
				
				int id = alloc(Integer.parseInt(commands.get(i).split(" ")[1]));
				
				if (id > 0) System.out.println(id);
				else System.out.println("NULL");
			}
			else if (commands.get(i).startsWith("erase")) {
				boolean s = erase(Integer.parseInt(commands.get(i).split(" ")[1]));
				
				if (!s) System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
			else {
				defrag();
			}
		}
	}

}

class Block {
	
	int id;
	int size;
	
	static int i = 0;
	
	int getId() {
		return ++i;
	}
	
	public Block(int size) {
		super();
		this.id = getId();
		this.size = size;
	}
	
	public Block(int id, int size) {
		super();
		this.id = id;
		this.size = size;
	}
}