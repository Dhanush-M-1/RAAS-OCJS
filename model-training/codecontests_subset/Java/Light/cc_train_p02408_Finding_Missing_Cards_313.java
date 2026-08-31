import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x[] = new int[52];
		for(int i=0; i<52; i++){
			x[i]=0;
		}
		for(int i=0; i<n; i++){
			String str =sc.next();
			int num = sc.nextInt();
			if(str.equals("S")){
				num=num+0;
			}else if(str.equals("H")){
				num=num+13;
			}else if(str.equals("C")){
				num=num+26;
			}else if(str.equals("D")){
				num=num+39;
			}
			x[num-1]=1;
		}
		for(int i=1; i<53; i++){
			int num = i;
			if(x[i-1]==0){
				if(i<14){
					System.out.println("S"+ " " + num);
				}else if(i>13 && i<27){
					num=num-13;
					System.out.println("H" + " " + num);
				}else if(i>26 && i<40){
					num=num-26;
					System.out.println("C" + " " + num);
				}else if(i>39){
					num=num-39;
					System.out.println("D" + " " + num);
				}
			}
		}
	}
}