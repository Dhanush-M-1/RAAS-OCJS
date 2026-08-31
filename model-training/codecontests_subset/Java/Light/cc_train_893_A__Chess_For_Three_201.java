import java.util.Scanner;
//''''
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int Winner1 = 1;
        int Winner2 = 2;
        boolean flag = true;

        for(int i=0;i<n;i++){
            int a = in.nextInt();
            if(Winner1!=a && Winner2!=a){
                flag = false;
                break;
            }
            else{
                Winner2 = 6 - Winner1 - Winner2;
                Winner1 = a;
            }
        }
        if(flag){
            System.out.print("YES");
        }
        else{
            System.out.print("NO");
        }
    }
}