import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();

        int count1=0,count0=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')
                count1++;
            else
                count0++;
        }
        if(count1!=count0){
            System.out.print(1+"\n"+s);
        }
        else{
            System.out.println(2);
            for(int i=0;i<n-1;i++){
                System.out.print(s.charAt(i));
            }
            System.out.print(" ");
            System.out.print(s.charAt(n-1));
        }
    }
}