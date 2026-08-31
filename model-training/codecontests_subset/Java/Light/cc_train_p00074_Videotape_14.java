import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		while(true) {
			int h = stdIn.nextInt();
			int m = stdIn.nextInt();
			int s = stdIn.nextInt();
			if(h == -1 && m == -1 && s == -1) break;
			s += h*3600+ m*60;
			
			int a = 3600*2 - s;
			int b = a*3;
			
			int ah = a/3600;
			int bh = b/3600;
			a %= 3600;
			b %= 3600;
			
			int am = a/60;
			int bm = b/60;
			a %= 60;
			b %= 60;
			int as = a;
			int bs = b;
			System.out.printf("%02d:%02d:%02d\n",ah,am,as);
			System.out.printf("%02d:%02d:%02d\n",bh,bm,bs);
		}
	}
}