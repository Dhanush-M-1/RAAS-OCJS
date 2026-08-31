import java.util.EnumSet;
import java.util.Scanner;


public class Main{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int rec = 0;
		int loz = 0;
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			Scanner scstr = new Scanner(s);
			scstr.useDelimiter(",");
			int s1 = scstr.nextInt();
			int s2 = scstr.nextInt();
			int d = scstr.nextInt();
			scstr.close();
			Quadrangle q = kindOfQuadrangle(s1, s2, d);
			if(q.equals(Quadrangle.rectangle) || q.equals(Quadrangle.square)) rec++;
			if(q.equals(Quadrangle.lozenges) || q.equals(Quadrangle.square)) loz++;
		}
		sc.close();
		System.out.println(rec);
		System.out.println(loz);
	}
	
	
	static Quadrangle kindOfQuadrangle(int firstSide, int secondSide, int diagonal) {
		EnumSet<Quadrangle> es = EnumSet.noneOf(Quadrangle.class);
		if(firstSide * firstSide + secondSide * secondSide == diagonal * diagonal) es.add(Quadrangle.rectangle);
		if(firstSide == secondSide) es.add(Quadrangle.lozenges);
		
		if(es.contains(Quadrangle.rectangle) && es.contains(Quadrangle.lozenges)) return Quadrangle.square;
		if(es.contains(Quadrangle.rectangle)) return Quadrangle.rectangle;
		else if(es.contains(Quadrangle.lozenges)) return Quadrangle.lozenges;
		else return Quadrangle.quadrangle;
	}
}

enum Quadrangle{
	rectangle, lozenges, square, quadrangle
}