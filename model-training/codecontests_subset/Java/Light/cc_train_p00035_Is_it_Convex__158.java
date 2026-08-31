

import java.util.*;

import java.lang.*;

import java.math.*;



public class Main {

	

	class P{

		double x;

		double y;

		P(double x,double y){

			this.x =x;

			this.y = y;

		}

		P norm(){

			return new P(x/Math.sqrt(x*x+ y*y),y/Math.sqrt(x*x+ y*y));

		}

		

		double g(P p){

			P r = p.norm();//³K»

			return -r.x*this.y+r.y*this.x; //ñ]µÄCyÀWªãÉé©ºÉé©

		}

		

	}

	

	Scanner sc = new Scanner(System.in);

	void run(){

		for(;sc.hasNextLine();){

			String buffer=  sc.nextLine();

			Scanner in = new Scanner(buffer.replace(',', ' '));

			P[] point = new P[4];

			for(int i = 0; i < 4; i ++){

				double c = in.nextDouble();

				double d = in.nextDouble();

				point[i] = new P(c,d);

			}

			P[] d = new P[4];

			for(int i = 0; i < 4; i ++){

				d[i] = new P(point[(i+1)&3].x-point[i].x,point[(i+1)&3].y-point[i].y);

			}

			double c[] = new double[4];

			for(int i=0;i<4;i++){

				c[i] = d[i].g(d[(i+1)&3]);

//				System.out.println(c[i]);

			}

			boolean ret=true;

			for(int i = 1; i < 4;i++){

				ret = (c[i]*c[i-1] > 0)&&ret ;

			}

			System.out.println(ret?"YES":"NO");

		}

		

	}

	public static void main(String[] args){

		Main m = new Main();

		m.run();

		

	}

}