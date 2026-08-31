import java.util.Scanner;

public class HelpfulMaths {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String out = "";
        if(in.length() > 1){
            String[] num = in.split("\\+");
            for(int i = 1; i <= 3; i++){
                for(int j = 0; j < num.length; j++){
                    if(Integer.valueOf(num[j])==i){
                        out += num[j]+"+";
                    }
                }
            }
            System.out.println(out.substring(0, out.length()-1));
        }else{
            System.out.println(in);
        }
    }

}
