import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.lang.Math;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine(), f = "";
		ArrayList<String> twoGrams = new ArrayList<String>();
		int maximum = 0;
		for(int i = 0; i < t - 1; i++) {
			int count = 1;
			String current = s.substring(i, i+2);
			boolean used = false;
			for(int j = 0; j<twoGrams.size(); j++)
				if(current.equals(twoGrams.get(j)))
					used = true;
			if(!used)
				for(int j = i+1; j<t-1;j++)
					if(current.contentEquals(s.substring(j, j+2)))
						count++;
			if(maximum < count) {
				maximum = count;
				f = current;
			}
		}
		System.out.println(f);
		sc.close();
	}
}