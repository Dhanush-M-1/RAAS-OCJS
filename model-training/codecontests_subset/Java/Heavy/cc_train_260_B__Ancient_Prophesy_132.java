import java.util.*;

public class code
{
	static class node implements Comparable<node>
	{
		String date;
		int count;

		node(String d, int cnt)
		{
			date = d;
			count = cnt;
		}

		@Override
		public int compareTo(node o)
		{
			return this.count - o.count;
		}
	}
	public static void main(String[] args)
	{
		int day[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		Scanner scan = new Scanner(System.in);

		String date = scan.nextLine().trim();

		ArrayList<node> dates = new ArrayList<node>();

		for(int i = 0; i+10 <= date.length(); i++)
		{
			String sub = date.substring(i, i+10);
			if(count(sub) != 2)
				continue;

			String [] tokens = sub.split("-");

			if(tokens.length != 3)
				continue;
			if(tokens[0].length() != 2 || tokens[1].length() != 2 || tokens[2].length() != 4)
				continue;
			if(!(isInt(tokens[0]) && isInt(tokens[1]) && isInt(tokens[2])))
				continue;
			if(!(Integer.parseInt(tokens[2]) >= 2013 && Integer.parseInt(tokens[2]) <= 2015))
				continue;
			if(Integer.parseInt(tokens[1]) <= 0 || Integer.parseInt(tokens[1]) > 12)
				continue;
			if(Integer.parseInt(tokens[0]) <= 0 || Integer.parseInt(tokens[0]) > day[Integer.parseInt(tokens[1])])
				continue;

			int idx;
			if((idx = contain(dates, sub)) != -1)
				dates.get(idx).count++;
			else
				dates.add(new node(sub, 1));

		}
		Collections.sort(dates);
		System.out.println(dates.get(dates.size()-1).date);

	}

	private static int count(String sub)
	{
		int cnt = 0;
		for(int i = 0; i < sub.length(); i++)
			if(sub.charAt(i) == '-')
				cnt++;
		return cnt;
	}

	private static int contain(ArrayList<node> dates, String str)
	{
		for(int i = 0; i < dates.size(); i++)
			if(dates.get(i).date.equals(str))
				return i;
		return -1;
	}

	private static boolean isInt(String token)
	{
		if(token.isEmpty() || token.contains("-"))
			return false;

		for(int i = 0; i < token.length(); i++)
			if(token.charAt(i) < '0' || token.charAt(i) > '9')
				return false;
		return true;
	}
}
