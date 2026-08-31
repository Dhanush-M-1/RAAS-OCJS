import java.util.Scanner;

public class _893A_ChessForThree {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),tmp;
        boolean alex=true,bob=true,carl=false,yes=true;
        for(int i = 0;i<n;i++){
            tmp = sc.nextInt();
            if(yes) {
                if (tmp == 1 && alex)
                    if (carl) {
                        bob = true;
                        carl = false;
                    } else {
                        bob = false;
                        carl = true;
                    }
                else if (tmp == 2 && bob)
                    if (carl) {
                        alex = true;
                        carl = false;
                    } else {
                        alex = false;
                        carl = true;
                    }
                else if (tmp == 3 && carl)
                    if (bob) {
                        alex = true;
                        bob = false;
                    } else {
                        alex = false;
                        bob = true;
                    }
                else {
                    yes = false;
                }
            }
        }
        System.out.println(yes?"YES":"NO");
    }
}
