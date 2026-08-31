import java.util.Scanner;

/**
 * Created by dtnha on 10/5/2017.
 */
public class BarkUnlock {


    public static void main(String []args){

        Scanner in = new Scanner(System.in);

        String password = in.nextLine();
        int n = in.nextInt();
        in.nextLine();
        String []barks = new String[n];
        for(int i = 0; i<n;i++){
            barks[i] = in.nextLine();
        }

        boolean isAble = false;


        int index = -1;
        for(int i = 0; i <n;i++){

            if(barks[i].equals(password)){
                isAble = true;
                break;
            }

            if(barks[i].charAt(1)== password.charAt(0)){
                index = i;
            }
        }

        if(isAble){
            System.out.println("YES");
        }else{
            if(index!=-1){
                for (int i=0; i<n;i++){
                    if(barks[i].charAt(0)== password.charAt(1)){
                        isAble = true;
                        break;
                    }
                }
            }
            if(isAble){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

    }
}
