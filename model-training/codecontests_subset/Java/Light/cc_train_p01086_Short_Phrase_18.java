import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args){
		solve();
	}

	public static void solve(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0){
				break;
			}
			String[] s = new String[n];
			for(int i=0;i<n;i++){
				s[i] = sc.next();
			}
			boolean[] judge = new boolean[n];
			Arrays.fill(judge,true);
			int[] num = {5,7,5,7,7,99};
			int now = 0;
			int counter = 0;
			int numi = 0;
			int x = 0;
			while(true){
				now = x;
				for(int i=x;i<n;i++){
					counter += s[i].length();
					//System.out.println(i+" "+counter+" "+numi);
					if(counter == num[numi]){
					now = i+1;
					numi++;
					counter = 0;
					}
					else if(counter>num[numi]){
						break;
					}
					if(numi>4){
						for(int j=i+1;j<n;j++){
							judge[j] = false;
						}
						break;
					}
				}
				if(numi>4){
					break;
				}
				counter = 0;
				numi = 0;
				Arrays.fill(judge,true);
				x++;
				for(int i=0;i<x;i++){
					judge[i] = false;
				}
			}
			for(int i=0;i<n;i++){
				if(judge[i]){
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}