import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class D673 {
	static int oo = 987654321;
	public static void main(String[] args) {
		MyScanner scan = new MyScanner();
		
		int V = scan.nextInt(), E = scan.nextInt();
		if(E < V+1 || V==4){System.out.println(-1);return;}
		
		int a = scan.nextInt()-1, b = scan.nextInt()-1, c = scan.nextInt()-1, d = scan.nextInt()-1;
		ArrayList<Integer>[] adj = new ArrayList[V];
		for(int i=0;i<V;i++)adj[i] = new ArrayList<>();
		
		adj[a].add(c);adj[c].add(a);
		adj[b].add(d);adj[d].add(b);
		
		int first = -1, last = -1, prev=-1;
		for(int i=0;i<V;i++){
			if(i!=a&&i!=b&&i!=c&&i!=d){
				if(first==-1)first=last=i;
				else{
					last = i;
					adj[prev].add(i);
				}
				prev = i;
			}
		}
		adj[a].add(first);adj[c].add(first);
		adj[last].add(b);adj[last].add(d);
		
		int pos = a;
		boolean[] seen = new boolean[V];seen[a]=true;
		for(int i=0;i<V;i++){
			System.out.print((pos+1)+" ");
			if(pos==a){
				seen[c] = true;pos=c;
			}
			else if (pos==last){
				seen[d] = true;
				pos = d;
			}else{
				for(int j :adj[pos]){
					if(seen[j])continue;
					seen[j]=true;
					pos=j;break;
				}
			}
		}System.out.println();
		pos = c;
		seen = new boolean[V];seen[c] =true;
		for(int i=0;i<V;i++){
			System.out.print((pos+1)+" ");
			if(pos==c){
				seen[a] = true;pos=a;
			}else if (pos==last){
				seen[b] = true;
				pos = b;
			}
			else{
				for(int j :adj[pos]){
					if(seen[j])continue;
					seen[j]=true;
					pos=j;break;
				}
			}
		}System.out.println();
	}
	
	
	private static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
