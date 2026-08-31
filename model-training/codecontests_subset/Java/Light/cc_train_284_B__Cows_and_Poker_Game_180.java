
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PokerGame {

public static void main(String[] args) throws Exception {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(br.readLine());
	String help = br.readLine();
	  br.close();
	  int i = 0;
	  int a = 0;

	for(int j=0;j<n;j++){
		if(help.charAt(j)=='I')
			i++;
		else if(help.charAt(j)=='A')
			a++;
	}
	if(i==1)
		System.out.println(i);
	else if(a>0 && i==0)
		System.out.println(a);
	else
		System.out.println(0);
}
}
