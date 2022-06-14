package db;

public class StringUtil {
    public static String quoteOrNull(Object object) {
        if (object == null) {
            return null;
        }

        return "'" + object.toString() + "'";
    }
}