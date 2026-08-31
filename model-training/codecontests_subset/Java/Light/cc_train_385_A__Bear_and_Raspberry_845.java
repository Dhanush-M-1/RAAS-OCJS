import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),pr=sc.nextInt(),max=-1,index=-1;
		sc.nextLine();
		ArrayList<Integer> list = new ArrayList<Integer>(n);
		for(int i =0;i<n;i++){
			list.add(sc.nextInt());
		}
		for(int i =0;i<list.size()-1;i++){
			if( list.get(i)-list.get(i+1)>max){
				max=list.get(i)-list.get(i+1);
				index = i+1;
			}
		}
		System.out.println((max-pr>=0)?max-pr:0);
		
	}
}
