import java.util.*;
import java.io.*;

public class Server{
	public static void main(String[] args){
		Scanner stdIn = null;
		try{
			stdIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int count = 0;
			int result = 0;
			while( stdIn.hasNext() ){
				String str = stdIn.nextLine();
				if( str.charAt(0) == '+' ){
					count++;
				} else if( str.charAt(0) == '-' ){
					count--;
				} else {
					String[] s = str.split(":");
					if( s.length == 1 ){
						continue;
					} else {
						result += (s[1].length())*count;
					}
				}
			}
			System.out.println(result);
		} finally {
			if( stdIn != null ){
				stdIn.close();
			}
		}
	}
}
