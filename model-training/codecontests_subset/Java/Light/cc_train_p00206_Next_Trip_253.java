import java.util.*;
public class Main {
	Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		new AOJ0206();
	}
	
	class AOJ0206{
		public AOJ0206() {
			while(true){
				int l = in.nextInt();
				if(l==0)break;
				int kin = 0;
				boolean sw = true;
				int result = -1;
				for(int i=0;i<12;i++){
					int m = in.nextInt();
					int n = in.nextInt();
					kin += m-n;
					if(kin>=l&&sw){
						sw=false;
						result=i+1;
					}
				}
				System.out.println(sw? "NA":result);
			}
		}
	}
	
}