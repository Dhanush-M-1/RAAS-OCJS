import java.util.Scanner;
class Main
{
    public static void main(String args[])
    {
	Scanner scan=new Scanner(System.in);
	while(true)
	    {
		int n=scan.nextInt();
		if(n==0)break;
		int d[]=new int[n];
		for(int i=0;i<n;i++)
		    {
			d[i]=scan.nextInt();
		    }
		int count=0;
		for(int i=0;i<n;i++)
		    {
			for(int j=n-1;j>0;j--)
			    {
				if(d[j-1]>d[j])
				    {
					int tmp=d[j-1];
					d[j-1]=d[j];
					d[j]=tmp;
					count++;
				    }
			    }
		    }
		System.out.println(count);
	    }
    }
}