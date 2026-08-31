import java.util.*;
class Main{
	Scanner sc=new Scanner(System.in);
	boolean[][] card=new boolean[4][13];
	void aa(){
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			String m=sc.next();
			int s=sc.nextInt();
			card[bb(m)][s-1]=true;
		}
		for(int i=0;i<4;i++){
			for(int j=1;j<14;j++){
				if(!card[i][j-1]){
					String m=cc(i);
					System.out.println(m+" "+j);
				}
			}
		}
	}
	int bb(String m){
		if(m.equals("S"))return 0;
		else if	(m.equals("H"))return 1;
		else if	(m.equals("C"))return 2;
		else return 3;
	}
	String cc(int n){
		String m="";
		switch (n){
			case 0:
			m="S";
			break;
			case 1:
			m="H";
			break;
			case 2:
			m="C";
			break;
			case 3:
			m="D";
			break;
		}
		return m;
	}
	public static void main(String[]arg){
		new Main().aa();
	}
}