
import java.util.Scanner;

public class ex6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long[] tab = new long[28];
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();

        String thing = input.next();

        boolean r = false;
        int jumped = 0;
        while (!r && thing.length() >= length / 4&&thing.indexOf('*')!=-1){
            for (int jump = 1; jump <= (thing.length() / 4); jump++) {

                

                int i = thing.indexOf('*');
                jumped = 0;
                while (i+jump<thing.length()&&jumped <= 3 && thing.charAt(i + jump) == '*') {
                    // System.out.println();
                    i += jump;
                    jumped++;
                }
                if (jumped > 3) {
                    r = true;
                    break;
                }
            }
        thing=thing.substring(thing.indexOf('*')+1) ;
        
        
        }
        if (r)
            System.out.println("yes");
        else
            System.out.println("no");

    }

}
