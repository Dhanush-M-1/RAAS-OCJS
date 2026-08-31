import java.util.Scanner;


public class Main {
    boolean[] bulbs;
    int buttons;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new Main().process();
    }

    private void process() {
        String[] splits = scanner.nextLine().split(" ");
        buttons = Integer.parseInt(splits[0]);
        bulbs = new boolean[Integer.parseInt(splits[1]) + 1];
        int total = 0;
        while(buttons-- > 0) {
            String line = scanner.nextLine();
            String[] connections = line.split(" ");
            for (int i = 1; i < connections.length; i++) {
                if (!bulbs[Integer.parseInt(connections[i])]) {
                    bulbs[Integer.parseInt(connections[i])] = true;
                    total++;
                }
            }
        }
        
        if (total == bulbs.length - 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    
}
