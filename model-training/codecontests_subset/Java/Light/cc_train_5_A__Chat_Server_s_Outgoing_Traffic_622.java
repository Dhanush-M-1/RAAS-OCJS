import java.util.Scanner;

public class File1 {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int c = 0;
		int ans = 0;
		while(in.hasNextLine()){
			String s = in.nextLine();
			if(s.charAt(0)=='+')
				c++;
			else if(s.charAt(0)=='-')
				c--;
			else{
				if(s.charAt(s.length()-1)!=':')
					ans = ans+c*s.split(":")[1].length();
			}
		}
		System.out.println(ans);
	}
}
	