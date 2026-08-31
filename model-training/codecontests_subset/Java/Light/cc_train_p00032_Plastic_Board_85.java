import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・ス
		Scanner sc = new Scanner(System.in);
		int tyou=0;
		int hishi=0;
        int c1 = 0;
        int c2 = 0;

        while(sc.hasNext()){

            String[] s=sc.nextLine().split(",");

           int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            int c=Integer.parseInt(s[2]);


            c1=a*a+b*b;
            c2=c*c;

            if(c1==c2){
            	tyou++;

            }else if(a==b){
            	hishi++;
            }

        }
        System.out.println(tyou);
        System.out.println(hishi);


    }
}
