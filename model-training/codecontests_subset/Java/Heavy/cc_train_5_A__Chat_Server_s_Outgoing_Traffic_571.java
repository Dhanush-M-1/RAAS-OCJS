
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	       
	void solve() throws IOException
	{
		Scanner in=new Scanner(System.in);
		HashSet<String>all=new HashSet<String>();
		int ret=0;
		while(in.hasNextLine())
		{
			String s=in.nextLine();
			if(s.startsWith("+"))
			{
				all.add(s.substring(1,s.length()));
			}
			else if(s.startsWith("-"))
			{
				all.remove(s.subSequence(1, s.length()));
			}
			else
			{
				int L=s.subSequence(s.indexOf(':')+1,s.length()).length();
				ret+=L*all.size();
			}
			
		}
		System.out.println(ret);
	
			
	
		
	}
	
	public static void main(String[] args) throws IOException {
			new Main().solve();

	}

}
