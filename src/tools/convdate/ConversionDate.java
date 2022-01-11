package tools;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConversionDate {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date CreerDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return new Date((sdf.parse(date)).getTime());
        } catch (ParseException e) {
            return null;
        }
    }
}
