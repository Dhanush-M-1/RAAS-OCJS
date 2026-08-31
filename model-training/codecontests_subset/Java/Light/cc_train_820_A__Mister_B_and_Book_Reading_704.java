import java.io.*;
import java.util.*;

public class A421 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int target = Integer.parseInt(s[0]);
		int start  = Integer.parseInt(s[1]);
		int limit = Integer.parseInt(s[2]);
		int acc = Integer.parseInt(s[3]);
		int l = Integer.parseInt(s[4]);
		int day=1;
		target=target-start;
		int i=1;
		while(target>0){
			int sub=0;
			if(i*acc + start > limit){
				sub=limit;
			}
			else{
				sub= start +i*acc;
			}
			
			target = target - (sub -l);
			i++;
			day++;
		}
		System.out.println(day);
	}

}
