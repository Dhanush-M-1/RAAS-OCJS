import java.io.*;

public class SchoolTeamContest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        args = br.readLine().split(" ");

        int n = Integer.parseInt(args[0]), a = Integer.parseInt(args[3]), b = Integer
                .parseInt(args[2]), c = Integer.parseInt(args[1]);
        int count = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i * 2 + j > n)
                    break;
                if (c / 2 >= n - (i * 2 + j)) count ++;
            }
        }
        System.out.println(count);

    }

}
