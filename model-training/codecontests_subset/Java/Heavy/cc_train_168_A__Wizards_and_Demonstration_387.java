import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        Double n = in.nextDouble();// the number of citizens in the city
        Double x = in.nextDouble();// number of wizards
        Double y = in.nextDouble();// the percentage the administration needs
        Double output = (Double) Math.ceil((y / 100) * n);// the minimum number
                                                            // of clones to
                                                            // create
        if (output < x)
            System.out.println("0");
        else
            System.out.println((int) (output - x));

    }

}
