import java.util.Scanner; 

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int a = 0, b = 0, c = 0, d = 0;

        for(int i = 0; i<N ;i++){
            String e = sc.next();
            if(e.equals("AC")) a++;
            if(e.equals("WA")) b++;
            if(e.equals("TLE")) c++;
            if(e.equals("RE")) d++;
        }

        System.out.println("AC x "+a);
        System.out.println("WA x "+b);
        System.out.println("TLE x "+c);
        System.out.println("RE x "+d);       

    }
}