//package testpackage;
	
	import java.util.Arrays;
import java.util.Scanner;
	
	public class Test {
		
		public static void main(String[] args) throws Exception {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			int s = 1;
			int ss=2;
			int l = 3;
			
			for(int i=0;i<n;i++){
				if((a[i]==s)){
					int t= l;
					l = ss;
					ss = t;
				}
				else if(a[i] == ss){
					int t= l;
					l = s;
					s = t;
				}
				else{
					System.out.println("NO");
					System.exit(0);
				}
			}
			System.out.println("YES");
		}
	
	}