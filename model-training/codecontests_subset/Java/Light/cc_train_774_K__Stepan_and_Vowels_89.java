import java.util.*;

public class Sol{
	public static void main(String[] argc){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String s = sc.next();
		String res = "";
        char last = ' ';
        int cnt = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == 'e' || s.charAt(i) == 'u' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'a' || s.charAt(i) == 'y') {
                if(last == s.charAt(i)) {
                    cnt ++;
                } else {
                    if((last == 'e' || last == 'o') && cnt == 2) {
                        System.out.print(last);
                        System.out.print(last);
                    } else if(last != ' ')
                        System.out.print(last);
                    cnt = 1;
                }
                last = s.charAt(i);
            } else {
                if(last != ' ') {
                    System.out.print(last);
                    if((last == 'e' || last == 'o') && cnt == 2) {
                        System.out.print(last);
                    } 
                
                }
                System.out.print(s.charAt(i));
                last = ' ';
                cnt = 0;
            }
        }
        if(last != ' ') {
            System.out.print(last);
            if((last == 'e' || last == 'o') && cnt == 2) {
                System.out.print(last);
            } 
        }

        
	}
}