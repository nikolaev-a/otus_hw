package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class Helpers {

    public static LocalDate parseDateWithMonthFromText(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM", new Locale("ru"));
            Date parsedDate = dateFormat.parse(dateString);
            return parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Ошибка парсинга даты: " + e.getMessage());
        }
    }
}
