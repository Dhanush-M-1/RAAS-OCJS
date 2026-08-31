import java.util.Scanner;


public class StringEqui {
	public static void main(String args[]){
	Scanner s=new Scanner(System.in);
	String s1=s.nextLine();
	String s2=s.nextLine();
	if(s1.length()==s2.length()){
	String smalls1=Stringmin(s1);
	String smalls2=Stringmin(s2);
	if(smalls1.equals(smalls2))System.out.println("YES");
	else System.out.println("NO");
	}
	else System.out.println("NO");
}
public static String  Stringmin(String s1){   
	   if(s1.length()%2==1)return s1;
	   String s3=Stringmin(s1.substring(0,(s1.length()/2)));
	   String s4=Stringmin(s1.substring(((s1.length()/2)),s1.length()));
	   if(s3.compareTo(s4)<0)return s3+s4;
	   else return s4+s3;
}
}