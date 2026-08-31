import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String input = r.readLine();
		int n = Integer.parseInt(input);
		input = r.readLine();
		
		StringBuffer result=new StringBuffer(""); 
		
		int i;
		
		for(i=0;i<n;){
			char c = input.charAt(i);
			if (c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u'&&c!='y'){
				i++;
				result.append(c);
				continue;
			}
			if (c=='o'||c=='e'){
				int occ=0;
				while(i<n){
					char p= input.charAt(i);
					if (p==c){
						occ++;
						i++;
					}else
						break;
				}
				if (occ==2)
					result.append(c).append(c);
				else
					result.append(c);
				
				continue;
			}
			if (c=='a'||c=='i'||c=='u'||c=='y'){
				while(i<n){
					char p= input.charAt(i);
					if (p==c){
						i++;
					}else
						break;
				}
					
				result.append(c);
					
			}
			
		}
		
		System.out.println(result);
	}

}
