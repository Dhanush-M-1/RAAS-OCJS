import java.util.Scanner;

public class HelpfulMaths 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		String str = "";
		
		int length = line.length(), one=0, two=0, three=0;
		
		
		for(int i=0; i<length; i++)
		{
			if(line.charAt(i) == '1')
				one++;
			else if(line.charAt(i) == '2')
				two++;
			else if(line.charAt(i) == '3')
				three++;
		}
		
		// Stavimo vrednosti na string
		
		for(int i=0; i<one; i++)
			str += "1+";
		
		for(int i=0; i<two; i++)
			str += "2+";
		
		for(int i=0; i<three; i++)
			str += "3+";
		
		length = str.length();
		
		System.out.println(str.substring(0, length-1));
	}
}