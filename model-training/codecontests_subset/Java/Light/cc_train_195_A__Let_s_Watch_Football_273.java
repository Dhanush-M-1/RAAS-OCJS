import java.util.Scanner;


public class ALetWatchFootball {
//http://codeforces.com/problemset/problem/195/A
	public static void main(String[] args) {
		Scanner scaner = new Scanner (System.in);
		int a = scaner.nextInt();
		int b = scaner.nextInt();
		int l = scaner.nextInt();
		int t=a*l;
		int tiempovisto=b-1;
		int videoPorDescarga =b;
		int espera=((t+tiempovisto)/videoPorDescarga)-l;
		System.out.println(espera);
		
		


	}

}
