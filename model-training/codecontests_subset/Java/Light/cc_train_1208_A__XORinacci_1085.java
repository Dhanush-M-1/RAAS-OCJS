import java.util.Scanner;

public class Pratice {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args){
        int num=SCANNER.nextInt();
        String[] input=new String[num+1];
        for(int i=0;i<=num;i++){
            input[i]=SCANNER.nextLine();
        }

        for(int i=1;i<=num;i++){
            String solve=input[i].replaceAll(" ",",") ;
            int sample = Integer.parseInt(solve.substring(0, solve.indexOf(",")));
            int sample2=Integer.parseInt(solve.substring(solve.indexOf(",")+1,solve.lastIndexOf(",")));
            int judge=Integer.parseInt(solve.substring(solve.lastIndexOf(",")+1));

            judge=judge%3;
            switch(judge){
                case 0:
                    System.out.println(sample) ;
                    break;
                case 1:
                    System.out.println(sample2) ;
                    break;
                default:
                    System.out.println(sample^sample2);
                    break;
            }
        }
    }
}
