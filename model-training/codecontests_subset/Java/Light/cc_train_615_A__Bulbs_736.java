import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BtpCode {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		Set<Integer> set=new HashSet<Integer>();
		for(int i=0;i<n;i++)
		{
			int x=sc.nextInt();
			for(int j=1;j<=x;j++){
				set.add(sc.nextInt());
			}
		}
		boolean flag=true;
		for(int i=1;i<=m;i++){
			if(!set.contains(i)){
				System.out.println("NO");
				flag=false;
				break;
			}
		}
		if(flag==true){
			System.out.println("YES");
		}
		sc.close();
	}

}