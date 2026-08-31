import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String decisions = input.next();

        int iCount = 0;
        int aCount = 0;

        for (int i = 0; i < decisions.length(); i++){
            char c = decisions.charAt(i);
            if(c=='I'){
                iCount += 1;
            }
            if(c=='A'){
                aCount += 1;
            }

        }
        if(iCount==0){
            System.out.println(aCount);
        }
        else if(iCount==1){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}