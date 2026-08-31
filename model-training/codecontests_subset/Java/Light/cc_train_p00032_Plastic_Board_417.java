import java.util.Scanner;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		Scanner stdIn = null;
		int rect = 0;
		int rhomb = 0;
		try{
			stdIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			while( stdIn.hasNext() ){
				String str = stdIn.next();
				String[] data;
				data = str.split(",");
				int[] s = new int[data.length];
				for(int i = 0; i < 3; i++){
					s[i] = Integer.parseInt(data[i]);
				}
				if( s[0] == s[1] ){
					rhomb++;
				}
				if( s[0]*s[0] + s[1]*s[1] == s[2]*s[2] ){
					rect++;
				}
			}
			System.out.println(rect);
			System.out.println(rhomb);
		} finally {
			if( stdIn != null ){
				stdIn.close();
			}
		}
	}
}