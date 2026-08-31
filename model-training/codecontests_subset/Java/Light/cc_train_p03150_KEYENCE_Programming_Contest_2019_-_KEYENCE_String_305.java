import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sub;
        for(int q=0; q<str.length(); q++){
            for(int r=q; r<=str.length(); r++){
                sub = new StringBuilder(str);
                sub.delete(q, r);
                if(sub.toString().equals("keyence")){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}