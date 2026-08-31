import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class A {
	static int[] dx = new int[]{0,0,1,-1};
	static int[] dy = new int[]{1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		char[][] grid=  new char[N][M];
		for(int a=0;a<N;a++)grid[a]=sc.next().toCharArray();
		PriorityQueue<State> PQ = new PriorityQueue<State>();
		LinkedList<State> LL = new LinkedList<State>();
		boolean[][] visited = new boolean[N][M];
		stuff: for(int a=0;a<N;a++){
			for(int b=0;b<M;b++){
				if(grid[a][b]=='.'){
					State s =new State(a,b,0); 
					PQ.add(s);
					LL.add(s);
					visited[a][b]=true;
					break stuff;
				}
			}
		}
		while(!LL.isEmpty()){
			State cur = LL.poll();
			for(int d=0;d<4;d++){
				int y = dy[d]+cur.y;
				if(y<0||y>=N)continue;
				int x = dx[d]+cur.x;
				if(x<0||x>=M)continue;
				if(grid[y][x]=='.'&&!visited[y][x]){
					visited[y][x]=true;
					State s = new State(y,x,cur.c+1);
					LL.add(s);
					PQ.add(s);
				}
			}
		}
		while(K-->0){
			State cur = PQ.poll();
			grid[cur.y][cur.x]='X';
		}
		for(int a=0;a<N;a++){
			System.out.println(String.valueOf(grid[a]));
		}
		
		

	}
	static class State implements Comparable<State>{
		int y,x,c;
		State(int a, int b, int cc){
			y=a;
			x=b;
			c=cc;
		}
		@Override
		public int compareTo(State o) {
			return o.c-this.c;
		}
	}
//
}