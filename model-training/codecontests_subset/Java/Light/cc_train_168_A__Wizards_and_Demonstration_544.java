//package codeChef;

import java.util.Scanner;

import java.lang.Math;

public class Codechef7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		double n = sc.nextDouble();
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double a = y/100;
		a = a*n;
		if(x>a)
			System.out.println("0");
		else
		{
		a = a - x;
		a = Math.ceil(a);
		System.out.println((int)a);
		}
		
}

}
