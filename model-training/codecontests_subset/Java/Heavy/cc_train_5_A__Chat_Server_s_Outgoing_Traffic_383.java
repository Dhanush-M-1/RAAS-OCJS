import java.util.ArrayList;
import java.util.Scanner;
public class ChatServer 
{
	public static void main(String []args) 
	{
		ArrayList <String> persons=new ArrayList<>();
		int bytes=0;
		Scanner in=new Scanner(System.in);
		while(in.hasNextLine())
		{
			String input=in.nextLine();
			if(input.charAt(0)=='+')
				persons.add(input.substring(1));
			
			else if(input.charAt(0)=='-')
				persons.remove(input.substring(1));
			
			else
				bytes = bytes + persons.size() * getMessageLength(input);			
		}
		System.out.println(bytes);

	}
	private static int getMessageLength(String input) {
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)==':')
				return input.substring(i+1).length();
		}
		return 0;
	}
}