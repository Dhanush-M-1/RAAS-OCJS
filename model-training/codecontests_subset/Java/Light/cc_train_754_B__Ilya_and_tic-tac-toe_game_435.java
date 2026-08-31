import java.util.Scanner;


public class IlyaTicTacToe
{
	public static boolean recognizer(char[] c)
	{
		int [] series = {0,1,2,1,2,3,4,5,6,5,6,7,8,9,10,9,10,11,12,13,14,13,14,15,0,4,8,4,8,12,1,5,9,5,9,13,2,6,10,6,10,14,3,7,11,7,11,15,1,6,11,0,5,10,5,10,15,4,9,14,2,5,8,3,6,9,6,9,12,7,10,13};
		for(int i = 0; i < series.length;i += 3)
		{
			for(int j = 0; j < 3 && (c[series[i]] == '.' || c[series[i+1]] == '.' || c[series[i+2]] == '.'); j++)
			{	
				char temp = 'x';
				if(c[series[i+j]] == '.')
				{
					temp = c[series[i+j]];
					c[series[i+j]] = 'x';
					if(c[series[i]] == c[series[i+1]] && c[series[i+2]] == c[series[i+1]] && c[series[i]] == 'x')
						return true;
					else
						c[series[i+j]] = temp;
				}
				
			}
			if(c[series[i]] == c[series[i+1]] && c[series[i+2]] == c[series[i+1]] && c[series[i]] == 'x')
				return true;
			
		}
		return false;
	}
	public static void main(String [] args)
	{
		String newone = "";
		char [] arr = new char[16];
		Scanner inp = new Scanner(System.in);
		for (int i = 0; i < arr.length;)
		{
			newone = inp.nextLine();
			for (int j = 0; j < 4; j++)
			{
				arr[i++] = newone.charAt(j);
			}
		}
		System.out.println(recognizer(arr)?"YES":"NO");
	}
}
