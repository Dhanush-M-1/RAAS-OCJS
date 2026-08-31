import java.util.*;
public class ChatServersOutgoingTraffic {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int l=0;
		int c = 0;
		String s;
		while(input.hasNextLine()){
			 s = input.nextLine();
			if(s.charAt(0)== '+'){
				c++;
			}
			else if(s.charAt(0) == '-'){
				c--;
			}
			else
				l = l+ c*(s.length()-s.indexOf(':')-1);
		}
		System.out.println(l);
		// TODO Auto-generated method stub

	}

}
