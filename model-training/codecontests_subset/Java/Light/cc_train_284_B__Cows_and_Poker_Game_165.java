import java.util.*;
public class CowPoker {
public static void main(String[] args){
	Scanner sc = new Scanner (System.in);
	int countcow = sc.nextInt();
	String cows = sc.next();
	int A = 0 , I=0;	
	while(countcow-->0){
		if (cows.charAt(countcow)=='A'){A++;}
		else if (cows.charAt(countcow)=='I'){I++;}
	}
	switch (I){
	case 0:System.out.print(A);break;
	case 1: System.out.print("1");break;
	default: System.out.print("0");break;
	}
}
}
