import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(true){
			int h=sc.nextInt();
			int m=sc.nextInt();
			int s=sc.nextInt();
			if(h==-1&&m==-1&&s==-1){
				break;
			}
			int remainder=2*3600-h*3600-m*60-s;
			int remainderH=remainder/3600;
			int remainderM=(remainder-remainderH*3600)/60;
			int remainderS=remainder-remainderH*3600-remainderM*60;
			System.out.println("0"+remainderH+":"+(remainderM>=10?remainderM:"0"+remainderM)+":"+(remainderS>=10?remainderS:"0"+remainderS));
			remainder=(2*3600-h*3600-m*60-s)*3;
			remainderH=remainder/3600;
			remainderM=(remainder-remainderH*3600)/60;
			remainderS=remainder-remainderH*3600-remainderM*60;
			System.out.println("0"+remainderH+":"+(remainderM>=10?remainderM:"0"+remainderM)+":"+(remainderS>=10?remainderS:"0"+remainderS));
		}
	}
}