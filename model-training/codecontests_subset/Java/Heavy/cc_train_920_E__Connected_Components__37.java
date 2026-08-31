import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    public static int dfs(TreeSet<Integer> ve,Set<Integer>[] ed,int i){
        ve.remove(i);
        // int val=0;
        // int c=1;
        // while(ve.higher(val)!=Integer.MAX_VALUE){
        //     if(!ed[i].contains(ve.higher(val))){
        //         c=c+dfs(ve,ed,ve.higher(val));
        //     }
        //     val=ve.higher(val);
        // }
        // return c;
        int c=1;
        if(ve.isEmpty())
            return c;
        Integer v=ve.first();
        while(v!=null){
            if(!ed[i].contains(v)){
                c+=dfs(ve,ed,v);
            }
            v=ve.higher(v);
        }
        return c;
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s=new Scanner(System.in);
		int v=s.nextInt();
		int m=s.nextInt();
		Set<Integer>[] g=new HashSet[v+1];
		for(int i=0;i<=v;i++)
		    g[i]=new HashSet<>();
		TreeSet<Integer> ve=new TreeSet<>();
	    for(int i=0;i<m;i++){
	        int a=s.nextInt();
	        int b=s.nextInt();
	        g[a].add(b);
	        g[b].add(a);
	    }
		for(int i=1;i<=v;i++)
		    ve.add(i);
		ArrayList<Integer> li=new ArrayList<>();
		for(int i=1;i<=v;i++){
		    if(ve.contains(i))
		        li.add(dfs(ve,g,i));
		}    
		Collections.sort(li);
		System.out.println(li.size());
		for(int i=0;i<li.size();i++)
		    System.out.print(li.get(i)+" ");
	}
}