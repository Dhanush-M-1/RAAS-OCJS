    // No sorceries shall previal. //
         
    import java.util.Scanner; 
    import java.io.PrintWriter;
    import java.util.*;
    import java.util.Arrays;
     
    public class InVoker {
    	
    	public static void main(String args[]) {
    		
    		Scanner inp = new Scanner(System.in);
    		PrintWriter out= new PrintWriter(System.out);
    		
    		int n= inp.nextInt();
    		int m=inp.nextInt();
    		int a[]=new int[n];
    		for(int i=0;i<n;i++)
    			a[i]=inp.nextInt()-1;
    		
    		int u[]=new int[m];
    		int v[]=new int[m];
    		int adj[][]=new int[n][];
    		int deg[]=new int[n];
    		for(int i=0;i<m;i++) {
    			u[i]=inp.nextInt()-1;
    			v[i]=inp.nextInt()-1;
    			deg[u[i]]++;
    		}
    		
    		for(int i=0;i<n;i++)
    			adj[i]=new int[deg[i]];
    		for(int i=0;i<m;i++) {
    			int x=u[i];
    			int y=v[i];
    			adj[x][--deg[x]]=y;
    		}
    		
    		boolean can[]=new boolean[n];
    		can[a[n-1]]=true;
    		int alive=1,gg=0;
    		for(int i=n-2;i>=0;i--) {
    			int c=0;
    			for(int x:adj[a[i]])
    				if(can[x])
    					c++;
    			if(c==alive)
    				gg++;
    			else {
    				alive++;
    				can[a[i]]=true;
    			}
    		}
    		
    		out.println(gg);
       		out.close();
    		inp.close();
    					
    }
    		
}