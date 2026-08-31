//package Round400;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 * Comments Here
 * 
 */
public class A
{
	static BufferedReader br; 
	static BufferedWriter bw; 
	static StringTokenizer st;

	public static void main(String[] args) throws java.lang.Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	//Uncomment to read from file
    	/*/
    	File file = new File("src/in.txt");
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/**/
		
		String name1, name2;
		String victim, newTarget;
		int n;
		
		st = new StringTokenizer(br.readLine());
		name1 = st.nextToken();
		name2 = st.nextToken();
		bw.write(name1 + " " + name2 + "\n");
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			victim = st.nextToken();
			newTarget = st.nextToken();
			if(name1.equals(victim)) {
				name1 = newTarget;
			} else {
				name2 = newTarget;
			}
			bw.write(name1 + " " + name2 + "\n");
		}
		
		br.close();
		bw.close();
	}
}

