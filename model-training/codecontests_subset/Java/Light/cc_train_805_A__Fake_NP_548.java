import java.util.*;
public class FakeNP {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		StringTokenizer s = new StringTokenizer(in.nextLine());
		int M = Integer.parseInt(s.nextToken()), N = Integer.parseInt(s.nextToken());
		if(M == N && M%1 == 0){System.out.println(M);}
		else{System.out.println("2");}
		in.close();
	}
}