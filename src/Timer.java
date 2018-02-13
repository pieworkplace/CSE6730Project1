public class Timer {

    public static String numToTime(int number){
        int hour = number / 3600;
        int minute = (number % 3600) / 60;
        int second = (number % 60);
        return Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second);
    }
}