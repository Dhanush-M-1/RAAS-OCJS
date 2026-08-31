import java.util.Scanner;

public class Games {

    static class Node {
        int home;
        int away;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] teams = new Node[n];

        for(int i=0; i<n; i++) {
            Node team = new Node();
            team.home = in.nextInt();
            team.away = in.nextInt();
            teams[i] = team;
        }

        int count = 0;
        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(x != y && teams[x].home == teams[y].away) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

}
