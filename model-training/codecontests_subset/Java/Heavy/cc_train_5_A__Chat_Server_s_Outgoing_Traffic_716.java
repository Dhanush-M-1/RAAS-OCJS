import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class ChatServerTraffic {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String line="Z";
		int res=0;
		HashSet<String> h=new HashSet<String>();
		while((line=r.readLine())!=null){
			if(line.startsWith("+")){
				h.add(line.substring(1));
			}
			else if(line.startsWith("-")){
				h.remove(line.substring(1));
			}
			else {
				line+=" ";
				String[] sp=line.split(":");
				res+=(sp[1].length()-1)*h.size();
			}
		
		}
		System.out.println(res);
	}

}
