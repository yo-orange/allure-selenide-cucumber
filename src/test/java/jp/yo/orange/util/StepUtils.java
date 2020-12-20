package jp.yo.orange.util;

import org.apache.commons.lang3.RandomStringUtils;

public class StepUtils {

    private StepUtils() {
    }

    public static String convert(String value) {
        if (value == null) {
            return "";
        }

        if (value.startsWith("env:")) {
            return System.getenv(value.substring("env:".length()));
        } else if (value.startsWith("random:")) {
            return RandomStringUtils.random(Integer.parseInt(value.substring("random:".length())));
        } else if (value.startsWith("randomAlphanumeric:")) {
            return RandomStringUtils.randomAlphanumeric(Integer.parseInt(value.substring("randomAlphanumeric:".length())));
        } else if (value.startsWith("randomAlphabetic:")) {
            return RandomStringUtils.randomAlphabetic(Integer.parseInt(value.substring("randomAlphabetic:".length())));
        }
        return value;
    }
}
