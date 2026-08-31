import java.util.Scanner;
import java.util.Stack;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String X = in.next();
		in.close();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < X.length(); i++)
		{
			char c = X.charAt(i);
			if (c == 'S' || st.isEmpty())
			{
				st.push(c);
			} else//Tが来て かつ 空でない
			{
				if (st.peek() == 'S')
				{
					st.pop();//Sをポップ(Tと相殺)
				} else
				{
					st.push(c);//Tをプッシュ
				}
			}
		}
		System.out.println(st.size());
	}
}
