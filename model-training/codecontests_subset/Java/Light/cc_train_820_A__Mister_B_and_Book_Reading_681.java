import java.util.*;
public class a {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int a = sc.nextInt();
		int l = sc.nextInt();
		int count =1;
		int d=0;
		d+=x;
		
		while(d<c){
			count++;
			if(x+a>y)
				x=y;
			else
				x+=a;
			d=d-l>0?d-l:0;
			d+=x;
			
		}
		
		System.out.println(count);
		
	}

}
