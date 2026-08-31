import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 * Comments Here
 * 
 */
public class A868
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
		
		String s = br.readLine();
		boolean c1 = false;
		boolean c2 = false;
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; ++i){
			String t = br.readLine();
			if(t.equals(s)){
				c1 = true;
				c2 = true;
			}

			if(t.charAt(1) == s.charAt(0)){
				c1 = true;
			}
			
			if(t.charAt(0) == s.charAt(1)){
				c2 = true;
			}
		}
		
		if(c1 && c2){
			bw.write("YES\n");
		} else {
			bw.write("NO\n");
		}
		br.close();
		bw.close();
	}
	

	
	
}

