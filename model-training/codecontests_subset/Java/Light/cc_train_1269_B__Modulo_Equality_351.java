
import java.util.*;

public class Main {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(),m=scan.nextInt(),s=0;
		List<Integer>x =  new ArrayList<Integer>();
		List<Integer>y =  new ArrayList<Integer>();
		for (int i = 0; i < n; i++)x.add(scan.nextInt());
		for (int i = 0; i < n; i++)y.add(scan.nextInt());
		Collections.sort(y);
		Collections.sort(x);
		for(int i=0;i<n;i++)
	    {
	        int a=(y.get(0)-x.get(i)+m)%m;
	        boolean g=true;
	    	for(int j=0;j<n;j++)
	    	{
	    		if ((x.get((i+j)%n)+a)%m!=y.get(j))	g=false;
	    	}
	    	if(g)s=a;
	    }
		System.out.println(s);
		
	}

}
