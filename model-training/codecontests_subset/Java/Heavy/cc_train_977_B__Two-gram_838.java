

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Problematique_DeuxGrammes {

	public static void main(String args[]) {
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		String s=scanner.next();
		int max=0;
		String gramme="",g;
		ArrayList<String> liste=new ArrayList<String>();
		
		for(int i=0;i<n-1;i++) {
			liste.add(s.substring(i, i+2));
		}
		g=liste.get(0);
		for(int i=0;i<n-1;i++) {
			String l=liste.get(i);
			int c=0;
			for(int j=i+1;j<n-1;j++) {
				if(liste.get(j).equals(l)) {
					c++;
					gramme=l;
				}
			}
			if(c>max) {
				max=c;
				 g=gramme;
			}
		}
		System.out.println(g);
	}
}
