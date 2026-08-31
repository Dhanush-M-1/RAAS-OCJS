import java.util.Scanner;
public class Main{
	public static void main(String[]args){
	Scanner scan=new Scanner(System.in);
	String a=scan.next();
	boolean bool=false;
	for(int i=0;i<a.length();i++) {
		for(int j=0;j<a.length()-i+1;j++) {
			String str1=a.substring(0,j);
			String str2=a.substring(j+i,a.length());
			String str=str1+str2;
			if(str.equals("keyence")) {
				bool=true;
			}
		}
	}
	System.out.println(bool?"YES":"NO");
	}
}