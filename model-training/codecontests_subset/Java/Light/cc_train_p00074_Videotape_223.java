import java.util.*;

class Main {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    String out ="";
    while (scanner.hasNext()) {
      int hh = scanner.nextInt();
      int mm = scanner.nextInt();
      int ss = scanner.nextInt();
      if (hh == -1 && mm == -1 && ss == -1) {
        break;
      }
      int remain1 = 120 * 60 - (hh * 60 * 60 + mm * 60 + ss);
      int remain3 = remain1 * 3;
      int rh = remain1 / 3600;
      int rm = (remain1 % 3600) / 60;
      int rs = remain1 - (rh * 3600 + rm * 60);
      out += String.format("%02d:%02d:%02d\n", rh, rm, rs);
      rh = remain3 / 3600;
      rm = (remain3 % 3600) / 60;
      rs = remain3 - (rh * 3600 + rm * 60);
      out += String.format("%02d:%02d:%02d\n", rh, rm, rs);
    }
    System.out.print(out);
  }
}