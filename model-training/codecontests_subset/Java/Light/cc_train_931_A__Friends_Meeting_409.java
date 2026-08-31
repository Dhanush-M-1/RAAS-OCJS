import java.io.*;
import java.util.*;
 
public class FriendsMeeting
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a, b, distance, tiredness;
		a = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		distance = Math.abs(a-b);
		
		a = distance/2;
		b = distance - distance/2;
		
		tiredness = (a*(a+1))/2 + (b*(b+1))/2;
		
		System.out.println(tiredness);
		
	}
}