import java.util.ArrayList;
import java.util.Scanner;

public class D {

    private static class Group {
        private char color;
        private int count;

        public Group(char color, int count) {
            this.color = color;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        char[] colors = new Scanner(System.in).next().toCharArray();

        ArrayList<Group> groups = new ArrayList<>();
        for (char color : colors) {
            if (groups.isEmpty() || last(groups).color != color)
                groups.add(new Group(color, 1));
            else
                last(groups).count++;
        }

        int answer = 0;
        while (groups.size() > 1) {
            groups.get(0).count--;
            last(groups).count--;
            for (int i = 1; i < groups.size() - 1; i++)
                groups.get(i).count -= 2;

            ArrayList<Group> groups1 = new ArrayList<>();
            for (Group group : groups) {
                if (group.count > 0) {
                    if (groups1.isEmpty() || last(groups1).color != group.color)
                        groups1.add(group);
                    else
                        last(groups1).count += group.count;
                }
            }
            groups = groups1;

            answer++;
        }

        System.out.println(answer);
    }

    private static <T> T last(ArrayList<T> list) {
        return list.get(list.size() - 1);
    }

}
