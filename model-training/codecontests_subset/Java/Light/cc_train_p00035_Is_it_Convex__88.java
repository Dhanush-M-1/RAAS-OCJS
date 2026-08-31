import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String[] s = input.nextLine().split(",");
            double x1 = Double.parseDouble(s[0]);
            double y1 = Double.parseDouble(s[1]);
            double x2 = Double.parseDouble(s[2]);
            double y2 = Double.parseDouble(s[3]);
            double x3 = Double.parseDouble(s[4]);
            double y3 = Double.parseDouble(s[5]);
            double x4 = Double.parseDouble(s[6]);
            double y4 = Double.parseDouble(s[7]);
            if(intersect(x1,y1,x2,y2,x3,y3,x4,y4) || intersect(x3,y3,x4,y4,x1,y1,x2,y2)){
            	System.out.println("NO");
            }else{
            	System.out.println("YES");
            }
		}
	}

	static boolean intersect(double x1,double y1,double x2, double y2,double x3, double y3, double x4,double y4){
        return (((x3 - x4) * (y1 - y3) + (y3 - y4) * (x3 - x1))*((x3 - x4) * (y2 - y3) + (y3 - y4) * (x3 - x2)) < 0);
    }
}