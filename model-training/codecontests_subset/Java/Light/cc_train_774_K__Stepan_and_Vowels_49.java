import java.util.*;

public class Solution
{
	public static void main(String[] argc)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		char currChar = ' '; int cnt = 0;
		for (int i = 0; i < n; i++)
		{
		    if (currChar != s.charAt(i))
		    {
		        printChars(currChar, cnt);
                currChar = s.charAt(i);
                cnt = 1;
		    }
		    else
		        cnt++;
		}
		printChars(currChar, cnt);
		System.out.println();
	}
	public static void printChars(char currChar, int cnt)
	{
	    if (currChar == 'e' && cnt == 2)
            System.out.print("ee");
        else if (currChar == 'o' && cnt == 2)
            System.out.print("oo");
        else if ((currChar == 'a') || (currChar == 'e') || (currChar == 'i') || (currChar == 'o') || (currChar == 'u') || (currChar == 'y'))
            System.out.print(currChar);
        else
            System.out.print(new String(new char[cnt]).replace('\0', currChar));
	}
}