import java.util.*;
public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        
        if (S.startsWith("keyence") || S.endsWith("keyence")) {
        	System.out.println("YES");
        	return;
        }
        
        boolean flg = false;
        int index = 0;
        char[] keyence = "keyence".toCharArray();
        for (int i = 0; i < S.length(); i++) {
        	if (flg) {
        		System.out.println(S.endsWith("keyence".substring(index)) ? "YES":"NO");
        		return;
        	}
        	
        	if (index >= keyence.length) {
        		break;
        	}
        	
        	if (S.charAt(i) == keyence[index]) {
        		index++;
        	} else {
        		flg = true;
        	}
        }
        
        System.out.println("NO");
    }
}