import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Compt {

	static BufferedReader br;
	static int max = -1 ;
	static String key = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		Map<String , Integer> map = new TreeMap();
		for (int i = 0 ; i < n - 1 ; i++) {
			String sub = s.substring(i, i+2);
			if(map.containsKey(sub)) {
				int c = map.get(sub) + 1;
				map.remove(sub);
				map.put(sub, c);
			} else {
				map.put(sub, 0);
			}	
		}
		
	    map.forEach((k,v)-> {
	    	if ( v > max ) {
	    		max = v;
	    		key = k;
	    	}
	    	
	    });
		System.out.println(key);
            
	}
}