import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class C {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int l = 0, r = 0;
		int j = line.length();
		int mindiff = 0, maxdiff = 0;
		boolean f = true;
		
		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '#')
				indices.add(i);
		}
		if (indices.size() > 0) j = indices.get(indices.size()-1);
		
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '(') l++;
			else if (c == ')') r++;
			else r++;
			
			if (r > l) {
				f = false;
				break;
			}
			if (i == j) {
				mindiff = l-r;
			}
			if (i > j) {
				if (l-r < mindiff) mindiff = l-r;
			}
		}
		if (!f || mindiff != l-r) System.out.println(-1);
		else {
			for (int i = 0; i < indices.size(); i++) {
				if (i < indices.size()-1) System.out.println(1);
				else System.out.println(mindiff+1);
			}
		}
	}
}
