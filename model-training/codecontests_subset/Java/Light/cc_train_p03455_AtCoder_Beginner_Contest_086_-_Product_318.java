import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
if (a * b % 2 == 0 ){
          System.out.print("Even");
}else{
          System.out.print("Odd");
}
}
}