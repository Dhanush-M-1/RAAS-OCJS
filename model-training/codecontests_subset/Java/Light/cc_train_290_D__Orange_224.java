import java.util.*; //Scanner;
import java.io.PrintWriter; //PrintWriter

public class R176_AprilFool_D //Name: Orange
{
	public static void main(String[] args) {
		Scanner      in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		solve(in, out);
		out.close();
		in.close();	
	}
	
	public static void solve(Scanner in, PrintWriter out)
	{
		String s = in.next().toLowerCase();	
        String ns = "";
        int n = in.nextInt();
        for (char c : s.toCharArray())
        	if (c < n + 'a')
        		ns += (c+"").toUpperCase();
        	else
        		ns += c; //lower case
        
//        for (int i = 0; i < s.length(); i++)
//        {
//            int a = s.charAt(i);
//            if (a < n + 'a')
//                ns += (s.charAt(i)+"").toUpperCase();
//            else
//                ns += Character.toString(s.charAt(i)).toLowerCase(); 
//        }
		
		out.println(ns);		
	}
}
