import java.util.Scanner;
//671A

public class Main {
	public static void main(String []args){
		Scanner s=new Scanner(System.in);
		long ans=0,n,m,temp,j=1;
		n=s.nextLong();
		m=s.nextLong();
		for(long i=0;ans<m;i++){
		//	temp=s.nextLong();
			if(ans+j>=m)
			{
				j=m-ans;
				break;
			}
			ans+=j;
			j++;
		}
		//System.out.println(j);
		while(j-->0)
			ans=s.nextLong();
		
		System.out.println(ans);
	}
}
