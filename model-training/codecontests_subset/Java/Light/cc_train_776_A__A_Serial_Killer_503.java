import java.util.Scanner;

public class _776_A_A_Serial_killer {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String atual [] = s.nextLine().split(" ");
        int n = s.nextInt();
        s.nextLine();
        
        System.out.println(atual[0]+" "+atual[1]);
        for (int i = 0; i < n; i++) {
            String[] agora = s.nextLine().split(" ");
            if(agora[0].equals(atual[0])){
                atual[0]=agora[1];
            }
            else{
                atual[1]=agora[1];
            }
            System.out.println(atual[0]+" "+atual[1]);
        }
    }

}