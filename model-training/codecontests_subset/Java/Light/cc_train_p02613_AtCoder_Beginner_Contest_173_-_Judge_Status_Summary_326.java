import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
      	int ac = 0;
      	int wa = 0;
      	int tle = 0;
      	int re = 0;
      	for (int i=0; i<n; i++) {
          String s = sc.next();
          if (s.equals("AC")) {
            ac++;
          } else if (s.equals("WA")) {
            wa++;
          } else if (s.equals("TLE")) {
            tle++;
          } else {
            re++;
          }
        }
      	sc.close();
      	System.out.println("AC x "+ac+ "\nWA x " +wa+ "\nTLE x " +tle+ "\nRE x " +re);
	}
}