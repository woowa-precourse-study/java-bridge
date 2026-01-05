//package bridge.utils;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.Locale;
//
//public final class DateTimeUtil {
//
//    private DateTimeUtil() {}
//
//    /* ==================================================
//     * DateTimeFormatter 정리
//     * ==================================================
//     */
//
//    // 1️⃣ yyyy-MM-dd
//    public static final DateTimeFormatter DATE =
//            DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//    // 2️⃣ yyyy-MM-dd HH:mm:ss
//    public static final DateTimeFormatter DATE_TIME =
//            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    // 3️⃣ yyyy-MM-dd'T'HH:mm:ss
//    public static final DateTimeFormatter DATE_TIME_T =
//            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//
//    // 4️⃣ yyyy/MM/dd
//    public static final DateTimeFormatter DATE_SLASH =
//            DateTimeFormatter.ofPattern("yyyy/MM/dd");
//
//    // 5️⃣ yyyyMMdd
//    public static final DateTimeFormatter DATE_COMPACT =
//            DateTimeFormatter.ofPattern("yyyyMMdd");
//
//    // 6️⃣ yyyyMMddHHmmss
//    public static final DateTimeFormatter DATE_TIME_COMPACT =
//            DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//
//    // 7️⃣ yyyy-MM-dd HH:mm:ss.SSS
//    public static final DateTimeFormatter DATE_TIME_MILLIS =
//            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//
//    // 8️⃣ yyyy년 MM월 dd일
//    public static final DateTimeFormatter DATE_KOREAN =
//            DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
//
//    // 9️⃣ yyyy년 MM월 dd일 HH시 mm분 ss초
//    public static final DateTimeFormatter DATE_TIME_KOREAN =
//            DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
//
//    // 🔟 yyyy-MM-dd (E)
//    public static final DateTimeFormatter DATE_DAY_OF_WEEK =
//            DateTimeFormatter.ofPattern("yyyy-MM-dd (E)", Locale.KOREAN);
//
//    // 1️⃣1️⃣ yyyy-MM-dd hh:mm:ss a
//    public static final DateTimeFormatter DATE_TIME_AM_PM =
//            DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a", Locale.KOREAN);
//
//    /* ==================================================
//     * Parse (String → Date / DateTime)
//     * ==================================================
//     */
//
//    public static LocalDate parseDate(String input, DateTimeFormatter formatter) {
//        try {
//            return LocalDate.parse(input, formatter);
//        } catch (DateTimeParseException e) {
//            throw new IllegalArgumentException("날짜 형식이 올바르지 않습니다.");
//        }
//    }
//
//    public static LocalDateTime parseDateTime(String input, DateTimeFormatter formatter) {
//        try {
//            return LocalDateTime.parse(input, formatter);
//        } catch (DateTimeParseException e) {
//            throw new IllegalArgumentException("날짜/시간 형식이 올바르지 않습니다.");
//        }
//    }
//
//    public static LocalTime parseTime(String input, DateTimeFormatter formatter) {
//        try {
//            return LocalTime.parse(input, formatter);
//        } catch (DateTimeParseException e) {
//            throw new IllegalArgumentException("시간 형식이 올바르지 않습니다.");
//        }
//    }
//
//    /* ==================================================
//     * Format (Date / DateTime → String)
//     * ==================================================
//     */
//
//    public static String format(LocalDate date, DateTimeFormatter formatter) {
//        return date.format(formatter);
//    }
//
//    public static String format(LocalDateTime dateTime, DateTimeFormatter formatter) {
//        return dateTime.format(formatter);
//    }
//
//    /* ==================================================
//     * Now (missionutils DateTimes 사용)
//     * ==================================================
//     */
//
//    public static LocalDateTime now() {
//        return DateTimes.now();
//    }
//
//    public static LocalDate today() {
//        return DateTimes.now().toLocalDate();
//    }
//
//    public static LocalTime currentTime() {
//        return DateTimes.now().toLocalTime();
//    }
//
//    /* ==================================================
//     * 시간 비교 유틸
//     * ==================================================
//     */
//
//    /**
//     * 현재 시간이 start 이상 end 이하인지
//     */
//    public static boolean isNowBetween(LocalTime start, LocalTime end) {
//        LocalTime now = currentTime();
//        return !now.isBefore(start) && !now.isAfter(end);
//    }
//
//    /**
//     * 특정 시간이 start 이상 end 이하인지
//     */
//    public static boolean isBetween(LocalTime target, LocalTime start, LocalTime end) {
//        return !target.isBefore(start) && !target.isAfter(end);
//    }
//
//    /**
//     * 현재 시간이 기준 시간 이후인지
//     */
//    public static boolean isNowAfter(LocalTime time) {
//        return currentTime().isAfter(time);
//    }
//
//    /**
//     * 현재 시간이 기준 시간 이전인지
//     */
//    public static boolean isNowBefore(LocalTime time) {
//        return currentTime().isBefore(time);
//    }
//
//    /**
//     * 두 DateTime 중 later가 after 이후인지
//     */
//    public static boolean isAfter(LocalDateTime later, LocalDateTime earlier) {
//        return later.isAfter(earlier);
//    }
//
//    /**
//     * 날짜가 오늘인지
//     */
//    public static boolean isToday(LocalDate date) {
//        return date.equals(today());
//    }
//
//    /* ==================================================
//     * 시간 더하기 유틸
//     * ==================================================
//     */
//
//    public static LocalTime addMinutes(LocalTime time, int minutes) {
//        return time.plusMinutes(minutes);
//    }
//
//    public static LocalDateTime addMinutes(LocalDateTime time, int minutes) {
//        return time.plusMinutes(minutes);
//    }
//
//    public static LocalDateTime addHours(LocalDateTime time, int hours) {
//        return time.plusHours(hours);
//    }
//
//}
//
