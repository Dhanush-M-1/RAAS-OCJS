import java.util.*;
public class Main 
{
	 static HashMap<Integer,node> map = new HashMap<Integer,node>();
	 static HashMap<node,Integer> hash = new HashMap<node,Integer>();
	 static int curr=1;
     static List<node> list = new ArrayList<node>();
	 public static void main(String[] args)
	    {
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        int m = scan.nextInt();

	        list.add(new node(0,0));
	        list.add(new node(m+1,m+1));
	        for(int i=0;i<n;i++)
	        {
	        	String tem = scan.next();
	        	if(tem.equals("alloc"))
	        	{
	        		int t = all(scan.nextInt());
	        		if(t!=-1) System.out.println(t);
	        		else System.out.println("NULL");
	        	}
	        	else if(tem.equals("erase"))
	        	{
	        		int t = scan.nextInt();
	        		if(map.get(t)==null) System.out.println("ILLEGAL_ERASE_ARGUMENT");
	        		else
	        		{
	        			 
	        			list.remove(map.get(t));
	        			hash.remove(map.get(t));
	        			map.remove(t);
	        		}
	        	}
	        	else frag();
	        }
	    }
	 public static int all(int x)
	 {
		 for(int i=0;i<list.size()-1;i++)
		 {
			 node a = list.get(i);
			 node b = list.get(i+1);
			 if(b.start-a.end>x)
			 {
				 list.add(i+1,new node(a.end+1,a.end+x));
				 map.put(curr++,list.get(i+1));
				 hash.put(list.get(i+1), curr-1);
				 return curr-1;
			 }
		 }
		 return -1;
	 }
	 public static void frag()
	 {
		int start=1,end;
		for(int i=1;i<list.size()-1;i++)
		{
			end = start+(list.get(i).end-list.get(i).start);
			node tem = list.get(i);
			list.remove(i);
			int t = hash.get(tem);
			hash.remove(tem);
			map.remove(t);
			tem = new node(start,end);
			list.add(i,tem);
			hash.put(tem, t);
			map.put(t, tem);
			start = end + 1;
		}
	 }
	  
}
class node implements Comparable<node>
{
	int start;
	int end;
	node(int start,int end)
	{
		this.start=start;
		this.end=end;
	}
	public String toString()
	{
		return "["+start+","+end+"]";
	}
	public int compareTo(node y)
	{
		if(y.start==start && y.end==end) return 0;
		return 1;
	}
	public boolean equals(node x)
	{
		if(x.start==start && x.end==end) return true;
		return false;
	}
	
	
}