import java.util.*;
import java.io.*;

public class Codechef{
	
    public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader(new File("D:\\Shivang\\Java\\JavaFile.txt")));
		
		String[] cur1 = br.readLine().split(" ");
		int n = Integer.parseInt(cur1[0]);
		int m = Integer.parseInt(cur1[1]);
		
		HashSet<String> hashSet = new HashSet<>();
		
		for(int i = 0; i < n; i++){
			String[] cur = br.readLine().split(" ");
			for(int j = 1; j < cur.length; j++){
				hashSet.add(cur[j]);
			}
		}
		
		System.out.println(hashSet.size() == m? "YES": "NO");
		
		br.close();
    }
}