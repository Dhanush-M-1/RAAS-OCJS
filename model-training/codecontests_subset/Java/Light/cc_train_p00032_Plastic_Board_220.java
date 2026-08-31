import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);

        int cnt1=0,cnt2=0;
        while(sc.hasNextLine()){
        String st[]=sc.nextLine().split(",");
        int a =Integer.parseInt(st[0]);
        int b =Integer.parseInt(st[1]);
        int c =Integer.parseInt(st[2]);

            if (a * a + b * b == c * c){
                cnt1++;
            }
            if (a==b){
                cnt2++;
            }

            }
        System.out.println(cnt1+"\n"+cnt2);

    }
}