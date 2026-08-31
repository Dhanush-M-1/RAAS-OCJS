import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class cdf294b 
{
	public static void main(String[] args) throws Exception
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    int a1[]=new int[n];
	    int a2[]=new int[n-1];
	    int a3[]=new int[n-2];
	    String s=br.readLine();
	    String ss1[]=s.split(" ");
	    for(int i=0;i<n;i++)
	    	a1[i]=Integer.parseInt(ss1[i]);
	    s=br.readLine();
	    String ss2[]=s.split(" ");
	    for(int i=0;i<n-1;i++)
	    	a2[i]=Integer.parseInt(ss2[i]);
	    s=br.readLine();
	    String ss3[]=s.split(" ");
	    for(int i=0;i<n-2;i++)
	    	a3[i]=Integer.parseInt(ss3[i]);
	    Arrays.sort(a1);
	    Arrays.sort(a2);
	    Arrays.sort(a3);
	    for(int i=0;i<n;i++)
	    {
	    	if(i==n-1||a1[i]!=a2[i])
	    	{
	    		System.out.println(a1[i]);
	    		break;
	    	}
	    }
	    for(int i=0;i<n-1;i++)
	    {
	    	if(i==n-2||a2[i]!=a3[i])
	    	{
	    		System.out.println(a2[i]);
	    		break;
	    	}
	    }
	}
}
