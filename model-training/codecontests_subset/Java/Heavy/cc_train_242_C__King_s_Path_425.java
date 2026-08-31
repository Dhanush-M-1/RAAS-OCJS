import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class KingsPath {
	public static void main(String[] args)
	{
		Scanner br=new Scanner(System.in);
		int sx=br.nextInt(),sy=br.nextInt(),tx=br.nextInt(),ty=br.nextInt();
		HashMap<Integer,HashMap<Integer,Integer>> index=new HashMap<Integer,HashMap<Integer,Integer>>();
		int n=br.nextInt();
		int in=0;
		int[] dx=new int[]{1,0,-1,0,1,1,-1,-1};
		int[] dy=new int[]{0,1,0,-1,1,-1,1,-1};
		ArrayList<ArrayList<Integer>> map=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++)
		{
			int r=br.nextInt(),c1=br.nextInt(),c2=br.nextInt();
			for(int j=c1;j<=c2;j++)
			{
				if(!index.containsKey(r))
					index.put(r,new HashMap<Integer,Integer>());
				if(!index.get(r).containsKey(j))
				{
					map.add(new ArrayList<Integer>());
					index.get(r).put(j,in++);
				}
				for(int k=0;k<8;k++)
				{
					int nx=r+dx[k],ny=j+dy[k];
					if(index.containsKey(nx)&&index.get(nx).containsKey(ny))
					{
						int a=index.get(r).get(j),b=index.get(nx).get(ny);
						map.get(a).add(b);
						map.get(b).add(a);
					}
				}
			}
		}
		int start=index.get(sx).get(sy),end=index.get(tx).get(ty);
		boolean[] seen=new boolean[in];
		PriorityQueue<State> queue=new PriorityQueue<State>();
		queue.add(new State(start,0));
		while(!queue.isEmpty())
		{
			State s=queue.poll();
			if(seen[s.index])
				continue;
			seen[s.index]=true;
			if(s.index==end)
			{
				System.out.println(s.dist);
				return;
			}
			for(int next:map.get(s.index))
			{
				if(!seen[next])
					queue.add(new State(next,s.dist+1));
			}
		}
		System.out.println(-1);
	}
	public static class State implements Comparable<State>
	{
		int index,dist;
		public State(int a,int c)
		{
			index=a;
			dist=c;
		}
		public int compareTo(State o)
		{
			return dist-o.dist;
		}
	}
}
