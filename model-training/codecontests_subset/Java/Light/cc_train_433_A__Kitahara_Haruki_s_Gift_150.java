import java.io.*;
public class Ladder69 {

	public static void main(String[] args)throws IOException {
		BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(ob.readLine());
		int a[]=new int[n];
		String s[]=ob.readLine().split(" ");
		int sum=0,s1=0,s2=0;
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(s[i]);
			sum=sum+a[i];
			if(a[i]==100)
				s1++;
			else if(a[i]==200)
				s2++;
		}
		if(sum%200!=0) {
			System.out.println("NO");
			return;
		}
		if(s2%2==0 && s1%2==0)
			System.out.println("YES");
		else if(s2%2==1 && s1%2==0 && s1!=0)
			System.out.println("YES");
		else 
			System.out.println("NO");
	}

}
