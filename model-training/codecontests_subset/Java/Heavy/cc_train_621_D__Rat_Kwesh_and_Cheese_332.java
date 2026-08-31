import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Ratkweshandcheese {
	
	static double EPS = 1e-10;

	public static void main(String[] args) 
	{
		MyScannerrat sc=new MyScannerrat();
		double x=sc.nextDouble();
		double y=sc.nextDouble();
		double z=sc.nextDouble();
		boolean fmax=true;
		if((x<=1) && (y<=1) && (z<=1) )
		{
			fmax=false;
		}
		int count=0;
		int index=-1;
		double max=0;
		String types[]={"x^y^z",
						"x^z^y",
						"(x^y)^z",
						"(x^z)^y",
						"y^x^z",
						"y^z^x",
						"(y^x)^z",
						"(y^z)^x",
						"z^x^y",
						"z^y^x",
						"(z^x)^y",
						"(z^y)^x"};
		for(int i=1;i<=12;i++)
		{
			double res;
			double base;
			double log;
			double other;
			count++;
			if(count==5)
				count=1;
			if(i<=4)
			{	base=x;
			
			}
			else if(i<=8){
				base=y;
			}
			else{
				base=z;
			}
			if(base<=1 && fmax)
				continue;
			if(i==1 || i==3 ||i==10 || i==12)
				log=y;
			else if(i==2 || i==4 ||i==6 || i==8)
				log=z;
			else
				log=x;
			other=x+y+z-base-log;
			if(count==1 || count==2)
			{	res=typea(base,log,other);
			}
			else{
				res=typeb(log,other,base);
			}
			
			
			if(fmax && res>(max+EPS) || index==-1)
			{
				max=res;
				index=i;
			}
			else if(!fmax && res<(max-EPS))
			{
				max=res;
				index=i;
			}
		}
		
		System.out.println(types[index-1]);
	}
	public static double typea(double base,double log,double other)
	{
		return other*Math.log(log)+lnln(base);
		
	}
	static double lnln(double v)
	{
		if(v<1)
			v=1/v;
		return Math.log(Math.log(v));
	}
	public static double typeb(double a,double b,double base)
	{
		return Math.log(a)+Math.log(b)+lnln(base);
	}
}
class MyScannerrat
{
	BufferedReader br;
	StringTokenizer st;
	MyScannerrat()
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