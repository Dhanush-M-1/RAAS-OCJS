import java.util.*;
public class divid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int y = in.nextInt();
		for(int i = 0; i < y ; i++) {
			int x = in.nextInt();
			int z = 0;
			while(true) {
				if(x==1) {System.out.println(z);
				break;
				}
				if(x%6 ==0) {
					z++;
					x/=6;
					if(x==1) {
						System.out.println(z);
						break;
					}
				}
				else {
					x*=2;
					z++;
					if(x%6!=0) {
						System.out.println(-1);
						break;
					}
				}
			}
		}
		in.close();
	}

}
