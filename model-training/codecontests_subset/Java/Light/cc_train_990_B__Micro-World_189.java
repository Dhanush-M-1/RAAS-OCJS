import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new  Scanner(System.in);
	    int n=sc.nextInt();
	    int k=sc.nextInt();
	    TreeMap<Integer,Integer> tree=new TreeMap<>();
	    for(int i=0;i<n;i++){
	        int p=sc.nextInt();
	        if(!tree.containsKey(p)){
	            	        tree.put(p,1);
	        }
	        else{
	            tree.put(p,tree.get(p)+1);
	        }
	    }
        int count=0;int ele=0;int c=0;
        for(int x:tree.keySet()){
            if(count==0){
                ele=x;
            }
            
            if(x>ele && (x<=(ele+k))){
                c=c+tree.get(ele);
            }
            ele=x;
            count=count+1;
            
        }
        System.out.println(n-c);
	}
}
