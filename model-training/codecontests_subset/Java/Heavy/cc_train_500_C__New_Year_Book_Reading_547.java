// package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class NewYearBookReading {
public static void main(String[] args) throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st= new StringTokenizer(in.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int[] weights = new int[n];
	int [] readings = new int[m];;
	st = new StringTokenizer(in.readLine());
	for (int i = 0; i < weights.length; i++) {
		weights[i] = Integer.parseInt(st.nextToken());
	}
	st = new StringTokenizer(in.readLine());
	for (int i = 0; i < readings.length; i++) {
		readings[i] = Integer.parseInt(st.nextToken());
	}
	HashSet<Integer> order = new HashSet<Integer>();
	int [] ordered = new int[n];
	int count = 0;
	for (int i = 0; i < readings.length; i++) {
		if(!order.contains(readings[i])) {
			order.add(readings[i]);
			ordered[count++]=readings[i];
		}
	}
	Stack<Integer> stack = new Stack<Integer>();
	for (int i = ordered.length-1; i>=0; i--) {
		stack.push(ordered[i]);
	}
	Stack<Integer> tmp = new Stack<Integer>();
	long total = 0;
	for (int i = 0; i < readings.length; i++) {
		while(stack.peek()!=readings[i]) {
			tmp.push(stack.pop());
			total+=weights[tmp.peek()-1];
		}
		stack.pop();
//		System.out.println(tmp.toString());
		while(!tmp.isEmpty()) {
			stack.push(tmp.pop());
		}
//		System.out.println(readings[i]+" "+total);
		stack.push(readings[i]);
//		System.out.println(stack.toString());
	}
	System.out.println(total);
}
}
