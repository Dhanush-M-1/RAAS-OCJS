import java.util.Scanner;

public class Main {
	static int check(int [] letters,int start,int type) {
		int len = 0;
		for(int i=start;i<letters.length && len<type;i++) {
			len += letters[i];
			if(len == type) {
				return i+1;
			}
		}
		return -1;
	}
	
	static boolean tanku(int [] letters, int start) {
		int [] ku = {5,7,5,7,7};
		for(int type:ku) {
			start = check(letters,start,type);
			if(start==-1) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			String [] words = new String[n];
			int [] letters = new int[n];
			for(int i=0;i<n;i++) {
				words[i] = sc.next();
				letters[i] = words[i].length();
			}
			int flag=0;
			for(int i=0;i<n && flag==0;i++) {
				if(tanku(letters,i)) {
					System.out.println(i+1);
					flag=-1;
					break;
				}
			}
		}

	}
}

