import java.util.Scanner;

public class Solve {
	public static void main(String args[])
    {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int[] s1=new int[n];
		int[] s2=new int[n];
		for(int i=0;i<n;i++) {
			s1[i]=sc.nextInt();
			s2[i]=sc.nextInt();
		}
		int c=0;
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				if(s1[i]==s2[j])
					c++;
			
		
		System.out.println(c);
		sc.close();
    }
}