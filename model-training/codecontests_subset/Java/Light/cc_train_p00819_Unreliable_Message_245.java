import java.util.*;

public class Main {
	char[] a;
	int n;
	
	void J(){
		char b = a[n-1];
		for(int i=n-1;i>0;i--) a[i] = a[i-1];
		a[0] = b;
	}
	
	void C(){
		char b = a[0];
		for(int i=0;i<n-1;i++) a[i] = a[i+1];
		a[n-1] = b;
	}
	
	void E(){
		char[] b = new char[n];
		int s = n/2;
		int t = n%2;
		for(int i=0;i<s;i++) b[i] = a[s+t+i];	
		for(int i=0;i<s;i++) b[s+t+i] = a[i];
		if(t==1) b[s] = a[s];
		a = b.clone();
	}
	
	void A(){
		char[] b = new char[n];
		for(int i=0;i<n;i++) b[i] = a[n-1-i];
		a = b.clone();
	}
	
	void P(){
		for(int i=0;i<n;i++){
			if(a[i]=='0') a[i] = '9';
			else if(a[i]>=49 && a[i]<=57) a[i]--;
		}
	}
	
	void M(){
		for(int i=0;i<n;i++){
			if(a[i]=='9') a[i] = '0';
			else if(a[i]>=48 && a[i]<=56) a[i]++;
		}
	}
	
	void solve(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int m = sc.nextInt();
			for(int i=0;i<m;i++){
				char[] c = sc.next().toCharArray();
				a = sc.next().toCharArray();
				n = a.length;
				for(int j=c.length-1;j>=0;j--){
					if(c[j]=='J') J();
					else if(c[j]=='C') C();
					else if(c[j]=='E') E();
					else if(c[j]=='A') A();
					else if(c[j]=='P') P();	
					else M();
				}
				for(int j=0;j<n;j++) System.out.print(a[j]);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();	
	}	
}