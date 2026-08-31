    import java.io.BufferedReader;
    import java.io.InputStreamReader;
     
    public class cdf146a 
    {
    	static boolean isp(int n)
    	{
    		for(int i=2;i<=(int)Math.sqrt(n);i++)
    		{
    			if(n%i==0)
    				return false;
    		}
    		return true;
    	}
    	public static void main(String args[])throws Exception
    	{
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		long n=Long.parseLong(br.readLine());
    		if(n==1||n==2)
    		{
    			System.out.println(n);
    			return;
    		}
    		long ans=1;
    		if(n%2==1)
    		{
    			ans=n*(n-1)*(n-2);
    			System.out.println(ans);
    			return;
    		}
    		int i;
    		for(i=2;i<=2*(int)Math.sqrt(n);i++)
    		{
    			if(n%i!=0&&isp(i))
    			break;
    		}
    		long ans2=(n-3)*(n-1)*(n-2);
    		ans=n*(n-1)*(n-i);
    		System.out.println((long)Math.max(ans2,ans));
    	}
    }

