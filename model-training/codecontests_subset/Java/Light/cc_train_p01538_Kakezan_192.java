import java.util.*;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		int Q = stdIn.nextInt();
		while(Q-- != 0)
		{
			int N = stdIn.nextInt();
			int count = 0;
			TreeSet<Integer> isExist = new TreeSet<Integer>();
			while(true)
			{
				if(N < 10)
				{
					System.out.println(count);
					break;
				}
				int digit = 0;
				int NBuf = N;
				while(NBuf != 0)
				{
					NBuf /= 10;
					++digit;
				}
				int max = 0;
				int a = 10;
				for(int i = 1; i < digit; ++i)
				{
					int left = N / a;
					int right = N % a;
					if(left * right > max)
					{
						max = left * right;
					}
					a *= 10;
				}
				if(isExist.contains(max))
				{
					System.out.println(-1);
					break;
				}
				else
				{
					isExist.add(max);
				}
				N = max;
				++count;
			}
		}
	}
}