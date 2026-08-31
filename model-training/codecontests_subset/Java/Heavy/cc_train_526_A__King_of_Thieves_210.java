import javax.swing.*;

/**
 * Created by Shibly Workstation on 24-Dec-16.
 */

/*
public class Main {

    public JFrame frame;

    public Main() {

        frame = new JFrame("Car Game");
        frame.setLocation(250,250);
        frame.setSize(600,700);




        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);



    }
}
*/



import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Main {


        public static void main(String args[]) {

            Scanner scan = new Scanner(System.in);
            int n =scan.nextInt();
            int i,j,k,l,res=0;
            String s= scan.next();
            for( i = 0;i<n;i++){
                if(s.charAt(i)=='.')

                    continue;
                    for (j = 1; j < n; j++) {
                        k = 1;
                        for ( l = i + j; l < n; l = l+ j)
                            if (s.charAt(l) == '*') {
                                k++;
                            } else {
                                break;
                            }
                        if (k >= 5) {
                            System.out.println("yes");

                            return;
                        }


                    }



            }

                System.out.println("no");



        }
    }
