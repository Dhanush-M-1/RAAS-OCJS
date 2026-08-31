
import java.util.*;
public final class goBaby {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int v0 =sc.nextInt();
		int v1 = sc.nextInt();
		int a = sc.nextInt();
		int l = sc.nextInt();
		int count=1;
		int speed= v0;
		int i = a;
		int read = v0;
		c-=v0;
		while(c>0){
			speed = speed+i;
			if(speed>v1){
				speed = v1;
			}
			if(read>=l){
				c+=l;
			}
			else{
				c+=read;
			}
			c-=speed;
			count++;
		}
		System.out.println(count);
	}
}
