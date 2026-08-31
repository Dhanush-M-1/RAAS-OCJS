import java.io.*;
class Main
{
    public static void main(String args[])throws IOException
    {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	int n=Integer.parseInt(input.readLine());
	String str=input.readLine();
	String str_ary[]=str.split(" ");
	int a[]=new int[n];
	int x=0;
	for(int i=0;i<n;i++)
	    {
		a[i]=Integer.parseInt(str_ary[i]);
	    }
	for(int i=0;i<n;i++)
	    {
		int mini=i;
		int lowkey=a[i];
		for(int j=i;j<n;j++)
		    {
			if(a[j]<lowkey)
			    {
				mini=j;
				lowkey=a[j];
				
			    }
			
		    }
		if(a[i]>lowkey)
		    {
		int temp=a[i];
		a[i]=a[mini];
		a[mini]=temp;
		    }
		else x++;
	    }	
	for(int i=0;i<n;i++)
	    {
		System.out.print(a[i]+((i!=n-1)?" ":"\n"));
	    }
	System.out.println(n-x);
    }
}