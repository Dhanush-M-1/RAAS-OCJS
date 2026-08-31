    import java.util.Scanner;
    public class Code {
    	public static void main(String[] args){
    		Scanner in = new Scanner(System.in);
    		int n = in.nextInt(),
    		    count = 0;
    		String str = in.next();
    		for(int i = 0; i < n; ++i){
    			if(str.charAt(i) == '1') count++;
    		}
    		if(count * 2 == n){
    			System.out.println(2 + "\n" + str.charAt(0)+ " " + str.substring(1));
    		} else System.out.println(1 + "\n" + str);
    	}
    }