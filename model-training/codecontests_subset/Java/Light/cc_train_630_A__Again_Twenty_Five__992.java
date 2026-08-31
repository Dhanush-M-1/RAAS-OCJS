public class Main{
    public static void main(String args[]){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        long s = sc.nextLong();
        long power = (long)java.lang.Math.pow(5, s);
        //System.out.println(power);
        int res2 = (int)power%10;
        power/=10;
        int res1 = (int)power%10;
        System.out.println("25");
    }
}