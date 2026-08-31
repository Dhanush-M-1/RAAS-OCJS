import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "+");
		String[] array = new String[st.countTokens()];
		
		for(int i=0; i<array.length; i++) array[i] = st.nextToken();
		
		Arrays.sort(array);
		for(int i=0; i<array.length; i++){
			if(i!=0) System.out.print("+");
			System.out.print(array[i]);
		}
	}
}
