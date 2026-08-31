import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{
public static void main (String[] args){
	Scanner sc = new Scanner(System.in);
	int n = Integer.parseInt(sc.next());//段数
	int m = Integer.parseInt(sc.next());//破損数
	int[] a = new int[n+1];//破損配列all(01)
	long[] s = new long[n+1];//到達パターン
	boolean flag = true;//到達可能性
	
	for(int i = 0; i<n+1; i++){
		a[i] = 1;
	}
	if(m!=0){
		int b = 0;
		for(int i = 0; i<m; i++){
			b = Integer.parseInt(sc.next());
			if(a[b-1] != 0){
				a[b] = 0;
			}else{
				flag = false;
				System.out.println(0);
				break;
			}
		}
	}
	
	if(flag){
		s[0] = 1;
		s[1] = 1;
		if(n!=1){
			for(int i = 2; i < n+1; i++){
				s[i] += (s[i-1]*a[i-1] + s[i-2]*a[i-2])%1000000007;
			}
		}
	System.out.println(s[n]);
	}
	
	}
}