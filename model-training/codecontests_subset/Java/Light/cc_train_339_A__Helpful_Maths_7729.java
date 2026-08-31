import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HelpfulMaths {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r =
                new BufferedReader(new InputStreamReader(System.in));
		
		String n=r.readLine();
		String[] tab=n.split("\\+");
Arrays.sort(tab);
String res="";
for (int i = 0; i < tab.length-1; i++) {
	res+=tab[i]+"+";
}
res+=tab[tab.length-1];
System.out.print(res);;
	}

}
