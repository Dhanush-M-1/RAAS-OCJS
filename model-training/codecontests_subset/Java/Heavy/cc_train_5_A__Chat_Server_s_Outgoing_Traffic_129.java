import java.util.* ;
/*
public class Main
{
	public static void main(String [] args)
	{
		Scanner s=new Scanner (System.in);
		String temp = new String ();
		HashSet myset =new HashSet<String> ();
		myset.clear();
	    int n=s.nextInt(),ans=0;
	    s.nextLine();
	    for(int i=0;i<n;i++)
	    {
	    	temp=s.nextLine();
	    	if(temp.charAt(0)=='+')
	    		myset.add(temp.substring(1,temp.length()));
	    	else if(temp.charAt(0)=='-')
	    		myset.remove(temp.substring(1,temp.length()));
	    	else 
	    	{
	    		String [] type = temp.split(":");
	    		ans+=type[1].length()*myset.size();
	    	}
	    }
	    System.out.println(ans);
		s.close();
	}
}*/

public class Main
{
	public static void main(String [] args)
	{
		Scanner s=new Scanner (System.in);
		String temp = new String ();
		HashSet myset =new HashSet<String> ();
		myset.clear();
	    int ans= 0;
	    while(s.hasNext())
	    {
	    	temp=s.nextLine();
	    	if(temp.charAt(0)=='+')
	    		myset.add(temp.substring(1,temp.length()));
	    	else if(temp.charAt(0)=='-')
	    		myset.remove(temp.substring(1,temp.length()));
	    	else 
	    	{
	    		for(int i=0;i<temp.length();i++)
	    		{
	    			if(temp.charAt(i)==':')
	    			{
	    				ans+=myset.size()*(temp.length()-1-i);
	    				break ;
	    			}
	    		}
	    	}
	    }
	    System.out.println(ans);
		s.close();
	}
}