import java.io.*;
import java.util.*;
public class Main{

public static void main(String arg[]){

	Scanner s = new Scanner(System.in);
	int a = s.nextInt();
	int b = s.nextInt();

	if(a>=1 && a<=9 && b>=1 && b<=9){
	System.out.println(a*b);
	}else{
	System.out.println("-1");
	}
}
}