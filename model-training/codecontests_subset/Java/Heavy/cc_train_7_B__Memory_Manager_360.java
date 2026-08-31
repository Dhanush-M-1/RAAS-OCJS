
import java.io.*;
import java.util.*;

public class MemoryManager
{
	public Scanner in = new Scanner(System.in);
	public PrintStream out = System.out;

	private class Block implements Comparable<Block>
	{
		public int ID, start, end;
		
		public Block(int IDIn, int startIn, int endIn)
		{
			ID = IDIn;
			start = startIn;
			end = endIn;
		}
		
		public int compareTo(Block u)
		{
			return start - u.start;
		}
	}
	
	public ArrayList<Block> A;
	public int T, M;
	public int ID;
	
	public void main()
	{
		String cmd;
		int n, x;
		
		T = in.nextInt();
		M = in.nextInt();
		
		A = new ArrayList<Block>();
		ID = 1;
		
		int i, j, k;
		
		for(i=0;i<T;++i)
		{
			cmd = in.next();
			
			if(cmd.equals("alloc"))
			{
				n = in.nextInt();
				k = alloc(n);
				
				if(k >= 0)
				{
					out.println(k);
				}
				else
				{
					out.println("NULL");
				}
			}
			else if(cmd.equals("erase"))
			{
				x = in.nextInt();
				if(!erase(x)) out.println("ILLEGAL_ERASE_ARGUMENT");
			}
			else if(cmd.equals("defragment"))
			{
				defragment();
			}
		}
	}//end public void main()
	
	public int alloc(int n)
	{
		Collections.sort(A);
		int i, j, h, k;
		Block B, newB;
		
		h = 1;
		for(i=0;i<A.size();++i)
		{
			B = A.get(i);
			k = B.start - 1;
			if(k-h+1 >= n)
			{
				newB = new Block(ID, h, h+n-1);
				//out.println("newB("+ID+","+h+","+k+")");
				A.add(newB);
				++ID;
				return newB.ID;
			}
			
			h = B.end+1;
		}
		
		k = M;
		if(k-h+1 >= n)
		{
			newB = new Block(ID, h, h+n-1);
			//out.println("newB("+ID+","+h+","+k+")");
			A.add(newB);
			++ID;
			return newB.ID;			
		}
		
		return -1;
	}
	
	public boolean erase(int x)
	{
		int i;
		for(i=0;i<A.size();++i)
		{
			if(A.get(i).ID == x)
			{
				A.remove(i);
				return true;
			}
		}		
		return false;
	}
	
	public void defragment()
	{
		Collections.sort(A);
		
		int i, j, h, k, n;
		Block B;
		
		h = 1;
		for(i=0;i<A.size();++i)
		{
			B = A.get(i);
			n = B.end - B.start + 1;
			
			B.start = h;
			B.end = h + n - 1;
			
			h += n;
		}
	}

	public static void main(String[] args)
	{
		(new MemoryManager()).main();
	}
}