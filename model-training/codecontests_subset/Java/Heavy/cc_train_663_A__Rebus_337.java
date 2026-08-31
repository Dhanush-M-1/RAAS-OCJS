import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Rebus {

	public static void main(String[] args) 
	{
		
		MyScannerrebus sc=new MyScannerrebus();
		String l=sc.nextLine();
		char rb[]=l.toCharArray();
		
		int pc=0,nc=0,i=0;
		boolean ispositive=true;
		while(rb[i]!='=')
		{
			if(rb[i]=='?')
			{
				if(ispositive){
				pc++;
				}
				else
					nc++;
			}
			else if(rb[i]=='+')
				ispositive=true;
			else if(rb[i]=='-')
				ispositive=false;
			i++;
		}
		
		int n=Integer.parseInt(l.substring(i+1,l.length()).trim());
		int min=pc-nc*n;
		int max=n*pc-nc;
		ispositive=true;
		if(min<=n && n<=max)
		{
			System.out.println("Possible");
			if(pc-nc>=n)
			{
				int req=pc-nc-n;
				
				i=0;
				while(rb[i]!='=')
				{
					
					if(rb[i]=='?')
					{
						if(ispositive)
						{
							System.out.print("1 ");
						}
						else
						{
							if(req>=(n-1))
							{
								req-=(n-1);
								System.out.print(n+" ");
							}
							else
							{
								System.out.print((1+req)+" ");
								req=0;
								
							}
							
						}
					}
					else if(rb[i]=='+'){
						ispositive=true;
						System.out.print("+ ");
					}
						
					else if(rb[i]=='-'){
						ispositive=false;
						System.out.print("- ");
					}
						i++;
				}
				
				
			}
			else
			{
				
				int req=n-(pc-nc);
				
				i=0;
				while(rb[i]!='=')
				{
					
					if(rb[i]=='?')
					{
						if(!ispositive)
						{
							System.out.print("1 ");
						}
						else
						{
							if(req>=(n-1))
							{
								req-=(n-1);
								System.out.print(n+" ");
							}
							else
							{
								System.out.print((1+req)+" ");
								req=0;
								
							}
							
						}
					}
					else if(rb[i]=='+'){
						ispositive=true;
						System.out.print("+ ");
					}
						
					else if(rb[i]=='-'){
						ispositive=false;
						System.out.print("- ");
					}
						i++;
				}
			}
			
		}
		else{
			System.out.println("Impossible");
			return;
		}
		
		System.out.println(l.substring(i,l.length()));
		

	}

}
class MyScannerrebus
{
	BufferedReader br;
	StringTokenizer st;
	MyScannerrebus()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	String next()
	{
		
		while(st==null || !st.hasMoreTokens())
		{
			try
			{
				st=new StringTokenizer(br.readLine());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return st.nextToken();
		
	}
	int nextInt()
	{
		return Integer.parseInt(next());
	}
	long nextLong()
	{
		return Long.parseLong(next());
	}
	double nextDouble()
	{
		return Double.parseDouble(next());
	}
	String nextLine()
	{
		String str="";
		try
		{
			str=br.readLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
		
	}
}
