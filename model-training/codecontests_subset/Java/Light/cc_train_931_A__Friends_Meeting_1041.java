import java.util.*;
public class FriendsMeeting {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=Math.max(a, b)-Math.min(a, b);
		int sum=0;
		if(c%2==0) {
			for(int i=1;i<=c/2;i++) {
				sum+=i;
			}
			System.out.println(sum*2);
		}
		else {
			for(int i=1;i<=(c/2)+1;i++) {
				sum+=i;
			}
			for(int i=1;i<=c/2;i++) {
				sum+=i;
			}
			System.out.println(sum);
		}
	}

}
