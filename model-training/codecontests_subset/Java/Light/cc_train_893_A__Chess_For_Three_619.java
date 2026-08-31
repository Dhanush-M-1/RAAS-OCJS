import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] usr = {1, 2, 3};
        int temp;
        boolean yes = true;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (usr[0] == a) {
                temp = usr[1];
                usr[1] = usr[2];
                usr[2] = temp;
            }else if (usr[1]==a){
                temp = usr[0];
                usr[0] = usr[2];
                usr[2] = temp;
            }else{
                yes = false;
                break;
            }
        }
        if(yes){
            System.out.println("YES");
        }else{
            System.out.print("NO");
        }
    }
}

 		 		 				  	 		   		  	   			