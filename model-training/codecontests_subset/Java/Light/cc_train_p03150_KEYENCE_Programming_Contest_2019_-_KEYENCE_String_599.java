import java.util.*;
class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String str = sc.next();
	boolean isKeyence = str.matches(".*keyence")
	    || str.matches("k.*eyence")
	    || str.matches("ke.*yence")
	    || str.matches("key.*ence")
	    || str.matches("keye.*nce")
	    || str.matches("keyen.*ce")
	    || str.matches("keyenc.*e")
	    || str.matches("keyence.*");
	if(isKeyence) {
	    System.out.println("YES");
	}else {
	    System.out.println("NO");
	}
    }
}