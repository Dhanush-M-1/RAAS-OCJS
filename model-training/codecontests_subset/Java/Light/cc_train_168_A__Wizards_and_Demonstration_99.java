import java.util.Scanner;


public class WizardsAndDemonstration_A {


 
        public static void main(String[] args) {
            new WizardsAndDemonstration_A().run();
        }
 
        void run()
        {
            Scanner s= new Scanner(System.in);
            int n = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            int people = n - x;
            double percent = (double)y/100;
            int numberOfPeopleWhoNeedToBeThere = (int) Math.ceil((n*percent));
            int foo = Math.max(0,numberOfPeopleWhoNeedToBeThere - x);
            System.out.println(foo);
            
        }
}
