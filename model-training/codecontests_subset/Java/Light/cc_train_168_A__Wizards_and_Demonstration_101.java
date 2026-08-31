import java.io.*;

public class wizard{
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s[] = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int x = Integer.parseInt(s[1]);
		double y = Double.parseDouble(s[2])/100;
		
		double t = n*y;
		int r = (int) Math.floor(t);
		if(t%1!=0)r++;
		
		int z=r-x;

		if(z>0)System.out.println(z);
		else System.out.println(0);
		
		

	}
}