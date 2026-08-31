import java.util.Scanner;

public class Main{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		String b = scanner.next();
		
                if(equivalente(a).equals(equivalente(b))){
                   System.out.println("YES");
                   }else{
                         System.out.println("NO");
                        }
	}

	static String equivalente (String s){
		if (s.length() <= 1 || s.length() % 2 == 1){
		    return s;
                } 
		
                String a = equivalente(s.substring(0, s.length() / 2));
		String b = equivalente(s.substring(s.length() / 2));
		
                if (a.compareTo(b) < 0){
                   return a + b;
		}else{
		   return b + a;
                }
	}

}