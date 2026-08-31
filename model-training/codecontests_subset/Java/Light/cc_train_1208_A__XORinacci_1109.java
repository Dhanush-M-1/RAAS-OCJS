import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for(int j=0;j<tc;j++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            
                if(n%3==0){
                    System.out.println(a);
                }else if(n%3==1){
                    System.out.println(b);
                }else{
                    System.out.println(a^b);
                }
        }
        }
    }
