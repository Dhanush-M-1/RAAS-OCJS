import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int count=0;
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			int state=0;
			int a=sc.nextInt();
			for(int j=2;j<=Math.sqrt(a);j++){
				if(a%j==0){
					state=1;
					break;
				}
			}
			if(state==0){
				//System.out.println(a);
				count++;
			}
		}
		System.out.println(count);
	}
}