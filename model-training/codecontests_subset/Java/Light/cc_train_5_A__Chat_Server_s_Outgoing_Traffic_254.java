import java.util.*;

public class test2 {
    public static void main(String[] args) 
    {
	Scanner in = new Scanner(System.in);
	HashSet<String> hs=new HashSet<String>();
	int t=0;
	
	while(in.hasNext())
	{
	    String cmd=in.nextLine();
	    
	    if(cmd.charAt(0)=='+')
		hs.add(cmd.substring(1));
	    else if(cmd.charAt(0)=='-')
		hs.remove(cmd.substring(1));
	    else
	    {
		String[] ss=cmd.split(":");
		if(ss.length==2)
		    t+=hs.size()*ss[1].length();
	    }
	    
	   // System.out.println(t);
	}
	
	System.out.println(t);
	
    }
}
