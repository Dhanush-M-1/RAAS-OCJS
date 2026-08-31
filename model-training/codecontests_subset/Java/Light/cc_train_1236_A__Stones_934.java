
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner in =new Scanner(System.in);
			int k=in.nextInt();
			for(int i=0;i<k;i++) {
				int a=in.nextInt();int b=in.nextInt();int c=in.nextInt();
				int t=c/2;
				int count=0;
				if(b<t) {
					System.out.println(b*3);
				}else {
					int bb=b-t;
					count=t*3;
		//			System.out.println(bb+ " "+count);
					if(bb/2<=a) {
						count+=(bb/2)*3;
						System.out.println(count);
					}else {
						count+=a*3;
						System.out.println(count);
					}
				}
			}
	}

}
