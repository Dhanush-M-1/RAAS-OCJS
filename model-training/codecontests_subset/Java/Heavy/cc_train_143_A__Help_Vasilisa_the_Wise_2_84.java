import java.util.Scanner;

public class HelpVasilisaTheWise2 {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int[] row = {in.nextInt(), in.nextInt()};
        int[] col = {in.nextInt(), in.nextInt()};
        int[] dia = {in.nextInt(), in.nextInt()};
        int [][] sol = new int[2][2];
        for (int i = 1; i < 10; i++) {
            sol[0][0] = i;
            sol[0][1] = row[0]-i;
            
            if (sol[0][1] < 10 && sol[0][1] > 0 /*&& sol[0][1] != sol[0][0]*/) {
                sol[1][0] = col[0]-sol[0][0];
                
                if (sol[1][0] < 10 && sol[1][0] > 0) {
                    sol[1][1] = row[1]-sol[1][0];
                    
                    if (sol[1][1] < 10 && sol[1][1] > 0) {
                        sol[0][1] = col[1]- sol[1][1];
                        
                        if (sol[0][1] < 10 && sol[0][1]> 0 && sol[0][0]+sol[1][1] == dia[0] && sol[0][1]+sol[1][0] == dia[1] 
                                && sol[0][0] != sol[1][1] && sol[1][0] != sol[0][1] && sol[0][0] != sol[0][1] && sol[1][1] != sol[1][0]
                                && sol[0][0] != sol[1][0] && sol[0][1] != sol[1][1]) {
                            System.out.println(sol[0][0] + " " + sol[0][1] +
                                    "\n" + sol[1][0] + " " + sol[1][1]);
                            System.exit(0);
                        }   
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
