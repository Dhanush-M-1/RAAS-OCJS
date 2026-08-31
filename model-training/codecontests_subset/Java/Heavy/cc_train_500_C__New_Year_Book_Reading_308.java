import java.util.*;
public class C
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] weight = new int[n];
		for(int x = 0; x < n; x++)
		{
			weight[x] = in.nextInt();
		}
		
		int[] read = new int[m];
		for(int y = 0; y < m; y++)
		{
			read[y] = in.nextInt() - 1;
		}
		
		ArrayList<Integer> books = new ArrayList<Integer>();
		boolean[] used = new boolean[n];
		for(int z = 0; z < read.length; z++)
		{
			if(!used[read[z]])
			{
				books.add(read[z]);
				used[read[z]] = true;
			}
		}
		
		int result = 0;
		for(int a = 0; a < read.length; a++)
		{
			int index = -1;
			for(int b = 0; b < books.size(); b++)
			{
				if(books.get(b) == read[a])
				{
					index = b;
					break;
				}
				else
				{
					result += weight[books.get(b)];
				}
			}
			
			int book = books.remove(index);
			books.add(0, book);
		}
		
		System.out.println(result);
	}
}
