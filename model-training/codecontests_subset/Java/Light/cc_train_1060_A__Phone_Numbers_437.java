/* 
Problem Name: Phone Numbers
URL: http://codeforces.com/problemset/problem/1060/A
*/

import java.util.Scanner;

public class Phone_Numbers{
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String enter = sc.nextLine();

		String s1 = sc.nextLine();

		int len = s1.length();

		int count = len/11;

		int sum = 0;

		for(int i = 0;i<len;i++){

			if(s1.charAt(i)=='8'){
				sum++;
			}

		}
		if(sum>=count){
			System.out.println(count);
		}else{
			System.out.println(sum);
		}


	}
}