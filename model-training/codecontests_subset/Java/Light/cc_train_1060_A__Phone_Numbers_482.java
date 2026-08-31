import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String str = sc.next();
		int numof8 = 0;
		int count = 0;
		for(int i=0;i<str.length();i++){
		    int temp = Integer.parseInt(String.valueOf(str.charAt(i)));
		    if(temp == 8) numof8++;
		    count++;
		}
		//System.out.println("numof8 : " + numof8 + " count :" + count);
		if(numof8 == 0){
		    System.out.println(0);
		    return;
		}
		count /= 11;
		int res = Math.min(count, numof8);
		System.out.println(res);
	}
}
