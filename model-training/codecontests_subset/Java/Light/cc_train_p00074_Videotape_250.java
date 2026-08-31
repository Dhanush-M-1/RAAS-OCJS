import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final int VIDEO_TAPE_TIME = 7200;

    public static void main(String[] args) {

        List<String> inputDataList = new LinkedList<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 入力データをリストにセット
        String inputData = null;
        try {
            while ((inputData = in.readLine()) != null) {
                inputDataList.add(inputData);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        for (String input : inputDataList) {
            if (!remainingTime(input)) {
                break;
            }
        }
    }

    private static boolean remainingTime(String inputTime) {
        String[] inputTimeArray = inputTime.split("\\s");
        int inputHour = Integer.parseInt(inputTimeArray[0]);
        int inputMinute = Integer.parseInt(inputTimeArray[1]);
        int inputSecond = Integer.parseInt(inputTimeArray[2]);

        // 入力値のどの値が負の数でも不整合なデータとなるため、
        // 負の数が入った時点で終了とみなす。
        if (inputHour < 0 || inputMinute < 0 || inputSecond < 0) {
            return false;
        }

        int useTime = (inputHour * 60 + inputMinute) * 60 + inputSecond;

        int notUseTime = VIDEO_TAPE_TIME - useTime;

        // 標準録画の残量表示
        printremainingTime(notUseTime);

        // 3倍録画の残量表示
        printremainingTime(notUseTime * 3);

        return true;
    }

    private static void printremainingTime(int notUseTime) {
        int second = notUseTime % 60;
        int minute = notUseTime / 60 % 60;
        int hour = notUseTime / 3600;

        StringBuilder input = new StringBuilder();

        input.append(0).append(hour).append(":");

        if (minute < 10) {
            input.append(0);
        }

        input.append(minute).append(":");

        if (second < 10) {
            input.append(0);
        }

        input.append(second);

        System.out.println(input.toString());
    }

}