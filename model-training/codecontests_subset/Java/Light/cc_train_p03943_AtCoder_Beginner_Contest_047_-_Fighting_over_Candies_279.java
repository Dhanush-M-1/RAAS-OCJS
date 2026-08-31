import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    int max = Math.max(c, Math.max(a, b));
    
    if(a+b+c-max == max) {
    	System.out.println("Yes");
    }else {
    	System.out.println("No");
    }
}
}