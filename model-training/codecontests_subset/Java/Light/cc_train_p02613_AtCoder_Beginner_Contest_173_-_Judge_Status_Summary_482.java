import java.util.Scanner;
public class Main{
  public static void main(String[] args){
	  Scanner scan = new Scanner(System.in);
	  int ac = 0;
	  int wa = 0;
	  int tle = 0;
	  int re = 0;
	  int num = scan.nextInt();
	   String test = "";
	  for(int i=0;i<num+1;i++) {
		  test = scan.nextLine();
		  if (test.equals("AC")) {
			  ac++; 
		  }
		  if (test.equals("WA")) {
			  wa++;
		  }
		  if (test.equals("TLE")) {
			  tle++;
		  }
		  if (test.equals("RE")) {
			  re++;
		  }
	  }
	  
	  System.out.println(
			  "AC x " + ac+
			  "\nWA x " + wa+
			  "\nTLE x "+ tle+
			  "\nRE x " + re);
  }
}