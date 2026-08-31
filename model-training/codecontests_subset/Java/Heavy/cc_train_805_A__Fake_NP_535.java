import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 * Comments Here
 * 
 */
public class E2
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
		
		st = new StringTokenizer(br.readLine());
		
		int a  = Integer.parseInt(st.nextToken());
		int b  = Integer.parseInt(st.nextToken());
		
		if(a == b) {
			bw.write(a + " \n");
		} else {
			bw.write("2\n");
		}
		
		br.close();
		bw.close();
	}
	

	
	
}

