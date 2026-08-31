
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static final int X = 0;
	private static final int Y = 1;
	
	public static void main(String[] args) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Double> a = new ArrayList<Double>();
		ArrayList<Double> b = new ArrayList<Double>();
		ArrayList<Double> c = new ArrayList<Double>();
		ArrayList<Double> d = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		
		try{
			while(true){
				String input = sc.nextLine();
				String[] data = input.split(",");

				a.add(Double.valueOf(data[0]));
				a.add(Double.valueOf(data[1]));
				b.add(Double.valueOf(data[2]));
				b.add(Double.valueOf(data[3]));
				c.add(Double.valueOf(data[4]));
				c.add(Double.valueOf(data[5]));
				d.add(Double.valueOf(data[6]));
				d.add(Double.valueOf(data[7]));
				
				if(areCross(a, b, c, d)){
					result.add("YES");
				}
				else{
					result.add("NO");
				}
				
				a.clear();
				b.clear();
				c.clear();
				d.clear();
			}
		}catch(NoSuchElementException e){
			//何もしない
		}
		
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
	}
	
	public static boolean areCross(
			ArrayList<Double> p1,
			ArrayList<Double> p2,
			ArrayList<Double> p3,
			ArrayList<Double> p4){
		boolean a = false;
		boolean b = false;
		//p1p3とp2,p4
		if(isInBiggerArea(p1, p3, p2) && !(isInBiggerArea(p1, p3, p4))){
			a = true;
		}
		if(!(isInBiggerArea(p1, p3, p2)) && isInBiggerArea(p1, p3, p4)){
			a =  true;
		}

		//p2p4とp1
		if(isInBiggerArea(p2, p4, p1) && !(isInBiggerArea(p2, p4, p3))){
			b = true;
		}
		if(!(isInBiggerArea(p2, p4, p1)) && isInBiggerArea(p2, p4, p3)){
			b = true;
		}
		if(a && b){
			return true;
		}
		else{
			return false;
		}
	}
	
	private static boolean isInBiggerArea(
			ArrayList<Double> p1,
			ArrayList<Double> p2,
			ArrayList<Double> target){
			double result = (target.get(Y) - p1.get(Y)) * (p2.get(X) - p1.get(X)) + (p2.get(Y) - p1.get(Y)) * (p1.get(X) - target.get(X));
			if(result > 0){
				return true;
			}
			else{
				return false;
			}
	}
}