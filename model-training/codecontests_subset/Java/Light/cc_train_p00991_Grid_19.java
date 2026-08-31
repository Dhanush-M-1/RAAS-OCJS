import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int r,c,a1,a2,b2,b1;
	static int[] v1={0,0,0,1,1,1,2,2,2};
	static int[] v2={0,1,2,0,1,2,0,1,2};
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		r=cin.nextInt();
		c=cin.nextInt();
		a1=cin.nextInt();
		a2=cin.nextInt();
		b1=cin.nextInt();
		b2=cin.nextInt();
		int[][] goals=new int[9][2];
		for(int i=0;i<9;i++){
			v1[i]=v1[i]*r;
			v2[i]=v2[i]*c;
		}
		for(int i=0;i<9;i++){
			goals[i][0]=b1+v1[i];
			goals[i][1]=b2+v2[i];
		}
		for(int i=0;i<9;i++){
//			System.out.println(goals[i][0]+" "+goals[i][1]);
		}
		
		a1=a1+r;
		a2=a2+c;
		int min=1<<30,x=0,y=0,cnt=0;;
		for(int i=0;i<9;i++){
			int dis=Math.abs(goals[i][0]-a1)+Math.abs(goals[i][1]-a2);
			if(min>dis){
				x=Math.abs(goals[i][0]-a1);
				y=Math.abs(goals[i][1]-a2);
				cnt=1;
				min=dis;
			}
			else if(min==dis){
				cnt++;
			}
		}
//		System.out.println(x+" "+y+" "+cnt);
		BigInteger bg=BigInteger.ONE;
		for(int i=1;i<=x+y;i++){
			bg=bg.multiply(new BigInteger(""+i));
		}
//		System.out.println(bg);
		for(int i=1;i<=x;i++){
			bg=bg.divide(new BigInteger(""+i));
		}
		for(int i=1;i<=y;i++){
			bg=bg.divide(new BigInteger(""+i));
		}
		bg=bg.multiply(new BigInteger(""+cnt));
			
		System.out.println(bg.remainder(new BigInteger("100000007")));
	}

}