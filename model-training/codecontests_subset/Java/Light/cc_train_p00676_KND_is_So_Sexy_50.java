import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Double> ansList = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		while(true){
		if(sc.hasNext()==false) {
			break;
		}

		double a = sc.nextInt();
		double l = sc.nextInt();
		double x = sc.nextInt();

		ansList.add(Math.sqrt(l*l-a*a*0.25)*a*0.5+l*Math.sqrt((l+x)*(l+x)*0.25-l*l*0.25));
		}
		for(int i=0;i<ansList.size();i++) {
		System.out.println(ansList.get(i));
		}
		sc.close();
		}


}
