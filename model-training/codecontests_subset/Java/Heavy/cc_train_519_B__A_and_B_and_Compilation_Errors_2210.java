import java.util.*;
public class Main {
    public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a = new int[n];
		int [] b = new int[n-1];
		int [] c = new int[n-2];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		for(int i=0;i<n-1;i++)
			b[i]=sc.nextInt();
		for(int i=0;i<n-2;i++)
			c[i]=sc.nextInt();
		int f = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		//first
		for(int i=0;i<n-1;i++){
			if(a[i]!=b[i]){
				f=a[i];
				break;
			}		
		}int w = 0;
		for(int i=0;i<n-2;i++){
			if(b[i]!=c[i]){
				w=b[i];
				break;
			}
		}
		if(f==0)
			System.out.println(a[a.length-1]);
		else System.out.println(f);
		if(w==0)
			System.out.println(b[b.length-1]);
		else System.out.println(w);
	}
}