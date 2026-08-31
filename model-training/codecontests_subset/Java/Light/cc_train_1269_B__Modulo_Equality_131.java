import java.util.*;
 
public class Solve {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int  n=sc.nextInt();
	    int m=sc.nextInt();
	  
	    
	    long[] ar=new long[n];
	    
	    long[] br=new long[n];
	    long[] vis=new long[n];
	  
	    for(int i=0;i<n;i++){
	        ar[i]=sc.nextLong();
	         vis[i]=ar[i];
	       
	    }
	    
	    for(int i=0;i<n;i++){
	        br[i]=sc.nextLong();
	      
	    }
	    
	    sort(br);
	    sort(ar);
	    long ans=0;
	    for(int i=0;i<n;i++)
	    {
	        long a=(br[0]-ar[i]+m)%m;
	        boolean ok=true;
	    	for(int j=0;j<n;j++)
	    	{
	    		if ((ar[(i+j)%n]+a)%m!=br[j])	ok=false;
	    	}
	    	if(ok==true)ans=a;
	    }
		System.out.println(ans);
}
	static void sort(long[] ar){
    ArrayList<Long> al=new ArrayList<>();
	for(int i=0;i<ar.length;i++){
		al.add(ar[i]);
	}
 
	Collections.sort(al);
      int j=0;
	for(long a:al){
 
		ar[j]=a;
		j++;
	}
	}
}