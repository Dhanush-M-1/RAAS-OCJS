import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
      	int n= sc.nextInt();
      	String[] s=new String[n];
      for(int i=0;i<n;i++){
      		s[i]=sc.next();}
      	int ac=0;
      	int a=0;
      	int tle=0;
      	int re=0;
      	for (int i = 0; i < n; i++) {
			if(s[i].equals("AC")){ac++;}
			if(s[i].equals("WA")){a++;}
			if(s[i].equals("TLE")){tle++;}
			if(s[i].equals("RE")){re++;}
		}
      	System.out.println("AC x "+ac);
      	System.out.println("WA x "+a);
      	System.out.println("TLE x "+tle);
      	System.out.println("RE x "+re);
}
}