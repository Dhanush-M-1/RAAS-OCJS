import java.util.*;
import java.io.*;

public class SolB {
	
	public static int bit(int i) {
		return (1 << i);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		out.write("? 0 0\n");
		out.flush();
		StringTokenizer tok = new StringTokenizer(in.readLine());
		int tie = Integer.parseInt(tok.nextToken());
		
		int a = 0;
		int b = 0;
		
		for(int bb = 29; bb >= 0; bb--) {
			out.write("? " + (bit(bb) | a) + " " + b + "\n");
			out.flush();
			tok = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(tok.nextToken());
			out.write("? " + a + " " + (bit(bb) | b) + "\n");
			out.flush();
			tok = new StringTokenizer(in.readLine());
			int n2 = Integer.parseInt(tok.nextToken());
			int diff = n1 - n2;
			if(diff == 2) {
				// both are not set
				//System.out.println("Setting neither a and b");
				continue;
			} else if (diff == -2) {
				// both are set
				a |= bit(bb);
				b |= bit(bb);
				//System.out.println("Setting both a and b");
			} else {
				if(tie == 1) {
					//a was set
					a |= bit(bb);
				} else {
					//b was set
					b |= bit(bb);
				}
				tie = n1;
			}
		}
		out.write("! " + a + " " + b + "\n");
		out.flush();
	}
}