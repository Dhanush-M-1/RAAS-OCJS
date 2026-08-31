import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		new Main().run();
	}
	Scanner scan = new Scanner(System.in);
	double[] x;
	double[] y;
	public void run(){
		while(scan.hasNext()){
			String[] str = scan.next().split(",");
			x = new double[4];
			y = new double[4];
			for(int i = 0,k = 0;i < 8;i+=2){
				x[k] = Double.parseDouble(str[i]);
				y[k++] = Double.parseDouble(str[i+1]);
			}
			System.out.println(((check(0)&check(1)&check(2)&check(3))?"YES":"NO"));
		}
	}
	public boolean check(int p){
		int t = 0;
			t += ((x[p]*(y[(p+1)%4] - y[(p+2)%4]) + x[(p+1)%4]*(y[(p+2)%4] - y[p]) + x[(p+2)%4]*(y[p] - y[(p+1)%4])) >= 0)?1:-1;
			t += ((x[p]*(y[(p+2)%4] - y[(p+3)%4]) + x[(p+2)%4]*(y[(p+3)%4] - y[p]) + x[(p+3)%4]*(y[p] - y[(p+2)%4])) >= 0)?1:-1;
			t += ((x[p]*(y[(p+3)%4] - y[(p+1)%4]) + x[(p+3)%4]*(y[(p+1)%4] - y[p]) + x[(p+1)%4]*(y[p] - y[(p+3)%4])) >= 0)?1:-1;
		return ((t==3) || (t==-3))?false:true;
	}
}