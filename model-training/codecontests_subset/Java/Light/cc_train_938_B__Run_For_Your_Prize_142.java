//938B
import java.io.*;
import java.util.*;
public class acm{
	public static void main(String args[]) throws IOException{
		BufferedReader gi = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter go = new PrintWriter(System.out);
		gi.readLine();
		String ss[] = gi.readLine().split(" ");
		int L[] = new int[1000000];
		for (String s : ss){
			L[Integer.parseInt(s)-1] = 1; 
		}
		int k = 1;
		while (L[500000 + k -1] != 1 && L[500000 - k] != 1){
			k++;
		}
		go.println(500000 - k);
		go.close();
	}

}
