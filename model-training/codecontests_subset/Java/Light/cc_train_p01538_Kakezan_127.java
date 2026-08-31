import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		while(in.hasNext())
		{
			int N=in.nextInt();
			for(int i=0;i<N;i++)
			{
				int n=in.nextInt();
				int cnt=0;
				boolean loop=false;
				HashSet<Integer>HS=new HashSet<Integer>();
				while(n>10)
				{
					if(HS.contains(n))
					{
						loop=true;
						break;
					}
					HS.add(n);
					++cnt;
					int max=-1;
					String st=n+"";
					for(int j=1;j<st.length();j++)
					{
						String x=st.substring(0, j);
						String y=st.substring(j, st.length());
						int mul=Integer.valueOf(x)*Integer.valueOf(y);
						max=Math.max(max,mul);
					}
					n=max;
				}
				System.out.println(loop ? -1:cnt);
			}
		}
	}
	
	static public void debug(Object... o)
	{
		System.out.println(Arrays.deepToString(o));
	}
}