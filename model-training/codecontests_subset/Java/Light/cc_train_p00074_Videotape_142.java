import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        final int hour = scanner.nextInt();
        final int minute = scanner.nextInt();
        final int second = scanner.nextInt();
        if (hour == -1 && minute == -1 && second == -1) {
          return;
        }
        VideoTape videoTape = new VideoTape(hour, minute, second);
        System.out.println(videoTape.remainingTime());
        System.out.println(videoTape.remainingTime3());
      }
    }
  }
}


class VideoTape {

  private final int hour;
  private final int minute;
  private final int second;

  private final DateTimeFormatter displayDateFormat;

  VideoTape(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    displayDateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
  }

  String remainingTime() {
    return LocalDateTime
        .of(0, 1, 1, 2, 0)
        .minusHours(hour)
        .minusMinutes(minute)
        .minusSeconds(second)
        .format(displayDateFormat);
  }

  String remainingTime3() {
    return LocalDateTime
        .of(0, 1, 1, 6, 0)
        .minusHours(hour * 3)
        .minusMinutes(minute * 3)
        .minusSeconds(second * 3)
        .format(displayDateFormat);
  }
}