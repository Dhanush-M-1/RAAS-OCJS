import java.util.*;

public class friendsMeeting
{
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int a = in.nextInt();
	int b = in.nextInt();
	int c = Math.max(a, b) - Math.min(a, b);
	int d = c/2;
	int f = c - d;
	
	int x = (d * (d + 1))/2;
	int y = (f * (f+1))/2;
	System.out.println(x + y);
    }
}
