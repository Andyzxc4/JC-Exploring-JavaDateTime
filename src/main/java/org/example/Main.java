package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        /*
        Prediction:
        Declare a LocalDate representing August 21, 2025. It then defines two custom date
        formats: one in the "dd/MM/yyyy" pattern and another in a full, readable format like
         "Thursday, August 21, 2025". The program prints the default ISO format (2025-08-21) and both
         custom-formatted versions of the date.

        Output:
        Default format: 2025-08-21
        Custom format 1: 21/08/2025
        Custom format 2: Thursday, August 21, 2025
         */

        LocalDate sampleDate = LocalDate.of(2025, 8, 21);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy", Locale.ENGLISH);

        System.out.println("Default format: " + sampleDate);
        System.out.println("Custom format 1: " + sampleDate.format(dtf1));
        System.out.println("Custom format 2: " + sampleDate.format(dtf2));

        /*
        Prediction:
        The output will show the default time format as 16:45:30. The 24-hour custom format also
        displays 16:45:30. The 12-hour format with AM/PM converts it to 04:45:30 PM. This is because
        LocalTime.of(16, 45, 30) represents 4:45:30 in the afternoon.

        Output:
            Default format: 16:45:30
            24-hour format: 16:45:30
            12-hour format with AM/PM: 04:45:30 PM
         */
        System.out.println(" ");
        LocalTime timeNow = LocalTime.of(16, 45, 30);

        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("hh:mm:ss a");

        System.out.println("Default format: " + timeNow);
        System.out.println("24-hour format: " + timeNow.format(dtf3));
        System.out.println("12-hour format with AM/PM: " + timeNow.format(dtf4));

        /*
        Prediction:
        The output will display the default format as 2025-11-27T19:00, following ISO-8601. The custom format will
        show Nov 27, 2025 at 07:00 PM, since 19:00 in 24-hour time converts to 07:00 PM in 12-hour format.

        Output:
            Default format: 2025-11-27T19:00
            Custom format: Nov 27, 2025 at 07:00 PM

         */
        LocalDateTime event = LocalDateTime.of(2025, 11, 27, 19, 0, 0);

        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("MMM dd, yyyy 'at' hh:mm a");

        System.out.println(" ");
        System.out.println("Default format: " + event);
        System.out.println("Custom format: " + event.format(dtf5));

        /*
        Prediction:
        The output will show that the start date remains 2025-08-07 even after calling plusDays(7),
        because LocalDate is immutable. The new end date will be 2025-08-14, which is the result of explicitly
        assigning the modified date to a new variable.

        Output:
            Start date after trying to modify it: 2025-08-07
            The original start date is still: 2025-08-07
            The new end date is: 2025-08-14
         */
        LocalDate startDate = LocalDate.of(2025, 8, 7);

        startDate.plusDays(7);

        System.out.println(" ");
        System.out.println("Start date after trying to modify it: " + startDate);

        LocalDate endDate = startDate.plusDays(7);

        System.out.println("The original start date is still: " + startDate);
        System.out.println("The new end date is: " + endDate);

        /*
        Prediction:
        The output will show the base time as 2022-12-12 19:25. The future time adds 3 years, 1 month, and 7 hours,
        resulting in 2026-01-13 02:25. The pastime subtracts 2 weeks and 4 days, giving 2022-11-24 19:25.

        Output:
            Base time:   2022-12-12 19:25
            Future time: 2026-01-13 02:25
            Pastime:   2022-11-24 19:25
         */
        LocalDateTime baseTime = LocalDateTime.of(2022, 12, 12, 19, 25, 12);

        LocalDateTime futureTime = baseTime.plusYears(3).plusMonths(1).plusHours(7);
        LocalDateTime pastTime = baseTime.minusWeeks(2).minusDays(4);

        DateTimeFormatter dtf6 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println(" ");
        System.out.println("Base time:   " + baseTime.format(dtf6));
        System.out.println("Future time: " + futureTime.format(dtf6));
        System.out.println("Past time:   " + pastTime.format(dtf6));

        /*
        Prediction:
        The output will show the period between December 2, 2002, and December 2, 2025, as 23 years, 0 months, and 0 days,
        since the dates share the same month and day, and only differ by 23 full years.

        Output:
            The period between the two dates is: 23 years, 0 months, and 0 days.
         */
        LocalDate date1 = LocalDate.of(2002, 12, 2);
        LocalDate date2 = LocalDate.of(2025, 12, 2);

        Period period = Period.between(date1, date2);

        System.out.println(" ");
        System.out.print("The period between the two dates is: ");
        System.out.print(period.getYears() + " years, ");
        System.out.print(period.getMonths() + " months, and ");
        System.out.println(period.getDays() + " days.");


    }
}