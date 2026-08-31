import java.io.*;
import java.util.*;
public class FriendsMeeting {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int dif = Math.abs(a-b);
		int mid = dif/2;
		int res = 0;
		res = (mid)*(mid+1)/2;
		res = res*2;
		if(dif%2!=0){
			res+= mid+1;
		}
		System.out.println(res);
	}

}
