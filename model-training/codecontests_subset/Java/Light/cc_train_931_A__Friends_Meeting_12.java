import java.util.*;
public class FriendsMeeting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int meetingPoint = (a+b)/2; 
		int A = 0;
		int B = 0;
		for(int i = 1; i <= Math.abs(meetingPoint - a); i++) {
			A+=i;
		}
		for(int i = 1; i <= Math.abs(meetingPoint - b); i++) {
			B+=i;
		}
		System.out.println(A+B);
		
	}

}
