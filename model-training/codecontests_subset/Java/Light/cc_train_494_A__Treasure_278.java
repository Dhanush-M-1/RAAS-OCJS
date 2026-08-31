// package Div2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Sketch {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String str = input.next();
		input.close();
		
		int[] counts = new int[str.length()];
		int count = 0;
		int last = -1;
		for(int i=0; i<str.length(); i++){
			switch(str.charAt(i)){
			case '(':
				count++;
				counts[i] = 1; break;
			case '#':
				count--;
				counts[i] = -1; last = i; break;
			case ')':
				count--;
				counts[i] = -1; break;
			}
		}
		counts[last] -= count;
		if(counts[last] >= 0){
			System.out.println(-1);
			return;
		}
		
		int sum = 0;
		for(int i=0; i<str.length(); i++){
			sum += counts[i];
			if(sum < 0){
				System.out.println(-1);
				return;
			}
		}
		
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == '#'){
				System.out.println(-counts[i]);
			}
		}
	}
}
