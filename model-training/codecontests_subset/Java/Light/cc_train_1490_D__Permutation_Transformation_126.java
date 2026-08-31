import java.util.*;

public class PermTrans
{
	static int[] a;
	static int n;
	static int[] map;

	public static void main(String[] args)
	{
		int T,t;
		int i,j;

		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(t = 0;t<T;t++)
		{
			n = sc.nextInt();
			a = new int[n];
			map = new int[n];

			for(i = 0;i<n;i++)
				a[i] = sc.nextInt();
				

			
			int sIndex = getMax(0, n-1, 0);

			assign(sIndex , 0, 0, n-1);
			


		

		for (int tmp : map)
			System.out.print(tmp  + " ");

		System.out.println();
		}
	}



	private static void assign(int index, int depth, int s, int e)
	{
		if(s<=e)
		map[index] = depth;
			
		if( !(s<0 || e>n-1) && (s<e))
		{

			int in = getMax(s, index-1, 0);
			assign(in, depth+1, s, index-1);

			in = getMax(index+1, e, 1);
			assign(in, depth+1, index+1, e);
		}

	}

	private static int getMax(int s, int e, int mode)
	{
		//System.out.println(s + "\t" + e);
		
		if(s>=e)
			return mode == 1?e:s;

		int max = 0, maxIn = -1;
		for(int i = s;i<=e;i++)
		{
			if(a[i] > max)
			{
				max = a[i];
				maxIn = i;
			}
		}

		return maxIn;
	}

}
