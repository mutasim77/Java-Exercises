import java.util.Calendar;
import java.util.Scanner;
/*

(Display calendars) Rewrite the PrintCalendar class in Listing 6.12 to display a calendar
for a specified month using the Calendar and GregorianCalendar classes.
Your program receives the month and year from the command line. For example:
     java Exercise13_04 5 2016

*/

public class Task_13_4 {
    public static void main(String[] args) {
        String month1 = args[0]; // "5"
        String year1 = args[1]; // "2016"

        int year = Integer.valueOf(year1); // 2016
        int month = Integer.valueOf(month1); // 5

        printMonth(year, month);

    }

    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    public static void printMonthTitle(int year, int month) {
        System.out.println(" " + getMonthName(month) + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
        }
        return monthName;
    }

    public static void printMonthBody(int year, int month) {
        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        int i = 0;
        for (i = 0; i < startDay; i++)
            System.out.print(" ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public static int getStartDay(int year, int month){
        final int START_DAY_FOR_JAN_1_1800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    public static int getTotalNumberOfDays(int year, int month){
        int total = 0;

        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;
        }

        for (int i = 1; i < month; i++) {
            total = total + getNumberOfDaysInMonth(year, i);
        }

        return total;
    }

    public static int getNumberOfDaysInMonth(int year, int month){
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0;
    }

    public static boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
