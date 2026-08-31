import java.util.*;
import java.io.*;
public class Ilya_and_Tic_Tac_Toe_Game
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
		char[][] arr=new char[8][8];
		for(int x=0;x<8;x++)
			Arrays.fill(arr[x],' ');
		for(int y=0;y<4;y++)
		{
			String temp=f.readLine();
			for(int x=0;x<4;x++)
				arr[y+2][x+2]=temp.charAt(x);
		}
		int[] xdir={-1,-1,0,1,1,1,0,-1};
		int[] ydir={0,-1,-1,-1,0,1,1,1};
		boolean masterflag=false;
		for(int y=2;y<6;y++)
			for(int x=2;x<6;x++)
				if(arr[y][x]=='x')
				{
					for(int b=0;b<8;b++)
					{
						boolean flag=true;
						int counter=0;
						for(int a=0;a<3;a++)
						{
							if(arr[y+ydir[b]*a][x+xdir[b]*a]=='o'||arr[y+ydir[b]*a][x+xdir[b]*a]==' ')
								flag=false;
							else if(arr[y+ydir[b]*a][x+xdir[b]*a]=='.')
								counter++;
						}
						if(flag&&counter<=1)
							masterflag=true;
					}
				}
		System.out.println(masterflag?"YES":"NO");
	}
}