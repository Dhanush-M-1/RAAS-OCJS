import java.util.Scanner;

/**
 * Created by Abid on 04/10/2018.
 */
public class prob1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        n = input.nextInt();
        //System.out.println(n);

        String str;
        str = input.next();

        int count = 0;

        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) == '8'){
                count++;
            }
        }

        int count2 = n/11;

        if(count>count2){
            System.out.println(count2);
        }
        else {
            System.out.println(count);
        }

    }
}
