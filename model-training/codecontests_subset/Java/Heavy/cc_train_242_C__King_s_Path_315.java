import java.util.*;
import java.io.*;
public class search {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int x1=sc.nextInt();
		int y1=sc.nextInt();
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		int n=sc.nextInt();
		
		
		TreeMap<pair , Integer> map=new TreeMap<search.pair, Integer>(new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				if(o1.x==o2.x ) return  o1.y-o2.y;
				return o1.x- o2.x;
			}
		});
		
		
		TreeSet<pair> set= new TreeSet<pair>(new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				if(o1.x==o2.x ) return  o1.y-o2.y;
				return o1.x- o2.x;
			}
		});
		
		
		
		for (int i = 0; i <n; i++) {
			int a=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			for (int j = 0; j < y-x+1; j++) {
				set.add(new pair(a, x+j));
			}
		}
	
		
		Queue<pair> q= new LinkedList<pair>();
		
		q.add(new pair(x1, y1));
		map.put(new pair(x1, y1), 0);
		
		
		while(!q.isEmpty()){
			pair top=q.poll();
			if(top.x==x2 && top.y==y2) {System.out.println(map.get(top)); return;}
			int t=map.get(top);
			
			
			
			for(int i=0;i<8;i++){
				pair ragaca=new pair(top.x+dirx[i], top.y+diry[i]);
				if(!map.containsKey(ragaca) && set.contains(ragaca)){
					q.add(ragaca);
					map.put(ragaca, t+1);
				}
			}
			
			
			
			
		}
		System.out.println(-1);

		
	}
	static int [] dirx=new int [] {1,1,1,-1,-1,-1,0,0};
	static int [] diry=new int [] {1,-1,0,1,-1,0,1,-1};
	static class pair{
		int x, y;
		public pair(int x , int y){
			this.x=x;
			this.y=y;
		}
	}
}


