import java.util.*;

import java.lang.*;

import java.math.*;



public class Main {

	Scanner sc = new Scanner(System.in);

	void run(){

		int diag = 0;

		int rect = 0;

		for(;sc.hasNextLine();){

			String buffer = sc.nextLine();

			Scanner scl = new Scanner(buffer.replace(',', ' '));

			int a = scl.nextInt();

			int b = scl.nextInt();

			int c = scl.nextInt();

			if(a == b){

				diag++;

			}

			if(c*c == a*a+b*b){

				rect++;

			}

		}

		System.out.println(rect);

		System.out.println(diag);

	}

	public static void main(String[] args){

		Main m = new Main();

		m.run();

		

	}

}