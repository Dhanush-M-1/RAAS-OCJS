import java.io.*;
import java.lang.reflect.*;

public class Problem
{
	private class MemoryManager
	{
		private byte[] mMemory;
		private int mMaxSize = 0;
		private byte mBlocksCnt = 0;

		public MemoryManager(int maxSize)
		{
			mMaxSize = maxSize;
			mMemory = new byte[maxSize];
			for (int i = 0; i < maxSize; i++)
			{
				mMemory[i] = 0;
			}
		}
		private int findFreeBlockIndex(int newSize)
		{
			int nullCellsCnt = 0;
			if (newSize == 1 && mMaxSize == 1)
				if (mMemory[0] == 0)
					return 0;
			for (int i = 0; i < mMaxSize; i++)
			{
				if (mMemory[i] == 0)
				{
					nullCellsCnt++;
					if (nullCellsCnt == newSize)
					{
						return i+1 - newSize;
					}
				}
				else
				{
					nullCellsCnt = 0;
				}
			}
			return -1;
		}
		public String alloc(int newSize)
		{
			int idx = findFreeBlockIndex(newSize);
			if (idx < 0)
				return "NULL";

			mBlocksCnt++;
			for (int j = idx, k = 0; k < newSize; j++, k++)
			{
				mMemory[j] = mBlocksCnt;
			}
			return Byte.toString(mBlocksCnt);
		}
		public boolean erase(int idx)
		{
			if (idx <= 0)
				return false;

			boolean found = false;
			for (int i = 0; i < mMaxSize; i++)
			{
				if (mMemory[i] == (byte)idx)
				{
					found = true;
					mMemory[i] = 0;
				}
			}
			return found;
		}
		public boolean defrag()
		{
			byte[] memory = new byte[mMaxSize];
			int idx = 0;
			for (int i = 0; i < mMaxSize; i++)
				memory[i] = 0;
			
			for (int i = 0; i < mMaxSize; i++)
			{
				if (mMemory[i] > 0)
				{
					memory[idx] = mMemory[i];
					idx++;
				}
			}
			mMemory = memory;
			memory = null;
			return true;
		}
		public String printSnapshot() {
			String s = "";
			for (int i = 0; i < mMaxSize; i++)
				s += mMemory[i] + " ";
			return s;
		}
	}
	
	
	private PrintWriter out;
	private StreamTokenizer in;

	public int nextInt() throws IOException
	{
		in.nextToken();
		return (int)in.nval;
	}
	public String nextWord() throws IOException
	{
		in.nextToken();
		return in.sval;
	}
	
	public static void main(String[] args) throws IOException
	{
		new Problem().run();
	}

	public void run() throws IOException
	{
		//in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
		in = new StreamTokenizer(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		//out = new PrintWriter("output.txt");
		solve();
		out.flush();
	}
	public void solve() throws IOException
	{
		int commandsCnt = nextInt();
		int maxMemorySize = nextInt();
		int curSize = 0;
		
		MemoryManager memoryManager = new MemoryManager(maxMemorySize);

		for (int i = 0; i < commandsCnt; i++)
		{
			String curCommand = nextWord();
			if (curCommand.contains("alloc"))
			{
				curSize = nextInt();
				//out.print("alloc:"); out.println(curSize);
				out.println(memoryManager.alloc(curSize));
				//out.println(memoryManager.printSnapshot());
			}
			else if (curCommand.contains("defrag"))
			{
				//out.println("defragment");
				memoryManager.defrag();
				//out.println(memoryManager.printSnapshot());
			}
			else if (curCommand.contains("erase"))
			{
				curSize = nextInt();
				//out.println("erase:");
				if (! memoryManager.erase(curSize))
				{
					out.println("ILLEGAL_ERASE_ARGUMENT");
				}
			}
		}
	}
}
