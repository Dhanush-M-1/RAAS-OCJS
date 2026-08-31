
import java.util.NoSuchElementException;
import java.util.Scanner;

enum Figure{
	Rectangularoblong,
	Rhomboid,
	Else
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numRhomboid = 0;
		int numRectangularoblong = 0;
		
		try{
			while(true){
				String str = sc.nextLine();
				String[] input = str.split(",");
				if(isFigure(Figure.Rectangularoblong, getType(Integer.valueOf(input[0]), Integer.valueOf(input[1]), Integer.valueOf(input[2])))){
					numRectangularoblong++;
				}
				else if(isFigure(Figure.Rhomboid, getType(Integer.valueOf(input[0]), Integer.valueOf(input[1]), Integer.valueOf(input[2])))){
					numRhomboid++;
				}
			}
		}catch(NoSuchElementException e){
			//何もしない
		}

		System.out.println(numRectangularoblong);
		System.out.println(numRhomboid);
	}
	
	public static Figure getType(int w, int h, int diagonal){
		double tmp = w * w + h * h;
		//長方形は2辺の二乗の和と対角線の二乗が等しい
		if(diagonal * diagonal == tmp){
			return Figure.Rectangularoblong;
		}
		//平行四辺形はとなりあう辺の長さが等しい
		if(w == h){
			return Figure.Rhomboid;
		}
		//それいがい
		return Figure.Else;
	}
	
	private static boolean isFigure(Figure type, Figure figure){
		if(type == figure){
			return true;
		}
		else{
			return false;
		}
	}
}