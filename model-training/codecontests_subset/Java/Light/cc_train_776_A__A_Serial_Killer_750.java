import java.io.*;
public class Main {
public static void main(String args[])throws IOException
{
	BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
	String temp[]=obj.readLine().split(" ");
	System.out.println(temp[0]+" "+temp[1]);
	int n=Integer.parseInt(obj.readLine());
	for(int i=0;i<n;i++)
	{
		String temp2[]=obj.readLine().split(" ");
		if(temp2[0].equals(temp[0]))
		{
			temp[0]=temp2[1];
		}
		else
			if(temp2[0].equals(temp[1]))
			{
				temp[1]=temp2[1];
			}
		System.out.println(temp[0]+" "+temp[1]);
	}
	
}
}
