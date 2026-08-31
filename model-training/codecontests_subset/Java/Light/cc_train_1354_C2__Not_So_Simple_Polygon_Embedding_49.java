
import java.text.DecimalFormat;
import java.util.Scanner;

public class C2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t--!=0){
			int n=s.nextInt();
			double ans=(Math.cos((Math.PI)/(4*n))/Math.sin((Math.PI)/(2*n)));
			DecimalFormat df=new DecimalFormat("#.#########");
			String a=df.format(ans);
			System.out.println(a);
		}
	}

}
