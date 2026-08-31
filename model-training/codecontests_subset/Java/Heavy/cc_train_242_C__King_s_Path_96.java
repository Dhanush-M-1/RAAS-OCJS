import java.io.*;
import java.util.*;

public class Solution {
    
    public static FastScanner scn = new FastScanner();
 
	public static void main(String[] args) {

        int[] start = new int[]{scn.nextInt(), scn.nextInt()};
        int[] finish = new int[]{scn.nextInt(), scn.nextInt()};
        
        int n = scn.nextInt();
        
        Set<String> set = new HashSet<>();
        
        while(n-->0){
            int r = scn.nextInt();
            int a = scn.nextInt();
            int b = scn.nextInt();
            
            for(int idx = a; idx <= b; idx++)
                set.add(r + "-" + idx);
        }
        
        int distance = bfs(start, finish, set);
        
        System.out.println(distance);
	}
	
	public static int bfs(int[] start, int[] finish, Set<String> set){
	    
	    Set<String> visited = new HashSet<>();
	    
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        
        int distance = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            while(size-->0){
            
                int[] point = queue.remove();
                visited.add(toString(point));
                
                if(isEqual(point, finish)) return distance;
                
                for(int[] neighbor : getNeighbors(point)){
                    if(!visited.contains(toString(neighbor)) && set.contains(toString(neighbor))){
                        queue.add(neighbor);
                        visited.add(toString(neighbor));
                    }
                }
            }
            
            distance++;
        }
        
        return -1;
	}
	
	public static String toString(int[] arr){
	    return arr[0]+"-"+arr[1];
	}
	
	public static boolean isEqual(int[] p1, int[] p2){
	    return p1[0] == p2[0] && p1[1] == p2[1]; 
	}
	
	public static List<int[]> getNeighbors(int[] point){
	    
	    List<int[]> list = new ArrayList<>();
	    
	    list.add(new int[]{point[0]-1, point[1]-1});
	    list.add(new int[]{point[0]-1, point[1]});
	    list.add(new int[]{point[0]-1, point[1]+1});
	    
	    list.add(new int[]{point[0]  , point[1]-1});
	    list.add(new int[]{point[0]  , point[1]+1});
	    
	    list.add(new int[]{point[0]+1, point[1]-1});
	    list.add(new int[]{point[0]+1, point[1]});
	    list.add(new int[]{point[0]+1, point[1]+1});
	    
	    return list;
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		Integer[] readArrayO(int n) {
			Integer[] a=new Integer[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		List<Integer> readArrayList(int n) {
			List<Integer> a=new ArrayList<>();
			for (int i=0; i<n; i++) a.add(nextInt());
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}