
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner cin=new Scanner(System.in);
		
		while(true) {
			int H=cin.nextInt(),W=cin.nextInt();
			if(H==0 && W==0)break;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if((i%2==0 && j%2==0) || (i%2==1 && j%2==1))System.out.print('#');
					else System.out.print('.');
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}

	}

}

