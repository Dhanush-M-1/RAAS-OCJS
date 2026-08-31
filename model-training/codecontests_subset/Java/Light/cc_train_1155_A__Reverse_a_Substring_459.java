import java.util.Scanner;

public class Question1155A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=sc.next();
        boolean ok=false;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)<str.charAt(i-1)){
                System.out.println("YES");
                System.out.println(i+" "+(i+1));
                ok=true;
                break;
            }
        }
        if(!ok){
            System.out.println("NO");
        }
    }
}
