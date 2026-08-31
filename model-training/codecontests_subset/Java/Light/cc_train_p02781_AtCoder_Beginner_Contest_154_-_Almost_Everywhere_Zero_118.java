import java.util.Scanner;

public class Main {
	static int maxn = 100 + 10;
	static String str;
	static int k,n;
	static int cnt[];
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in);
		cnt =new int[maxn];
		str=cin.next();
		k=cin.nextInt();
		n=str.length();
		int ans=0;
		
		for(int i=0;i<n;i++)
			if(str.charAt(i)!='0')
				cnt[i]=1;
		for(int i=1;i<n;i++)
			cnt[i]+=cnt[i-1];
		
		if(k==1)
		{
			for(int x=0;x<n;x++)
				for(int a=1;a<=9;a++)
					if(panduan1(x,a)) ans++;
		}
		else if(k==2)
		{
			for(int x=0;x<n;x++)
				for(int y=x+1;y<n;y++)
					for(int a=1;a<=9;a++)
						for(int b=1;b<=9;b++)
						{
							if(panduan2(x,y,a,b)) ans++;
						}
		}
		else if(k==3)
		{
			for(int x=0;x<n;x++)
				for(int y=x+1;y<n;y++)
					for(int z=y+1;z<n;z++)
						for(int a=1;a<=9;a++)
							for(int b=1;b<=9;b++)
								for(int c=1;c<=9;c++)
									if(panduan3(x,y,z,a,b,c))ans++;
		}
		System.out.println(ans);
	}
	public static boolean judge(int l,int r)
	{
		if(l > r)
	        return false;
	    if(l == 0)
	        return cnt[r]==0?false:true;
	    return cnt[r] - cnt[l - 1]==0?false:true;
	}
	public static boolean panduan1(int x,int a)
	{
		if(x!=0)
			return true;
		if(str.charAt(0)-'0' >= a)
	        return true;
	    return false;
	}
	public static boolean panduan2(int x,int y,int a,int b)
	{
		if(x!=0) 
			return true;
		if(str.charAt(0)-'0'> a)
	        return true;
	    if(str.charAt(0)-'0' < a)
	        return false;
	    
	    if(judge(x + 1, y - 1))
	        return true;
	    if(str.charAt(y)-'0'>= b)
	        return true;
		return false;
	}
	public static boolean panduan3(int x,int y,int z,int a,int b,int c)
	{
		if(x!=0)
	        return true;
	    if(str.charAt(0)-'0'> a)
	        return true;
	    if(str.charAt(0)-'0'< a)
	        return false ;
	    if(judge(x + 1, y - 1))
	        return true;
	    if(str.charAt(y)-'0'> b)
	        return true;
	    if(str.charAt(y)-'0'< b)
	        return false;
	    if(judge(y + 1, z - 1))
	        return true;
	    if(str.charAt(z)-'0'>= c)
	        return true;
	    return false;
	}
}