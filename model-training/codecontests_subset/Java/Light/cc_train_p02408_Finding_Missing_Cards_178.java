import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        String[] mark = {"S", "H", "C", "D"};

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                list.add(mark[i] + " " + (j + 1));
            }
        }

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < n; i++){
            list.remove(sc.nextLine());
        }

        for(String str : list){
            System.out.println(str);
        }
    }
}