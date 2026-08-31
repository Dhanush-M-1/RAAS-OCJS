import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class Solution1 {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int n=in.nextInt();
	int m=in.nextInt();
	ArrayList<Long> arr=new ArrayList<>();
	for(int i=0;i<11;i++)
		arr.add((long)0);
	for(int i=0;i<n;i++){
		int h=in.nextInt();
		arr.set(h,arr.get(h)+1);
	}
	long total=0;
	for(int i=0;i<11;i++){
		if(i+1<11){
		for(int j=i+1;j<11;j++){
			total+=arr.get(i)*arr.get(j);
		}
		}
	}
	System.out.println(total);
}
}
