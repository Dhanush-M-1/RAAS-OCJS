import java.util.*;
import java.lang.*;
public final class Hmaths
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int i=0;
		List<Integer> list=new ArrayList<Integer>();
		if(str.length()==1)
			System.out.println(str);
		else
		{
			for(i=0;i<str.length();i++)
			{
				if(str.charAt(i)!='+')
				{
					list.add((int)str.charAt(i)-48);
				}
			}
			Collections.sort(list);
			for(i=0;i<list.size();i++)
			{
				if(i==0)
						System.out.print(list.get(i));
					else
							System.out.print("+"+list.get(i));
			}
			
		}
	}
}