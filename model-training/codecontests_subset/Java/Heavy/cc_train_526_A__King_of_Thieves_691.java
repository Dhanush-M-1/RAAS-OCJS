import java.io.*;
import java.util.*;

public class A {
	public static void main (String[]args)throws IOException{
		BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(x.readLine());
		String s=x.readLine();
		boolean[]level=new boolean[n];
		for (int i=0; i<n; i++){
			if (s.charAt(i)=='*')level[i]=true;
		}
		for (int i=1; i<n; i++){
			for (int j=0; j<i; j++){
				int count=0;
				for (int k=j; k<n; k+=i){
					if (level[k]){count++;}
					else{count=0;}
					if (count==5){
						System.out.println("yes");
						System.exit(0);
					}
				}
			}
		}
		System.out.println("no");
		System.exit(0);
	}
}