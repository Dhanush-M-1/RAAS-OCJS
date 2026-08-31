import java.util.*;
import java.io.*;

public class Main
{
	
	static public void main(String[] argv) throws IOException
	{
		//BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int[] bit = new int[200];
		int op = in.nextInt();
		int len = in.nextInt();
		
		int cnt=0;
		
		while(op-- != 0)
		{
			in.nextLine();
			String com = in.next();
			//in.nextLine();
			
			if(com.equals("alloc"))
			{
				int curlen = in.nextInt();
				int freepos = -1;
				for(int i = 1 ; i <= len ; i++)
				{
					int ok = 1;
					
					if(i + curlen -1 > len)
						break;
					
					for(int j = i ; j < i+curlen ; j++)
						if(bit[j] != 0)
						{
							ok = 0;
							break;
						}
					if(ok == 1)
					{	//System.out.println("NULL");
						freepos = i;
						break;
					}
				}
				
				if(freepos != -1)
				{
					cnt++;
					System.out.println(cnt);
					for(int j = freepos ; j < freepos+curlen ; j++)
						bit[j]=cnt;
				}
				else
					System.out.println("NULL");
			}
			else if(com.equals("erase"))
			{
				int curlen = in.nextInt();
				int ok=0;
				for(int i = 1 ; i <= len ; i++)
				{
					if(bit[i] == curlen)
					{
						bit[i]=0;
						ok=1;
					}
				}
				
				if(curlen==0/*curlen <= 0 || curlen > cnt ||*/ ||ok ==0)
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
			else
			{
				for(int i = 1,j  =1 ; i <= len ; i++)
				{
					while(j <= len && bit[j] == 0)j++;
					if (i == j) 
					{ 
						++j; 
						continue; 
					}
					
					if (j <= len) 
					{
						bit[i] = bit[i] + bit[j];
						bit[j] = bit[i] - bit[j];
						bit[i] = bit[i] - bit[j];
					}
					else break;
				}
			}
		}
	}
}
