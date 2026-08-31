import java.util.*;
public class Solution {

	public static void main(String[] args) {
	  
		  Scanner sc=new Scanner(System.in);
		   int t=sc.nextInt();
		   while(t--!=0)
		   {
			   int n=sc.nextInt();
			   int m=sc.nextInt();
			   int a[]=new int[n];
			   int b[]=new int[m];
			   for(int i=0;i<n;i++)
			   {
				   a[i]=sc.nextInt();
			   }
			   for(int i=0;i<m;i++)
			   {
				   b[i]=sc.nextInt();
			   }
			   HashSet<Integer> set=new HashSet<>();
			    for(int i=0;i<n;i++)
			    {
			    	set.add(a[i]);
			    }
			    
			    boolean pos=false;
			    
			    for(int i=0;i<m;i++)
			    {
			    	if(set.contains(b[i]))
			    	{
			    		System.out.println("YES");
			    		System.out.println("1 "+b[i]);
			    		pos=true;
			    		break;
			    		
			    	}
			    }
			    if(pos==false)
			    System.out.println("NO");
			  
		   }
	}
		
}
		
	
	
	

