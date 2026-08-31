import java.util.ArrayList;
import java.util.Scanner;

public class B_MemoryManager 
{

	static int lastId = 0;
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int m = in.nextInt();
		
		Block b = new Block(-1, m, 0, "free");

		ArrayList<Block> blocks = new ArrayList<>();
		blocks.add(b);
		
		while(t > 0)
		{
			String command = in.next();
			if(command.equals("alloc"))
			{
				int size = in.nextInt();
				int id = allocate (blocks, size);
				if(id == -1)
					System.out.println("NULL");
				else
					System.out.println(lastId);
			}
			else if(command.equals("erase"))
			{
				int id = in.nextInt();
				if(id > 0)
				{
					int result = erase(blocks, id);
					if(result == -1)
						System.out.println("ILLEGAL_ERASE_ARGUMENT");
				}
				else
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
			else
			{
				defragment(blocks);
			}
			
			t--;
		}
	}
	
	private static void defragment(ArrayList<Block> blocks)
	{
		//System.out.println("before defragmentation");
		//System.out.println(blocks);
		ArrayList <Block> notFreeBlocks = new ArrayList<>();
		int freeBlocksSize = 0;
		int newStartingIndex = 0;
		for(int i = 0; i < blocks.size(); i++)
		{
			Block block = blocks.get(i);
			if(block.getState().equals("notFree"))
			{
				block.setStartingIndex(newStartingIndex);
				notFreeBlocks.add(block);
				newStartingIndex = newStartingIndex + block.getSize();
			}
			else
			{
				freeBlocksSize = freeBlocksSize + block.getSize();
			}
		}	
		
		blocks.clear();
		for(int i = 0; i < notFreeBlocks.size(); i++)
		{
			blocks.add(notFreeBlocks.get(i));
		}		
		if(freeBlocksSize > 0)
		{
			Block b = new Block(-1, freeBlocksSize, newStartingIndex, "free");
			blocks.add(b);
		}
		//System.out.println("after defragmentation");
		//System.out.println(blocks);
		
	}

	//returns 1 in case of successful erase or -1 in case of failed erase
	private static int erase(ArrayList<Block> blocks, int id)
	{
		//System.out.println("before erase");
		//System.out.println(blocks);
		for(int i = 0; i < blocks.size(); i++)
		{
			Block b = blocks.get(i);
			if(b.getIdentifier() == id)
			{
				b.setState("free");
				b.setIdentifier(-1);
				mergeFreeBlocks(i, blocks);	
				
				//System.out.println("after erase");
				//System.out.println(blocks);
				return 1;
			}
		}
		return -1;
	}

	private static void mergeFreeBlocks(int i, ArrayList<Block> blocks)
	{
		int size = blocks.size();
		Block b = blocks.get(i);
		boolean v1 = valid(i - 1, size);
		boolean v2 = valid(i + 1, size);
		if(v1 && v2) 
		{
			Block beforeB = blocks.get(i - 1);
			Block afterB = blocks.get((i + 1));
			if(beforeB.getState().equals("free") && afterB.getState().equals("free"))
			{
				int newSize = b.getSize() + beforeB.getSize() + afterB.getSize();
				beforeB.setSize(newSize);
				blocks.remove(b);
				blocks.remove(afterB);
				
			}
			else if(beforeB.getState().equals("notFree") && afterB.getState().equals("free"))
			{
				int newSize = b.getSize() + afterB.getSize();
				b.setSize(newSize);
				blocks.remove(afterB);
			}
			else if(beforeB.getState().equals("free") && afterB.getState().equals("notFree"))
			{
				int newSize = b.getSize() + beforeB.getSize();
				beforeB.setSize(newSize);
				blocks.remove(b);	
			}
		}
		else if(!v1 && v2)
		{
			Block afterB = blocks.get((i + 1));
			if(afterB.getState().equals("free"))
			{
				int newSize = b.getSize() + afterB.getSize();
				b.setSize(newSize);
				blocks.remove(afterB);
			}
		}
		else if(v1 && !v2)
		{
			Block beforeB = blocks.get(i - 1);
			if(beforeB.getState().equals("free"))
			{
				int newSize = b.getSize() + beforeB.getSize();
				beforeB.setSize(newSize);
				blocks.remove(b);						
			}
		}		
	}

	private static boolean valid(int i, int size) 
	{
		if(i >= 0 && i < size)
			return true;
		
		return false;
	}

	private static int allocate(ArrayList<Block> blocks, int size) 
	{
		//System.out.println("before allocation");
		//System.out.println(blocks);
		for(int i = 0; i < blocks.size(); i++)
		{
			Block b = blocks.get(i);
			if(b.getState().equals("free"))
			{ 
				if(b.getSize() == size)
				{
					lastId = lastId + 1;
					b.setIdentifier(lastId);
					b.setState("notFree");
					return lastId;
				}
				else if(b.getSize() > size)
				{
					//create a new free block
					int size2 = b.getSize() - size;
					int startingIndex2 = b.getStartingIndex() + size;
					Block b2 = new Block(-1, size2, startingIndex2, "free");
					blocks.add(b2);
					
					//adjust the free b block to be the new allocated block
					lastId = lastId + 1;
					b.setIdentifier(lastId);
					b.setState("notFree");
					b.setSize(size);
										
					//System.out.println("after allocation");
					//System.out.println(blocks);
					return lastId;
				}
			}
		}
		return -1;
	}

	
	 
	public static class Block
	{
		private int identifier;
		private int size;
		private int startingIndex;
		private String state;
		
		public Block(int identifier, int size, int startingIndex, String state) 
		{
			this.identifier = identifier;
			this.size = size;
			this.startingIndex = startingIndex;
			this.state = state;
		}	
		@Override
		public String toString() {
			return "Block [identifier=" + identifier + ", size=" + size + ", startingIndex=" + startingIndex + ", state="
					+ state + "]";
		}
		public int getIdentifier() {
			return identifier;
		}
		public void setIdentifier(int identifier) {
			this.identifier = identifier;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getStartingIndex() {
			return startingIndex;
		}
		public void setStartingIndex(int startingIndex) {
			this.startingIndex = startingIndex;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
	}
}