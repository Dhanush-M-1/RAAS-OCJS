import java.util.*;
public class GFG
{
	static int ans(char s[], int n)
	{
	    int c=0;
		for(int i=1; i<n; i++) 
		{
			if(i>=2 && s[i]==s[i-2]) 
			{
			    c++;
			    s[i]='A';
			}
			else if(s[i]==s[i-1])
			{
			    c++;
			    s[i]='A';
			}
		}
		return c;
	}
	public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        String s=sc.next();
	        int n=s.length();
	        char arr[]=s.toCharArray();
	        System.out.println(ans(arr,n));
	    }
	}
}
