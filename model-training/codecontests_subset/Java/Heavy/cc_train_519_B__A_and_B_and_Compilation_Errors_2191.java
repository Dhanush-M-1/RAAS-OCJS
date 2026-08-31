import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class AandB {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		
		int n = Integer.parseInt(buf);
		
		HashMap<Long, Integer> errors = new HashMap<>();
		buf = br.readLine();
		for(String s:buf.split(" ")){
			long num = Long.parseLong(s);
			errors.put(num, errors.getOrDefault(num, 0)+1);	
		}
		
		buf = br.readLine();
		for(String s:buf.split(" ")){
			long num = Long.parseLong(s);
			errors.put(num, errors.getOrDefault(num, 0)+1);			
		}
		
		for(Long key : errors.keySet()){
			if(errors.get(key)%2 == 1){
				System.out.println(key);
				errors.put(key, (errors.get(key)-1)/2);
			}else{
				errors.put(key, errors.get(key)/2);
			}			
		}
		
		buf = br.readLine();
		for(String s:buf.split(" ")){
			long num = Long.parseLong(s);
			errors.put(num, errors.getOrDefault(num, 0)+1);			
		}
		
		for(Long key : errors.keySet()){
			if(errors.get(key)%2 == 1){
				System.out.println(key);
				errors.put(key, (errors.get(key)-1)/2);
			}else{
				errors.put(key, errors.get(key)/2);
			}			
		}
	}

}
