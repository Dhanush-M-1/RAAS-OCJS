public class Problem {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        int a , b , c ; a = input.nextInt();
        b = input.nextInt();c = input.nextInt();
        int time =(int)Math.ceil((a*c)/(double)b);
        System.out.println(time-c);
    }
}
