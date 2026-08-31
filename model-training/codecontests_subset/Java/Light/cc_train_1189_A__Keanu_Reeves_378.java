import java.util.Scanner;

public class KeanuReeves {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int l=in.nextInt();
        //in.nextLine();
        //System.out.println(l);
        String s = in.next();

        //System.out.println(s);
        int a=0,b=0;
        for(int i=0;i<l;i++){
            if(s.charAt(i)=='0'){
                a++;
            }else{
                b++;
            }
        }
        if(a!=b){
            System.out.println(1);
            System.out.println(s);
        }else{
            System.out.println(2);
            System.out.print(s.charAt(0)+" ");
            System.out.println(s.substring(1, l));
        }

    }
}
