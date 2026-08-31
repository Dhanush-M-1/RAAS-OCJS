import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author emorenkov
 */
public class GukiStringB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        String firstPattern = sc.nextLine();
        String secondPattern = sc.nextLine();
        Map<Character, Integer> sourceStatistic = getCountMap(source);
        Map<Character, Integer> firstPatternStatistic = getCountMap(firstPattern);
        Map<Character, Integer> secondPatternStatistic = getCountMap(secondPattern);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int maxFirstAmount = getMaxWordAmount(sourceStatistic, firstPatternStatistic);
            int maxSecondAmount = getMaxWordAmount(sourceStatistic, secondPatternStatistic);
            if (maxFirstAmount == 0 && maxSecondAmount == 0) {
                break;
            }
            if (maxFirstAmount >= maxSecondAmount) {
                sb.append(firstPattern);
                updateSourceStatistic(sourceStatistic, firstPatternStatistic, 1);
            } else {
                sb.append(secondPattern);
                updateSourceStatistic(sourceStatistic, secondPatternStatistic, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : sourceStatistic.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        System.out.println(sb.toString());
    }

    private static void updateSourceStatistic(Map<Character, Integer> sourceStatistic,
                                              Map<Character, Integer> patternStatistic, int maxFirstAmount) {
        for (Map.Entry<Character, Integer> entry : patternStatistic.entrySet()) {
            Integer entryNum = sourceStatistic.get(entry.getKey());
            if (entryNum == null) {
                break;
            }
            Integer value = entryNum - maxFirstAmount * entry.getValue();
            sourceStatistic.put(entry.getKey(), value);
        }
    }

    public static Map<Character, Integer> getCountMap(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : word.toCharArray()) {
            Integer charCount = result.get(c);
            result.put(c, charCount == null ? 1 : charCount + 1);
        }
        return result;
    }

    public static int getMaxWordAmount(Map<Character, Integer> source, Map<Character, Integer> pattern) {
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : pattern.entrySet()) {
            Integer maxCharAmount = source.get(entry.getKey());
            if (maxCharAmount == null) {
                return 0;
            }
            int availableResults = maxCharAmount / entry.getValue();
            result = Math.min(result, availableResults);
        }
        return result;
    }
}