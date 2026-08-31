import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeanuReeves {

	public static void main(String[] args) throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(r);
		String n=br.readLine();
		String s=br.readLine();
		String losung="";
		char[] l=s.toCharArray();
		
		if(anzahl(l)) {
			System.out.println(1);
			System.out.println(s);
		}
		else {
			for(int i=1;i<l.length;i++) {losung+=l[i];}
			System.out.println(2);
			System.out.println(l[0]);
			System.out.println(losung);			
		}

	}
	public static boolean anzahl(char[] l) {
		int count=0;
		for(int i=0;i<l.length;i++) {
			
			if(l[i]=='1') {count++;}
			else count--;
		}
		if(count!=0)return true;
		else return false;
				
	}

}
