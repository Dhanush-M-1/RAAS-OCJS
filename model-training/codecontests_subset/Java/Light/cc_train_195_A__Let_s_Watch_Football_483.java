//package problems;

import java.util.Scanner;

public class Lets_Watch_game {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String [] st = scn.nextLine().split(" ");
		int [] i_str = new int[st.length];
		for(int i=0;i<i_str.length;i++) {
			i_str[i]=Integer.parseInt(st[i]);
		}
		int a= i_str[0],b=i_str[1],c=i_str[2];
		
		int i=0 ;
		int x=a*c;
		while(x>((i*b)+(b*c))) {
			i++;
		}
		System.out.println(i);
		
	}

}
