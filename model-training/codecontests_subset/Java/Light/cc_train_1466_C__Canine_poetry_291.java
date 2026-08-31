import java.util.*;
import java.lang.*;
import java.io.*;
public class problems {
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0) {
			String s=sc.next();
			solve(s);
			t--;
		}
	}
	static void solve(String s) {
		if(s.length()==1) {
			System.out.println(0);
		}else {
			char ch[]=s.toCharArray();
			int count=0;
			for(int i=1;i<ch.length;i++) {
				if(ch[i-1]!='1' && ch[i]==ch[i-1]) {
					ch[i]='1';
					count++;
				}if(i-2>=0 && ch[i-2]!='1' && ch[i-2]==ch[i]) {
					ch[i]='1';
					count++;
				}
			}
			System.out.println(count);
		}
	}
	static void sieve(ArrayList<Integer> a,int n) {
		int aa[]=new int[n+1];
		aa[0]=aa[1]=0;
		for(int i=2;i<=n;i++) {
			if(i!=2 && i%2==0) {
				aa[i]=0;
			}else {
				aa[i]=1;
			}
		}
		for(int i=3;i*i<=n;i++) {
			if(aa[i]==1) {
				for(int j=i*i;j<=n;j+=i) {
					aa[j]=0;
				}
			}
		}
		a.add(2);
		for(int i=3;i<=n;i+=2) {
			if(aa[i]==1) {
			a.add(i);
			}
		}
	}
	static int upperBound(Vector<Integer> v,int n) {
		int s=0;int e=v.size()-1;
		int ans=-1;
		while(s<=e) {
			int mid=s+(e-s)/2;
			if(v.get(mid)==n) {
				return mid;
			}else if(v.get(mid)>n) {
				e=mid-1;
			}else{
				ans=mid;
				s=mid+1;
			}
		}
		return ans;
	}
}