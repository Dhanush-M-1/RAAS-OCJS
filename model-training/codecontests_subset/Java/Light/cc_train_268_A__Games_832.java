import java.util.*;
public class Games {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //Team[] teams = new Team[N];
        int[] home = new int[N];
        int[] away = new int[N];
        for(int i = 0; i < N; i++) {
            //teams[i] = new Team(scanner.nextInt(), scanner.nextInt());
            home[i] = scanner.nextInt();
            away[i] = scanner.nextInt();
        }
        int tot = 0;
        for(int i= 0; i < N;i++) {
            for(int j = 0; j < N; j++) {
                if (i==j) {continue;}
                //else if (teams[i].home == teams[j].away) {tot++;}
                if (home[i] == away[j]) {tot++;}
            }
        }
        System.out.println(tot);
    }

    /*public static class Team {
        int home, away;
        Team(int home, int away) {
            this.home = home;
            this.away = away;
        }
    }*/
}
