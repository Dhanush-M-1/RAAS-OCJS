import java.util.Scanner;

public class codeforces {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt(); 
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String line = in.nextLine();
        int nb8=0;
        for(int i=0 ; i<n;i++) {
        	if(line.charAt(i)=='8')
        		nb8++;
        }
        if(n/11 >=nb8) {
        	System.out.println(nb8);
        }
        else {
        	System.out.println(n/11);

        }
 }
}