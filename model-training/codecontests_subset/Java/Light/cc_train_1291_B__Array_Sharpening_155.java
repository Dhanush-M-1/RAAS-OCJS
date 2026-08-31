import java.util.*;


public class code
{
	
  public static void main(String[] args) 
  {

  		Scanner in = new Scanner(System.in);
  		int t = in.nextInt();
  		while (--t>=0) 
  			{
  				int i=0,j;
  				int f = 0,f1=0,f2=0;
  				int m1=Integer.MAX_VALUE,m2=Integer.MAX_VALUE;
  				
  				int cnt=0;
  				int sum=0;
  				//HashMap<Long,Integer> h = new HashMap<>();
  				int n = in.nextInt();
  				//String s = in.next();
  				int a[] = new int[n];
  				for(i=0;i<n;++i)
  				{
  					a[i] = in.nextInt();
  				}
  				for(i=0;i<n;++i)
  				{
  					if(a[i]<n-i-1)
  					{
  						f=1;
  						break;
  					}
  				}
  				if(f!=0)
  				{
  					for(i=0;i<n;++i)
  					{
  						if(a[i]<i)
  						{
  							f1=1;
  							break;
  						}
  					}
  					if(f1==1)
  					{
  						for(i=i-1;i<n;++i)
  						{
  							 if(a[i]<n-i-1)
  							 {
  							 	f2=1;
  							 	break;
  							 }
  						}
  					}
  				}
  				if(f==0||f1==0||(f1!=0&&f2==0))
  					System.out.println("Yes");
  				else 
  				{
  					System.out.println("No");
  				}
  			}
  		
  		
  }
}