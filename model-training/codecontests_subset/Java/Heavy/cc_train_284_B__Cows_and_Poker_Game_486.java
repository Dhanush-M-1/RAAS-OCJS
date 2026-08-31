import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int Acount=0;
		int Icount=0;
		String str=br.readLine();
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c=='A')
				Acount++;
			if(c=='I')
				Icount++;
		}
		if(Icount==0)
			System.out.println(Acount);
		else if(Icount==1)
			System.out.println(Icount);
		else
			System.out.println(0);
		br.close();
	}// end of main(String[])
	
}// end of class Main