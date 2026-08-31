import java.io.*;

public class Tic
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader obj = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(obj);
		char[][] str = new char[4][4];
		for(int i=0;i<=3;i++)
			str[i] = br.readLine().toCharArray();
		boolean flag= false;		
		for(int x=0 ;x<=3;x++)//forhorizontal check
		{
						
			for(int y=0;y<=3;y++)
			{
				char ch = str[x][y];
				if( x>0 && x<3 && checkforwin(ch, str[x-1][y],str[x+1][y]))
				{
					flag = true;
					break;
				}
				if( y>0 && y<3 && checkforwin(ch, str[x][y+1],str[x][y-1]))
				{
					flag = true;
					break;
				}
				if( x>0 && x<3 && y>0 && y<3 && (checkforwin(ch,str[x-1][y-1],str[x+1][y+1]) || checkforwin(ch,str[x-1][y+1],str[x+1][y-1])))
	{
		flag= true;
		break;
	}
			}
			
				if (flag==true)
				{
					System.out.println("YES");
					System.exit(0);
				}
		}
		System.out.println("NO");
	}
	
	public static boolean checkforwin(char... inp)
	{
		int count=0;
		for(int i=0;i<3;i++)
		{
			if(inp[i]=='x')
				count++;
			if(inp[i]=='o')
				count--;
		}
		return count>=2;
	}
}
		


	
		
		
