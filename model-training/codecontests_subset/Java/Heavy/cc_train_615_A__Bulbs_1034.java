
import java.util.*;

public class Problems {
	
	private static Scanner input;

	
	
	public static void main(String[] args)
	{
		int n,m,i,no=0,ind=0,x=1;
	    input = new Scanner(System.in);
	    n=input.nextInt();
	    m=input.nextInt();
	    
	    
	    int[] a = new int[100000] ;
	    
	    for(i=0;i<x;i++)
	    {
	    	a[i]=input.nextInt();
	    	//System.out.println();
	    	//System.out.println(i-1-no+" "+ind+" "+a[i]);
	    	if(i==0)
	    		{
	    		    n--;
	    		    no=a[i];
	    		    a[i]=1000;
	    		    if(n>0) x=no+2;
	    		    else x=no+1;
	    		}
	    	else
	    	{
	    		if(i-1-no==ind)
	    		{
	    			n--;
	    			no=a[i];
	    			a[i]=1000;
	    			ind=i;
	    			if(n>0) x+=no+1;
	    			else x+=no;
	    		}
	    	}
	    	//System.out.println(i-1-no+" "+ind+" "+a[i]);
	    }
	    int[] b=new int[x];
	    //Arrays.sort(a);
	    
	    for(i=0;i<x;i++)
	    {
	    	b[i]=a[i];
	    }
	    Arrays.sort(b);
	    for(i=0,no=1;i<x;i++)
	    {
	    	if(b[i]==no) no++;
	    }
	    
	    
	    if(no>m) System.out.println("Yes");
	    else System.out.println("No");
	    
	}
}