import java.util.*;
import java.lang.*;
import java.io.*;


public class Solver {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
long players = sc.nextLong();
long maxRounds = 0;
long total = 0;
for (int i = 0; i < players; i++) {
long rounds = sc.nextLong();
total += rounds;
maxRounds = Math.max(rounds, maxRounds);
}

long roundsPerPlayer = total / (players-1);

roundsPerPlayer = total % (players - 1) == 0 ? roundsPerPlayer : roundsPerPlayer + 1;

long roundsToPlay = Math.max(roundsPerPlayer, maxRounds);

System.out.println(roundsToPlay);

}

}

