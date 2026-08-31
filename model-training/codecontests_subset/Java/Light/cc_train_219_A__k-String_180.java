import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int n=Integer.parseInt(in.readLine());
		String s=in.readLine();
		if(s.length()%n!=0)
			out.println("-1");
		else{
			int[] symb=new int[256];
			for(int i=0; i<s.length(); i++){
				symb[s.charAt(i)]++;
			}
			StringBuilder subStringBuilder=new StringBuilder();
			boolean check=true;
			for(int i='a'; i<='z'; i++){
				if(symb[i]%n!=0){
					check=false;
					break;
				}
				for(int j=0; j<symb[i]/n; j++)
					subStringBuilder.append((char)i);
			}
			if(check){
				for(int i=0; i<n; i++){
					out.print(subStringBuilder.toString());
				}
			}
			else{
				out.println("-1");
			}
		}
		out.close();
	}
}
