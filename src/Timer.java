public class Timer {

    /** Timer class just provides method numToTime to
     * convert an int to a time format string.
     */

    public static String numToTime(int number){
        int hour = number / 3600;
        int minute = (number % 3600) / 60;
        int second = (number % 60);
        return Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second);
    }
}