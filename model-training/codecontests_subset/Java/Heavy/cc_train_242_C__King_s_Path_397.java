import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.Queue;

public  class acm {
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int x1=in.nextInt(),y1=in.nextInt(),x2=in.nextInt(),y2=in.nextInt(),n=in.nextInt();
		Pair first=new Pair(x1,y1);
		Pair end=new Pair(x2,y2);
		HashSet<Pair>points=new HashSet<>();
		while(n-->0)
		{
			int r=in.nextInt(),a=in.nextInt(),b=in.nextInt();
				
			for(int i=a;i<=b;i++)
				points.add(new Pair(r,i));
		}
		int[] offsetx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] offsety = { -1, 1, 0, 1, -1, 0, 1, -1 };
		int ans=-1;
		
		Queue<State>q=new LinkedList<State>();
		q.add(new State(first,0));
		HashSet<Pair> vis = new HashSet<Pair>();
		while(!q.isEmpty())
		{
			State current=q.remove();
			if(current.a.equals(end))
			{
				ans=current.len;
				break;
				
			}
			
			for(int i=0;i<8;i++)
			{
				
				Pair target=new Pair(current.a.x+offsetx[i],current.a.y+offsety[i]);
				
				if(points.contains(target)&&!vis.contains(target))
				{
					q.add(new State(target,current.len+1));
					vis.add(target);
					
				}
				
				
				
				
			}
			
			
			
			
			
			
		}
		
		
		
		

		System.out.println(ans);

	
	
	}
	public static class State {
		Pair a;
		int len;
 
		public State(Pair b, int l) {
			a = b;
			len = l;
		}
 
	}
 

	
public static class Pair{
	int x ;
	int y ; 
	Pair(int i , int j )
	{
		x=i;
		y=j;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {

		if(obj==null || !(obj instanceof Pair))
			return false;
		
		return ((Pair)obj).x==x&&((Pair)obj).y==y;
	}


	
	
	
	
}
}
