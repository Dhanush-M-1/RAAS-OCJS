import java.util.*;

public class test 
{
    static boolean[] mem=null;
    static HashMap<Integer,Section> hm=new HashMap<Integer,Section>();
    static TreeSet<Section> ts=new TreeSet<Section>();
    
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int m=in.nextInt();
        mem=new boolean[m];
        Arrays.fill(mem,true);
        int id=1;
        
        for(int i=0;i<t;i++)
        {
            String cmd=in.next();
            int num=0;
            if(!cmd.equals("defragment"))
        	num=in.nextInt();
            
            if(cmd.equals("alloc"))
            {
        	int j=0;
        	int start=-1;
        	while(j<m)
        	{
        	    if(mem[j] && start==-1)
        		start=j;
        	    
        	    if(mem[j] && j-start+1>=num)
        	    {
        		break;
        	    }
        	    
        	    if(mem[j]==false && start!=-1)
        	    {
        		start=-1;
        	    }
        	    
        	    j++;
        	}
        	
        	if(j<m)
        	{
        	    hm.put(id,new Section(start,num));
        	    ts.add(hm.get(id));
        	    for(int k=start;k<start+num;k++)
        		mem[k]=false;
        	    System.out.println(id++);
        	}
        	else
        	    System.out.println("NULL");
            }
            else if(cmd.equals("erase"))
            {
        	if(!hm.containsKey(num))
        	    System.out.println("ILLEGAL_ERASE_ARGUMENT");
        	else
        	{
        	    Section s=hm.get(num);
        	    for(int j=s.start;j<s.start+s.size;j++)
        		mem[j]=true;
        	    ts.remove(hm.get(num));
        	    hm.remove(num);
        	}
            }
            else
            {
        	int start=0;
        	
        	for(Section s: ts)
        	{
        	    if(start!=s.start)
        	    {
                	    
                	    for(int j=s.start;j<s.start+s.size;j++)
                		mem[j]=true;
                	    
                	    for(int j=start;j<start+s.size;j++)
                		mem[j]=false;
                	    
                	    s.start=start;
        	    }
        	    
        	    start=start+s.size;
        	}
        	    
            }
        }

 
    }
}

class Section implements Comparable<Section>
{
    int start;
    int size;
    
    public Section(int st, int si)
    {
	start=st;
	size=si;
    }

    @Override
    public int compareTo(Section o) {
	return start-o.start;
    }
}
