import java.util.Scanner;
public class Main {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
int N=scan.nextInt();
String S[]=new String[N];
long C0=0;
        long C1=0;
        long C2=0;
        long C3=0;
for(int i=0;i<N;i++){S[i]=scan.next();}
for(int i=0;i<N;i++){
    if(S[i].equals("AC")){C0++;}
    if(S[i].equals("WA")){C1++;}
    if(S[i].equals("TLE")){C2++;}
    if(S[i].equals("RE")){C3++;}

}
System.out.println("AC x "+C0);
        System.out.println("WA x "+C1);
        System.out.println("TLE x "+C2);
        System.out.println("RE x "+C3);

}

    }
