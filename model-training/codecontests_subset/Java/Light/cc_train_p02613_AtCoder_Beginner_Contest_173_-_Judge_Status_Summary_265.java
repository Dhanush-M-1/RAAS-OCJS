import java.util.*;
public class Main {
	public static void main(String[] args){
      	int a=0,w=0,t=0,r=0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
      	for(int i=0;i<N;i++){
          String s = sc.next();
          if(s.equals("AC")){
            a++;
          }
          if(s.equals("WA")){
            w++;
          }
          if(s.equals("TLE")){
            t++;
          }
          if(s.equals("RE")){
            r++;
          }
        }
      	System.out.println("AC x "+a);
      	System.out.println("WA x "+w);
      	System.out.println("TLE x "+t);
      	System.out.println("RE x "+r);
	}
}