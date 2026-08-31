import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;



public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int size = 0;
		HashMap<String, Boolean>hm = new HashMap<>();
		while((line=in.readLine())!=null){
		//for(int i = 0; i < 7; ++i){
			//line = in.readLine();
			if(line.charAt(0)=='+'){
				StringBuilder sb = new StringBuilder(line);
				sb.deleteCharAt(0);
				hm.put(sb.toString(),true);
			}
			else if(line.charAt(0)=='-'){
				StringBuilder sb = new StringBuilder(line);
				sb.deleteCharAt(0);
				hm.remove(sb.toString());
			}
			else{
				int index = line.indexOf(":");
				size += hm.size()*(line.length()-index-1);
			}
		}
		System.out.println(size);
		in.close();
		}
};