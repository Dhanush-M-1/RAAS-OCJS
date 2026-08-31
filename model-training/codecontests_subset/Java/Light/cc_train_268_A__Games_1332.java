import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int teamsNo = in.nextInt();

        int[] hosts = new int[teamsNo];
        int[] guests = new int[teamsNo];

        for(int i=0; i<teamsNo; i++)
        {
            hosts[i]=in.nextInt();
            guests[i]=in.nextInt();
        }

        int sum=0;

        for(int i=0; i<teamsNo; i++)
        {
            int color=hosts[i];

            for(int j=0; j<teamsNo; j++)
            {
                if(color==guests[j])
                    sum++;
            }
        }

        System.out.println(sum);


    }
}
