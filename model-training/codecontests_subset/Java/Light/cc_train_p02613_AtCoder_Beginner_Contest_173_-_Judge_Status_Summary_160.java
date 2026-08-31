import java.util.*;
import java.io.*;
class Main{
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out, true);
		int t = Integer.parseInt(in.nextLine());
		int count_1 = 0;
		int count_2 = 0;
		int count_3 = 0;
		int count_4 = 0;
		for(int i=0;i<t;i++){
			String str = in.nextLine();
			if(str.equals("AC"))
				count_1++;
			else if(str.equals("WA"))
				count_2++;
			else if(str.equals("TLE"))
				count_3++;
			else
				count_4++;
		}
		out.println("AC x " + count_1);
		out.println("WA x " + count_2);
		out.println("TLE x " + count_3);
		out.println("RE x " + count_4);
	}
}	
