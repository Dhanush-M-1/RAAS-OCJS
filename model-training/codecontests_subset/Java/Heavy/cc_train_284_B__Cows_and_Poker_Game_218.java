import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str;
        int n;
        Scanner input= new Scanner(System.in);
        n = input.nextInt();
        str=input.next();
        int a = 0, i = 0, f = 0;
        for(int j = 0; j < n; j++){
            if(str.charAt(j) == 'A'){
                a++;
            }
            else if(str.charAt(j) == 'I'){
                i++;
            }
            else if(str.charAt(j) == 'F'){
                f++;
            }

        }
        if(i > 1){
            System.out.println("0");
        }
        else if(i == 1){
            System.out.println("1");
        }
        else{
            System.out.println(a);
        }
        //System.out.println(str);
    }
}
