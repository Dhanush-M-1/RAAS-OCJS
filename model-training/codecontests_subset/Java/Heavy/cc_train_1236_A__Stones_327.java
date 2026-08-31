import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.StringTokenizer;

public class Msv {
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
	static void BFS1(ArrayList<Integer>[] adj, HashMap<Integer, Integer> map, HashMap<Integer, Integer> newmap) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[adj.length]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[1]=true; 
        queue.add(1); 
        int s;
        int flag=0;
        while (queue.size() != 0) 
        { 
            s = queue.poll();
            int val = map.get(s);
            int len = 0;
            for(int i=0;i<adj[s].size();i++) {
            	if(!visited[adj[s].get(i)]) {
            		len++;
            		int x = newmap.get(adj[s].get(i))+val;
            		newmap.put(adj[s].get(i), x);
            	}
            }
            map.put(s, newmap.get(s)-len*val);
            //////////////
            //System.out.println(map.get(s));
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            {
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
            flag=0;
        }
        
    } 
	static void BFS(ArrayList<Integer>[] adj, HashMap<Integer, Integer> map, HashMap<Integer, Integer> newmap) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[adj.length]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[1]=true; 
        queue.add(1); 
        int s;
        int flag=0;
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll();
            //System.out.println("index "+s);
            if(adj[s].size()==1&&visited[adj[s].get(0)]) flag=1;
            if(flag==0) {
            int val = map.get(s);
            int len=0;
            for(int i=0;i<adj[s].size();i++)
            	if(!visited[adj[s].get(i)]) len++;
            val*=len;
            newmap.put(s, val);
            }
            
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            {
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
            flag=0;
        }
        BFS1(adj, map, newmap);
        
    } 
	public static void main(String[] args) {
		try {
			FastReader in = new FastReader();
			int t = in.nextInt();
			while(t-->0) {
				int a = in.nextInt();
				int b = in.nextInt();
				int c = in.nextInt();
				int ans = 0;
				while(b>0&&c>1) {
					ans+=3;
					b--;
					c-=2;
				}
				while(b>1&&a>0) {
					ans+=3;
					b-=2;
					a--;
				}
				System.out.println(ans);
			}
		}catch(Exception e) {}
	}

}
