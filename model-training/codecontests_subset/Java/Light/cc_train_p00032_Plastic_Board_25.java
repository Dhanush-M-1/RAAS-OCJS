import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rectanglesCount=0;
        int lozengesCount=0;
        while(sc.hasNext()) {
            Integer[] list = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            if(list[0]*list[0]+list[1]*list[1]==list[2]*list[2]) {
                rectanglesCount++;
            }
            if(list[0]==list[1]) {
                lozengesCount++;
            }
        }
        System.out.println(rectanglesCount+"\n"+lozengesCount);
    }
}
