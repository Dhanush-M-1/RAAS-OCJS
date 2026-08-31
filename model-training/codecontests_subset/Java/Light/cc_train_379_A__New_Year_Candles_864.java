import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner snr=new Scanner(System.in);
        int a=snr.nextInt();
        int b=snr.nextInt();
        int ans=0,cnt=0;
        while(a > 0){
			cnt+= a;
			ans += a%b;
			a = a/b;
			if(ans >= b){
				a+=1;
				ans -= b;
			}
		}
        System.out.println(cnt);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}