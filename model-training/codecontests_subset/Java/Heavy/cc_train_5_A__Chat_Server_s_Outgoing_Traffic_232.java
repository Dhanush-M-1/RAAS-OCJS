import java.io.*;
import java.util.HashSet;

public final class task5A{

	public static void main(String[] args){
		HashSet<String> users = new HashSet<>();

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = 0;
			String line = "";
			while((line = br.readLine()) != null) {
				if(line.equals("stop")) break;
				if(line.charAt(0) == '+'){
					users.add(line.substring(1));
				}		
				else if(line.charAt(0) == '-'){
					users.remove(line.substring(1));
				}	
				else{
					String[] p = line.split(":");
					if(p.length > 1){
						n += p[1].length() * users.size();
					}
				}	
			}

			System.out.println(n);

		}
		catch(Exception e){
		}

	}

}