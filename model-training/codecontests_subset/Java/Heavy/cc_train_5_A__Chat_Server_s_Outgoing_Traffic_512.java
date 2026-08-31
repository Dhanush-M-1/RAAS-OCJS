import java.util.HashSet;
import java.util.Scanner;

public class CF5AChatServer {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashSet<String> hs= new HashSet<>();
		long c =0;
		while(s.hasNextLine()) {
			try {
				String x = s.nextLine();
				
				if(x.contains(":")) {
					String[] val = x.split(":");
					for (int i = 1; i < val.length; i++) {
						c+=val[i].length()*hs.size();
					}
					
				}else {
					if(x.charAt(0)=='+') {
						hs.add(x.substring(1,x.length()));
					}else {
						hs.remove(x.substring(1,x.length()));
					}
				}
			}catch(Exception e) {
				s.close();
				break;
			}
			
		}
		System.out.println(c);
	}

}
