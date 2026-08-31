import java.util.Scanner;

public class FriendsMeeting {
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		System.out.println(findFriendsMeeting(x1, x2));
		sc.close();
	}
	
	public static int findFriendsMeeting(int x1, int x2) {
		int count = 0;
		int index = 1;
		int temp = 0;
		if (x1 > x2) {
			temp = x2;
			x2 = x1;
			x1 = temp;
		} 
		while (x1 < x2 - 1) {
			x1++;
			x2--;
			count = count + (index * 2);
			index++;
		}
		if (x1 != x2)
			count = count + index;
		return count;
	}

}
