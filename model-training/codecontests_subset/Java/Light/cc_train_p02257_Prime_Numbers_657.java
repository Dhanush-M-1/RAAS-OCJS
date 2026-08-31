import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.next());
        int count = 0;
        for(int i = 0; i < n; i++){
            if(isprime(Integer.parseInt(sc.next()))) count++;
        }
        System.out.println(count);
    }
    
    static boolean isprime(int x){
        if(x == 2) return true;
        if(x < 2 || x%2 == 0) return false;
        double sqrt = Math.sqrt(x+1);
        for(int i = 3; i <= sqrt; i += 2){
            if(x%i == 0) return false;
        }
        return true;
    }
}
