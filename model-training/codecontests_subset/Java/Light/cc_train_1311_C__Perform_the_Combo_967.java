import java.util.*;

public class codeforce
{
	public static void main(String args[])
	{
		Scanner sj = new Scanner(System.in);
		int t = sj.nextInt();
		while(t-->0){
			int n = sj.nextInt();
			int m = sj.nextInt();
			String s = sj.next();
			int a[] = new int[m];
			for(int i=0;i<m;i++){
				a[i] = sj.nextInt();
			}
			Arrays.sort(a);
			int j = 0;
			int x[] = new int[26];
			for(int i=0;i<n;i++){
				char c = s.charAt(i);
				if(j<m && i+1<=a[j]){
					x[c-'a'] += (m+1-j);
				}else{
				    while(j<m && i+1>a[j]){
				        j++;    
				    }
					x[c-'a'] += (m+1-j);
				}
			}
			for(int i=0;i<26;i++){
				System.out.print(x[i]+" ");
			}
			System.out.println();
		}
	}
}