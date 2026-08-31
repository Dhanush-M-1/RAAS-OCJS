
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int citizens,wizards;
        double percent;
        int peopleCount;
        double peaopleCountFloat;
        Scanner sc = new Scanner(System.in);
        citizens = sc.nextInt();
        wizards = sc.nextInt();
        percent = sc.nextFloat();

        double percentageFloat = percent/100;



        peopleCount = (int) (percentageFloat*citizens);
        peaopleCountFloat = percentageFloat*citizens;
        if(peaopleCountFloat - peopleCount != 0)
            peopleCount++;


        peopleCount = peopleCount - wizards;
        //System.out.println("Float count : "+peaopleCountFloat);
        //System.out.println("normal count : "+peopleCount);
        //System.out.println("Diffrence  : "+(peaopleCountFloat - peopleCount));

        if(peopleCount > 0){
            System.out.println(peopleCount);
        }else{
            System.out.println(0);
        }
        //System.out.println("peaple count - wizards : " + (peaopleCountFloat - wizards)+ " Float");


    }
}
