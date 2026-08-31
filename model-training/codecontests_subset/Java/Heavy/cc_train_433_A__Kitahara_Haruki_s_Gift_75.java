import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		

		
				
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr=new PrintWriter(new OutputStreamWriter(System.out));


		int n=Integer.parseInt(r.readLine());
	
	
	StringTokenizer str=new StringTokenizer(r.readLine());

	int one=0,two=0;
	for(int i=0;i<n;i++)
	{
	
		int x=Integer.parseInt(str.nextToken());
		if(x==100)
		{
			one++;
		}
		else
			two++;
	}
	
	if(two%2==0)
	{
		if(one%2==0)
		{
			pr.print("YES");
		}
		else
		{
			pr.print("NO");
		}
	}
	else
	{
		if(one>=2&&one%2==0)
		{
			pr.print("YES");
		}
		else
		{
			pr.print("NO");
		}
		
	}
	pr.flush();
	pr.close();
	

		}
	}