import java.util.*;
import java.io.*;

public class Solution1{

	public static Integer INT(String s){
		return Integer.parseInt(s);
	}

	public static Long LONG(String s){
		return Long.parseLong(s);
	}

	//====================================================================================================================


	

	static LinkedList<Integer> adj[];


	public static void main(String args[])throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String line[]=br.readLine().split("\\s");
		int n=INT(line[0]);

		adj=new LinkedList[n+1];
		for(int i=0; i<=n; i++)
			adj[i]=new LinkedList<>();

		for(int i=1; i<n; i++){
			line=br.readLine().split("\\s");
			int u=INT(line[0]),
				v=INT(line[1]);
			
			adj[u].add(v);
			adj[v].add(u);
		}

		boolean flag=true;
		for(int i=1; i<=n; i++)
			if(adj[i].size()==2)
				flag=false;

		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}