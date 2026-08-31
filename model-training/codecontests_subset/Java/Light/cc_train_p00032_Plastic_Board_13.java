import java.util.*;
public class Main {

	//直角三角形かどうかを返す関数
	private boolean isRightTri(double a, double b, double c){
		final double EPS = 1.0e-08;
		double sum = Math.pow(a, 2) + Math.pow(b, 2);
		sum = Math.sqrt(sum);
		if(Math.abs(sum - c) < EPS)
			return true;
		else
			return false;
	}

	private boolean isLoz(int len1, int len2, int dia){
		if(len1 + len2 > dia && len1 == len2)
			return true;
		else
			return false;
	}

	public void doIt(){
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[,\\r\\n]+");
		int lec = 0, loz = 0;
		while(sc.hasNext()){
			int len1 = sc.nextInt();
			int len2 = sc.nextInt();
			int dia = sc.nextInt();
			if(isRightTri(len1, len2, dia))
				lec++;
			if(isLoz(len1, len2, dia))
				loz++;
		}
		System.out.printf("%d\n%d\n",lec, loz);
	}
	public static void main(String[] args) {
		Main obj = new Main();
		obj.doIt();
	}
}