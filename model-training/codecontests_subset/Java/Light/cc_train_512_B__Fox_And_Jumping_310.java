// package Div2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Sketch {
	public static int gcd(int a, int b){
		if(a==0)
			return b;
		if(b==0)
			return a;
		if(a>b)
			return gcd(a%b, b);
		else 
			return gcd(a, b%a);
	}
		
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] lens = new int[n];
		int[] costs = new int[n];
		for(int i=0; i<n; i++){
			lens[i] = input.nextInt();			
		}
		for(int i=0; i<n; i++){
			costs[i] = input.nextInt();
		}
		input.close();
		
		List<Integer> list = new LinkedList<Integer>();
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++){
			list.add(lens[i]);
			if(!table.containsKey(lens[i])){
				table.put(lens[i], costs[i]);
			}
			else {
				if(table.get(lens[i]) > costs[i]){
					table.put(lens[i], costs[i]);
				}
			}
		}
		
		while(list.size() != 0){
			int item = list.get(0);
			list.remove(0);
			int cst = table.get(item);
			for(int i=0; i<n; i++){
				int tmp = gcd(item, lens[i]);
				if(tmp < item){
					if(!table.containsKey(tmp)){
						table.put(tmp, cst + costs[i]);
						list.add(tmp);
					}
					else {
						if(table.get(tmp) > cst + costs[i]){
							table.put(tmp, cst + costs[i]);
							list.add(tmp);
						}
					}
				}
			}
		}
		
		if(!table.containsKey(1)){
			System.out.println(-1);
		}
		else 
			System.out.println(table.get(1));
	}
}
