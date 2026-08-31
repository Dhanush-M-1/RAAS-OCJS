import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner scan = null;
		try{
			scan = new Scanner(new InputStreamReader(System.in));
			int rectangle = 0 ,lozenges = 0;
			while(scan.hasNext()){
				String[] str = scan.nextLine().split(",");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				int diagonal = Integer.parseInt(str[2]);
				if( a == b)lozenges ++;
				if(pow(diagonal) == pow(a) + pow(b))rectangle++;
			}
			System.out.println(rectangle);
			System.out.println(lozenges);
		}finally{
			if(scan !=null) scan.close();
		}
	}
	public static int pow (int d){
		return d * d;
	}
}