package security.jwt.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static Date today() {
        return new Date();
    }

    public static String todayStr() {
        return sdf.format(today());
    }

    public static String formattedDate(Date date) {
        return date != null ? sdf.format(date) : todayStr();
    }
}