import java.util.*;

public class Main 
{
	public static class Memory
	{
		protected int size;
		protected int m[];
		public int cnt;
		public Memory(int size)
		{
			this.cnt = 0;
			this.size = size;
			m = new int[this.size];
		}
		public boolean alloc(int n)
		{
			for (int i = 0; i < this.size; i++)
			{
				if (m[i] > 0) continue;
				boolean is_blank = true;
				for (int j = i; j < i + n; j++)
				{
					if (j >= this.size || m[j] > 0) {is_blank = false; break;}
				}
				if (is_blank) 
				{
					for (int j = i; j < i + n; j++) m[j] = cnt+1;
					cnt++;
					return true;
				}
			}
			return false;
		}
		public boolean erase(int pos)
		{
			boolean is_erased = false;
			if (pos <= 0) return is_erased;
			for (int i = 0; i < this.size; i++)
			{
				if (m[i] == pos)
				{
					m[i] = 0;
					is_erased = true;
				}
			}
			return is_erased;
		}
		public void defragment()
		{
			int buf[] = new int[this.size];
			int pnt = 0;
			for (int i = 0; i < this.size; i++)
			{
				if (m[i] > 0) buf[pnt++] = m[i];
			}
			for (int i = 0; i < this.size; i++)
			{
				m[i] = buf[i];
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int operations = in.nextInt();
		int size = in.nextInt();
		in.nextLine();
		Memory manager = new Memory(size);
		for (int i = 1; i <= operations; i++) 
		{
			String o = in.next();
			if (o.charAt(0) == 'd')
			{
				manager.defragment();
			}
			else if (o.charAt(0) == 'a')
			{
				if (manager.alloc(in.nextInt()))
				{
					System.out.println(manager.cnt);
				}
				else System.out.println("NULL");
					
			}
			else if (o.charAt(0) == 'e')
			{
				if (!manager.erase(in.nextInt()))
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
		}
		in.close();
	}
}