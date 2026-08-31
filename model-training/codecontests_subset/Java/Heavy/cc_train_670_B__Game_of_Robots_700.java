import java.util.*;


public class bucky{




public static void main (String args[]) {

Scanner input=new Scanner(System.in);

HashMap<String, Integer> map= new HashMap<String, Integer>();
HashMap<String, String> map2= new HashMap<String, String>();

	
	
	
	
		int n=input.nextInt();
		Long k=input.nextLong();
		Long nums[]= new Long[n+1];
		
		
		
		for(int i=0;i<n;i++) nums[i]=input.nextLong();
		
		double x=(-1+Math.sqrt(1+8*k))/2;
		
		double y=(Math.ceil(x)-1);
		
		int z=(int) y;
		
		Long jos=Long.valueOf(z);
		
		
	int result=(int)(k-(jos*(jos+1)/2));
	
	
	
	//System.out.println(result);
		
		System.out.println(nums[result-1]);
		
		
		}
		
		
		
		
		
		
		
		}