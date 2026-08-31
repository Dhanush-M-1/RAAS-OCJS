import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=in.nextInt(),CA[][]=new int[4][14];
		for(int i=0;i<n;i++) {
			String s=in.next();int nm=in.nextInt();
			if(s.equals("S"))CA[0][nm]=1;
			else if(s.equals("H"))CA[1][nm]=1;
			else if(s.equals("C"))CA[2][nm]=1;
			else if(s.equals("D"))CA[3][nm]=1;
		}
		
		char simb[]= {'S','H','C','D'};
		for(int i=0;i<4;i++) {
			for(int j=1;j<=13;j++) {
				if(CA[i][j]==0)out.println(simb[i]+" "+j);
			}
		}
		out.flush();
	}

}

