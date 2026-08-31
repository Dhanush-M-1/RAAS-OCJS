import java.util.Scanner;


public class Main {

	Scanner sc;
	
	boolean solve(double[][] p){
		double[][] v=new double[4][2];
		for(int i=0;i<4;++i){
			for(int j=0;j<2;++j){
				v[i][j]=p[(i+1)%4][j]-p[i][j];
			}
		}
		double[] op=new double[4];
		for(int i=0;i<4;++i){
			op[i]=v[i][0]*v[(i+1)%4][1]-v[i][1]*v[(i+1)%4][0];
		}
		for(int i=0;i<4;++i){
			if(op[i]*op[(i+1)%4]<0)return false;
		}
		return true;
	}
	
	double nd(){
		return sc.nextDouble();
	}
	
	void io(){
		sc=new Scanner(System.in).useDelimiter(",|\r\n|\n");
		while(sc.hasNext()){
			double[][] point=new double[4][2];
			for(int i=0;i<4;++i){
				for(int j=0;j<2;++j){
					point[i][j]=nd();
				}
			}
			System.out.println(solve(point)?"YES":"NO");
		}
	}

	public static void main(String[] args) {
		new Main().io();
	}
}