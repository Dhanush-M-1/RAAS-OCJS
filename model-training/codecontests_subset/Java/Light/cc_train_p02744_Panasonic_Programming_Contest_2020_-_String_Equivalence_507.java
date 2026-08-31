
import java.util.*;
import java.lang.Math;

public class Main {
	static String a;
	static int ok=-1;
	public static void printans(int x,int y,char[] s) {
		if (x==y) {
			if (ok==2)
				System.out.println();
			ok=2;
			System.out.print(new String(s));
		}
		else {
			char max='a';
			for (int i=1;i<=x;i++) {
				if (max<s[i]) max=s[i];
			}
			for (int i='a';i<max+2;i++) {
				s[x+1]=(char)i;
				printans(x+1,y,s);
			}
		}
	}
		  public static void main(String[] args){
		    Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    char a[]=new char [n];
		    a[0]='a';
		    printans(0,n-1,a);
		  }
		}

