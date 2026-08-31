
	import java.util.*;
	
	
	import java.io.*;
	
	/* Name of the class has to be "Main" only if the class is public. */
	public class solution
	{
	   
	    
	    public static void main (String[] args) throws java.lang.Exception
	    {
	        Scanner sc = new Scanner(System.in);
	        //System.out.print("hel");
	        int t=sc.nextInt();
	        PrintWriter out=new PrintWriter(System.out);
	        //int arr[]=new int[n];
	        int n,i,c,sum,x,y;
	        String s;
	        for(;t>0;t--)
	        {
	        	x=y=0;
	        	n=sc.nextInt();
	        	int arr[][]=new int[n][n];
	        	for(i=1;i<=n;i++)
	        	{
	        		s=sc.next();
	        		//s=sc.next();
	        		if(i==1)
	        			arr[0][1]=s.charAt(1)-48;
	        		if(i==2)
	        			arr[1][0]=s.charAt(0)-48;
	        		if(i==n-1)
	        			arr[n-2][n-1]=s.charAt(n-1)-48;
	        		if(i==n)
	        			arr[n-1][n-2]=s.charAt(n-2)-48;
	        	}
	        	/*out.println(arr[0][1]);
	        	out.println(arr[1][0]);
	        	out.println(arr[n-2][n-1]);
	        	out.println(arr[n-1][n-2]);*/
	        	if(arr[0][1]==arr[1][0])
	        	{
	        		
	        		//out.println("first");
	        		sum=1-arr[0][1];
	        		c=0;
	        		if(arr[n-1][n-2]!=sum)
	        		{
	        			c++;
	        			x=1;
	        			//out.println(n+" "+(n-1));
	        		}
	        		if(arr[n-2][n-1]!=sum)
	        		{
	        			c++;
	        			y=1;
	        		}
	        		out.println(c);
	        		if(x==1)
	        			out.println(n+" "+(n-1));
	        		if(y==1)
	        			out.println(n-1+" "+(n));
	        			
	        	}
	        	else if(arr[n-2][n-1]==arr[n-1][n-2])
	        	{
	        		//out.println("sec");
	        		sum=1-arr[n-1][n-2];
	        		c=0;
	        		if(arr[1][0]!=sum)
	        		{
	        			c++;
	        			x=1;
	        			//out.println(n+" "+(n-1));
	        		}
	        		if(arr[0][1]!=sum)
	        		{
	        			c++;
	        			y=1;
	        		}
	        		
	        		out.println(c);
	        		if(x==1)
	        			out.println("2 1");
	        		if(y==1)
	        			out.println("1 2");
	        		
	        	}
	        	else
	        	{
	        		c=0;
	        		sum=1;
	        		if(arr[1][0]!=sum)
	        		{
	        			c++;
	        			x=1;
	        			
	        		}
	        		if(arr[0][1]!=sum)
	        		{
	        			c++;
	        			y=1;
	        		}
	        		sum=0;
	        		int x1=0,y1=0;
	        		if(arr[n-1][n-2]!=sum)
	        		{
	        			c++;
	        			x1=1;
	        			//out.println(n+" "+(n-1));
	        		}
	        		if(arr[n-2][n-1]!=sum)
	        		{
	        			c++;
	        			y1=1;
	        		}
	        		out.println(c);
	        		if(x==1)
	        			out.println("2 1");
	        		if(y==1)
	        			out.println("1 2");
	        		if(x1==1)
	        			out.println(n+" "+(n-1));
	        		if(y1==1)
	        			out.println(n-1+" "+(n));
	        	}

	        
	        }
	        out.close();
	        
	    }
	}
	
