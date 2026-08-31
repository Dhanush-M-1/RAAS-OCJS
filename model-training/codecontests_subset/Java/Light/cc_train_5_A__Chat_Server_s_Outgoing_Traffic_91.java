import java.io.*;
import java.util.*;
public class cf5A {
	public static void main(String[] args) throws Exception {
		
			Scanner sc = new Scanner(System.in);
			int traffic = 0;
			int part = 0;
			String s;
			while(sc.hasNextLine())
			{
				s = sc.nextLine();
				if(s.charAt(0) == '+')
					part++;
				else if(s.charAt(0) == '-')
					part--;
				else
					traffic += part*(s.length()-s.indexOf(':')-1);
			}
			System.out.println(traffic);
	}
}
