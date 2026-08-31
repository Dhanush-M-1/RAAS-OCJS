import java.util.Scanner;
class Main {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int[] n = new int[3];
		int[] num = {0,0};
		Main app = new Main();
		while(scan.hasNext()){
			app.input(n,scan);
			app.judge(n,num);
		}
		System.out.println(num[0]);
		System.out.println(num[1]);
	}
	
	public void judge(int[] n,int[] num){
		if(n[0]<=n[2] && n[1]<=n[2]){
			if((n[0]*n[0]+n[1]*n[1])==(n[2]*n[2])){
				num[0]++;
			}else{
				num[1]++;
			}
		}
	}
	
	public void input(int[] n,Scanner s){
		String[] splitLine = s.nextLine().split(",");
		for(int i=0;i<3;i++){
			n[i] = Integer.parseInt(splitLine[i]);
		}
	}
}