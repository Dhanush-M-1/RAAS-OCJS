import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		String[] cpt = s.nextLine().split(" ");
		int a = Integer.parseInt(cpt[0]);
		int b = Integer.parseInt(cpt[1]);
		
		int[] aDiv = dividers(a);
		int[] bDiv = dividers(b);
		
		if (aDiv[3] != bDiv[3]) {
			System.out.println(-1);
		} else {
			int ans = 0;
			for (int i = 0; i < 3; i++) {
				ans += Math.abs(aDiv[i] - bDiv[i]);
			}
			System.out.println(ans);
		}
	}
	
	public static int[] dividers(int i) {
		int[] result = new int[4];
		
		while (true) {
			if (i % 2 == 0) {
				i /= 2;
				result[0]++;
			} else if (i % 3 == 0) {
				i /= 3;
				result[1]++;
			} else if (i % 5 == 0) {
				i /= 5;
				result[2]++;
			} else {
				break;
			}
		}
		
		result[3] = i;
		
		return result;
	}
}
