import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static final int X = 0;
	public static final int Y = 1;
	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doIt();

	}
	public static void doIt(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			String[] ss = s.split(",");
			double[][] pos = new double[4][2];
			for(int i = 0; i < 4; i++){
				pos[i][X] = Double.parseDouble(ss[2*i]);
				pos[i][Y] = Double.parseDouble(ss[2*i + 1]);
			}
			boolean bOK = calc(pos[A], pos[B], pos[C], pos[D]);
			bOK &= calc(pos[B], pos[C], pos[D], pos[A]);
			//bOK &= calc(pos[C], pos[D], pos[A], pos[B]);
			//bOK &= calc(pos[D], pos[A], pos[B], pos[C]);
			if(bOK){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
	}
	
	//tAC = AB + sBDよりtを出して、t < 1ならfalse
	public static boolean calc(double[] a, double[] b, double[] c, double[] d){
		//Aを原点にする
		double[] b0 = new double[2];
		double[] c0 = new double[2];
		double[] d0 = new double[2];
		double[] bd = new double[2];
		for(int i = 0; i < 2; i++){
			b0[i] = b[i] - a[i];
			c0[i] = c[i] - a[i];
			d0[i] = d[i] - a[i];
			bd[i] = d0[i] - b0[i];
		}
		//これは嘘！
//		if(c0[X] == 0 || c0[Y] == 0){
//			return true;
//		}
		double t = 0;
		if(bd[X] == 0){
			t = b0[X] / c0[X];
		}
		else if(bd[Y] == 0){
			t = b0[Y] / c0[Y];
		}
		else{
			t = (b0[X] * bd[Y] - b0[Y] * bd[X]) / (c0[X] * bd[Y] - c0[Y] * bd[X]);
		}
		//System.out.println(t);
		if(t > 1 || t < 0){
			return false;
		}
		else{
			return true;
		}
	}
}