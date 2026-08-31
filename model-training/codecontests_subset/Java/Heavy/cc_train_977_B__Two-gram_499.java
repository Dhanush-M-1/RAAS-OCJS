import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class TwoGram {
	public static void main(String[] args)throws Exception{
		Map<String, Integer> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int tempCounter = 0;
		String output = new String();
		for(int i = 0 ; i <length-1 ; i++) {
			int local = i+2;
			int localCounter = 0;
			if(map.containsKey(input.substring(i, local))){
				localCounter = map.get(input.substring(i, local));
				map.put(input.substring(i, local),  ++localCounter);
				if(tempCounter < localCounter) {
					tempCounter = localCounter;
					output =  input.substring(i, local);
					
				}
			}else {
				map.put(input.substring(i, local), localCounter);
			}
		}
		
		if(output.length()==0) {
			System.out.println(input.substring(length-2, length));
		}
		else{
		    System.out.println(output);    
		}
		//System.out.println(map);
		
	}
 
}