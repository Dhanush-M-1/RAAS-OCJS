import java.util.*;
class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String str = sc.next();
	int slen = str.length();
	String keyence = "keyence";
	int l = 0;
	if(keyence.length() > slen) {
	    System.out.println("NO");
	    return;
	}
	for(int i = 0; i<slen; i++) {
	    if(str.charAt(i) != keyence.charAt(i)) break;
	    l++;
	}
	for(int i = 1; i<=keyence.length(); i++) {
	    if(str.charAt(slen-i) != keyence.charAt(keyence.length()-i)) break;
	    l++;
	}

	if(l >= keyence.length()) {
	    System.out.println("YES");
	    return;
	}
	System.out.println("NO");
    }
}