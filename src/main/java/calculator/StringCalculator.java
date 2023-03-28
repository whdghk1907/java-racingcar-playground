package calculator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringCalculator {
    public int sum(String value) {
        if(value == null || value.isEmpty()) {
            return 0;
        }

        String[] results = splitNumber(value);

        if(results == null) {
            return Integer.parseInt(results[0]);
        }

        int count = 0;

        for(String result : results) {
            int resultToInt = Integer.parseInt(result);

            if (resultToInt < 0) {
                throw new RuntimeException();
            }

            count += resultToInt;
        }

        return count;
    }

    public String[] splitNumber(String value) {

        if(value.contains(",") || value.contains(":")) {
            return value.split("[,:]");
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return value.split("");
    }
}
