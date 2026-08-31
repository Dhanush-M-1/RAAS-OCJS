import java.util.*;
public class div2_695 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong();
		while(t-->0)
			
		{
			int n = in.nextInt();
			int a[] = new int[n];
			int m = in.nextInt();
			int b[] = new int[m];
			for(int i=0 ; i<n ; i++) a[i] = in.nextInt();
			for(int i=0 ; i<m ; i++) b[i] = in.nextInt();
			int flag=0,ans=-1;
			for(int i=0 ; i<n ; i++)
			{
			    for(int j=0 ; j<m ; j++)
			    {
			        if(a[i]==b[j])
			        {
			            flag=1;
			            ans = a[i];
			            break;
			        }
			    }
			    if(flag==1) break;
			}
			if(flag==1) 
			{
			    System.out.println("YES");
			    System.out.println("1 "+ans);
			}
			else
			    System.out.println("NO");
		}
		
	}

}