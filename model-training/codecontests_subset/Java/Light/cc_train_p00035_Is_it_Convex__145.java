import java.util.*;
import java.math.*;
import java.text.*;
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			double x[] = new double[4];
			double y[] = new double[4];
			double vx[] = new double[4];
			double vy[] = new double[4];
			double gai[] = new double[4];
			String str = in.next();
			StringTokenizer st = new StringTokenizer(str, ",");
			for(int i=0; i<4; i++){
				x[i] = Double.parseDouble(st.nextToken());
				y[i] = Double.parseDouble(st.nextToken());
			}
			for(int i=0; i<4; i++){
				vx[i] = x[(i+1)%4]-x[i];
				vy[i] = y[(i+1)%4]-y[i];
			}
			for(int i=0; i<4; i++){
				gai[i] = (vx[(i+1)%4]*vy[i])-(vy[(i+1)%4]*vx[i]);
			}
			if((gai[0]>0 && gai[1]>0 && gai[2]>0 && gai[3]>0) || (gai[0]<0 && gai[1]<0 && gai[2]<0 && gai[3]<0)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}