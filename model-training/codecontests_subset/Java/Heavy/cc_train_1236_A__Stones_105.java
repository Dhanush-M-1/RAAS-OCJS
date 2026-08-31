import java.util.*;
import java.io.*;

public class albaaaai {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0)
		{
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
			int c = Integer.parseInt(st1.nextToken());
			
			int aa = a , bb = b , cc =c;
			
			int first = 0 , second = 0;
			
			while(bb > 0)
			{
				if(cc-2 >= 0)
				{
					cc-=2;
					bb--;
					first += 3;
				}
				else
				{
					break;
				}
			}
			
			while(aa > 0)
			{
				if(bb-2 >= 0)
				{
					bb-=2;
					aa--;
					first += 3;
				}
				else
				{
					break;
				}
			}
			
			while(a > 0)
			{
				if(b-2 >= 0)
				{
					b-=2;
					a--;
					second += 3;
				}
				else
				{
					break;
				}
			}
			
			while(b > 0)
			{
				if(c-2 >= 0)
				{
					c-=2;
					b--;
					second += 3;
				}
				else
				{
					break;
				}
			}
			
			out.println(Math.max(first, second));
		}
		
		out.flush();
		out.close();
	}

	

}
