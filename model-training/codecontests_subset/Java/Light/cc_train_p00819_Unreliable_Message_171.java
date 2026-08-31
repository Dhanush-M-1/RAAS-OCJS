import java.util.Scanner;
import java.lang.StringBuffer;

public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);

        Integer i = scan.nextInt();
        scan.nextLine();

        for (; i > 0; i--) {
            String name = scan.nextLine();
            String line = scan.nextLine();
            for (Integer j = name.length() - 1; j >= 0; j--) {
                switch (name.charAt(j)) {
                case 'A':
                    line = a(line);
                    break;
                case 'C':
                    line = c(line);
                    break;
                case 'J':
                    line = j(line);
                    break;
                case 'E':
                    line = e(line);
                    break;
                case 'P':
                    line = p(line);
                    break;
                case 'M':
                    line = m(line);
                    break;
                }
            }
            System.out.println(line);
        }
    }

    String j(String line) {
        if (line.length() == 1)
            return line;
        String line2 = line;
        String line3 = line;
        line = line3.substring(line.length() - 1, line.length()) + line2.substring(0, line.length() - 1);
        return line;
    }

    String c(String line) {
        if (line.length() == 1)
            return line;
        String line2 = line;
        String line3 = line;
        line = line3.substring(1, line.length()) + line2.substring(0, 1);
        return line;
    }

    String e(String line) {
        if (line.length() == 1)
            return line;
        if (line.length() % 2 == 1) {
            line = line.substring(line.length() / 2 + 1, line.length())
                    + line.substring(line.length() / 2, line.length() / 2 + 1) + line.substring(0, line.length() / 2);
        } else {
            line = line.substring(line.length() / 2, line.length()) + line.substring(0, line.length() / 2);
        }
        return line;
    }

    String a(String line) {
        if (line.length() == 1)
            return line;
        StringBuffer rine = new StringBuffer();
        for (Integer i = line.length(); i > 0; i--) {
            rine.append(line.substring(i - 1, i));
        }
        return rine.toString();
    }

    String p(String line) {
        StringBuffer rine = new StringBuffer();
        for (Integer i = 0; i < line.length(); i++) {
            try {
                Integer tmp = Integer.valueOf(line.substring(i, i + 1));
                tmp--;
                if (tmp == -1)
                    tmp = 9;
                rine.append(tmp.toString());
            } catch (NumberFormatException a) {
                rine.append(line.substring(i, i + 1));
                // TODO: handle exception
            }
        }
        return rine.toString();
    }

    String m(String line) {
        StringBuffer rine = new StringBuffer();
        for (Integer i = 0; i < line.length(); i++) {
            try {
                Integer tmp = Integer.valueOf(line.substring(i, i + 1));
                tmp++;
                if (tmp == 10)
                    tmp = 0;
                rine.append(tmp.toString());
            } catch (NumberFormatException a) {
                rine.append(line.substring(i, i + 1));
                // TODO: handle exception
            }
        }
        return rine.toString();
    }

    public static void main(String[] args) {
        Main printer = new Main();
        printer.run();
    }
}

