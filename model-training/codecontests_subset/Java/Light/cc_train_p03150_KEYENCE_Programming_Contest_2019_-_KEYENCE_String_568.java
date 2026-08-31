import java.util.Scanner;
public class Main {

	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		String S=stdIn.next();
		String S1="";
		String S2="";
		int Slen=S.length();
		int z=0,y=Slen-7,x=0;
		while(y<Slen){
			S1=S.substring(0,z);
			S2=S.substring(y,Slen);
			if((S1+S2).equals("keyence")){
				x++;
				break;
			}
			z++;y++;
		}
		if(x==1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}