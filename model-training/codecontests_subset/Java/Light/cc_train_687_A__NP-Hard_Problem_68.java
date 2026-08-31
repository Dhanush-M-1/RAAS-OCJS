import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner qwe = new Scanner(System.in);
		
		int n = qwe.nextInt();
		int m = qwe.nextInt();
		
		
		ArrayList<Integer>[] aj = new ArrayList[n+1];
		for (int i = 0; i < aj.length; i++) {
			aj[i] = new ArrayList<Integer>();
		}
		
		while(m-->0){
			int u = qwe.nextInt();
			int v = qwe.nextInt();
			aj[u].add(v);
			aj[v].add(u);
		}
		
		ArrayList<Integer>[] s = new ArrayList[2];
		for (int i = 0; i < s.length; i++) {
			s[i] = new ArrayList<Integer>();
		}
		
		int[] color = new int[n+1];
		
		boolean impos = false;
		
		for(int i = 1; i <= n; i++){
			
			if(color[i] == 0){
				s[0].add(i);
				color[i] = 1;
				ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
				dq.add(i);
				
				while(!dq.isEmpty()){
					int at = dq.poll();
					
					for(int to : aj[at]){
						
						if(color[to] == 0){
							int nc = 3-color[at];
							s[nc-1].add(to);
							color[to] = nc;
							dq.add(to);
						}
						else if(color[to] == color[at]){
							impos =true;
						}
						
						
					}
					
					
				}
				
				
				
			}
			
		}
		
		if(impos) System.out.println(-1);
		else{
			
			for(int i =0;i  < s.length; i++){
				System.out.println(s[i].size());
				
				for(int a : s[i]){
					System.out.print(a + " ");
				}
				System.out.println();
				
			}
			
		}
		
		
		
		
		
		qwe.close();
	}

}