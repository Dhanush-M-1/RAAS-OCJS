import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder("");
		int H=sc.nextInt(),W=sc.nextInt();
		while (H!=0||W!=0){
			for(int a=1;a<=H;a++){
				for (int b=1;b<=W;b++){
					if((a%2==1&&b%2==1)||(a%2==0&&b%2==0)){
						sb.append("#");
					}else if((a%2==0&&b%2==1)||(a%2==1&&b%2==0)){
						sb.append(".");
					}
				}
				sb.append("\n");
			}
			sb.append("\n");
			H=sc.nextInt();W=sc.nextInt();
		}
		System.out.print(sb);
		}
}