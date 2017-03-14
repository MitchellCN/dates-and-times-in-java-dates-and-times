package com.theironyard;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;



/**
 * This class provides a set of static properties and methods used to calculate
 * when holidays and other significant dates fall and how many days there are
 * until the next occurrence.
 *
 * As a part of this exercise you will have to make use of a number of classes
 * and enumerations in the java.time package.
 *
 * Follow the instructions below to create the class.
 */
public class SignificantDate {



    /**
     * Start this class by creating a set of read only static properties that
     * are publicly accessible. Remember, the final keyword is used to make a
     * property read only. Each of the properties will represent a month and
     * day without a year. Java provides a class named java.time.MonthDay which
     * meets this requirement.
     *
     * http://docs.oracle.com/javase/8/docs/api/java/time/MonthDay.html
     *
     * Create properties for at least the following dates:
     *
     * - New Years Day: January 1st
     * - Valentines Day: February 14th
     * - Leap Year: February 29th
     * - Fourth Of July: July 4th
     * - Christmas: December 25th
     * - New Years Eve: December 31st
     *
     * Be sure to give each of these properties a reasonable name that follows
     * convention. For example, GROUNDHOG_DAY. BECAUSE THEY ARE IMMUTABLE CANT BE CHANGED
     *
     * The MonthDay class is consistent with the rest of the java.time package
     * in that you can't simply create am instance using the new keyword.
     * Instead, you will need to use it's of() method:
     *
     * http://docs.oracle.com/javase/8/docs/api/java/time/MonthDay.html#of-java.time.Month-int-
     *
     * When setting the month for the new MonthDay, you are not allowed to use
     * the number of the month. EG, `MonthDay.of(12, 9)` is forbidden because
     * you explicitly used the number 12 for December. Instead, use the
     * java.time.Month enumeration. Enumerations are similar to classes, except
     * that they restrict values to a specific range. This enum has static
     * properties representing each month:
     *
     * http://docs.oracle.com/javase/8/docs/api/java/time/Month.html#enum.constant.summary
     *
     * Here's a allowable example for Groundhog Day:
     *
     * MonthDay.of(Month.FEBRUARY, 2);
     */






    // todo: create a New Years Day property
    public static final MonthDay NEW_YEARS_DAY = MonthDay.of(Month.JANUARY, 1);

    // todo: create a Valentines Day property
    public static final MonthDay VALENTINES_DAY = MonthDay.of(Month.FEBRUARY, 14);

    // todo: create a Leap Year property
    public static final MonthDay LEAP_YEAR = MonthDay.of(Month.FEBRUARY, 29);

    // todo: create a Fourth of July property
    public static final MonthDay FOURTH_OF_JULY = MonthDay.of(Month.JULY, 4);

    // todo: create a Christmas property
    public static final MonthDay CHRISTMAS = MonthDay.of(Month.DECEMBER, 25);

    // todo: create a New Years Eve property
    public static final MonthDay NEW_YEARS_EVE = MonthDay.of(Month.DECEMBER, 31);

    /**
     * The next() method returns a LocalDate object that represents the date of
     * the next occurrence of the specified MonthDay. For example, if today were
     * 1/3/2017, the next instance of New Years Day would be 1/1/2018. The next
     * occurrence of leap year would be 2/29/2014.
     *
     * This method should be static.
     *
     * @param date A month and day we're looking for the next occurrence of
     * @return The next occurrence of the specified date
     */
    // todo: Implement the next() method by following the instructions below
public static LocalDate next(MonthDay date) {




        /*
            Create a variable named "now" that holds the date for today. The
            datatype to use would be java.time.LocalDate. You can use the
            LocalDate's now() method to get the current date.

            http://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#now--
         */
    // todo: create a variable named now
    LocalDate now = LocalDate.now();

        /*
            The LocalDate class has a method on it, getYear(), that will return
            the year as an integer. Use that to create a new variable named
            "year".
         */
    // todo: create a variable named year
    int year = now.getYear();

        /*
            Now that we know the year, we need to find the next valid occurrence
            of the specified MonthDay that is in the future. We can do this
            using a while loop. You should loop until you find a valid year for
            the date that is after today.

            The MonthDay class has a method isValidYear() that returns true if
            a date occurs in that year. This method is useful because it will
            return false if we're looking for February 29th in a year that
            doesn't have a leap year. For example, February 29th, 2017 would
            return false.

            http://docs.oracle.com/javase/8/docs/api/java/time/MonthDay.html#isValidYear-int-

            The MonthDay class has another method, atYear() that returns a
            LocalDate object for the month and day in the specified year. This
            is useful for getting a reference to a date in a particular year.

            http://docs.oracle.com/javase/8/docs/api/java/time/MonthDay.html#atYear-int-

            The LocalDate class has a method named isAfter() that will return
            true if the date is after the the specified date. We can use this to
            see if a date at a specific year is after today's date.

            http://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#isAfter-java.time.chrono.ChronoLocalDate-

            Knowing all of the above, we can loop from this year into the future
            until we find the next valid instance of a date that is in the
            future.

            Keep in mind that if we're at January 3 2017, the next instance of
            Valentines Day is still this year and the next occurrence of New
            Years Day is in 2018.

           // date == the date to find (IE: July 4th)
           // year == the year were check(initially 2017)
           // now == today(LocalDate)
         */

    // 1 get the monthAndDate for the current year

    //LocalDate theDateInCurrentYear = aMonthAndDayToFindInTheFuture.atYear(theCurrentYear);
    LocalDate dateForYear = date.atYear(year);
    boolean isValidForThisYear = date.isValidYear(year);
    boolean isInFuture = dateForYear.isAfter(now);
    // todo: loop while the MonthDate is not valid for the specified year or the MonthDate for this year is not after today


    while (!(dateForYear.isAfter(now)) || !(date.isValidYear(year))) {


        dateForYear = date.atYear(year);


        // todo: increment the year variable so we can try the subsequent year

        year = year + 1;

        // once you've found the next instance of the date, return it!
        // todo: return the next occurrence of the specified date

    }
        return date.atYear(year);


}

    /**
     * Create a static method name daysTo() that accepts a MonthDay argument
     * named date and returns a long representing the number of days to the next
     * occurrence of the MonthDay.
     *
     * For example, if today is January 3 2017, the next occurrence of New Years
     * Day is Jan 1 2018. This means that there are 362 days to New Years Day.
     *
     * @param date The date to get the number of days until
     * @return The number of days until the specified date
     */
    // todo: create the daysTo() method

    public static long daysTo(MonthDay date){
        LocalDate nextDate = next(date);
        long numDays = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), nextDate);


        return numDays;



       /*
            We already have a method named next() that will give us the next
            occurrence of a specified date. Use that method to get the next
            occurrence of the MonthDay. Store this in a variable named nextDate.
         */
    // todo: create nextDate variable and set it to the next instance of the date


        /*
            The java.time package has another enumeration (similar to Month)
            called java.time.temporal.ChronoUnit. The ChronoUnit enum has
            definitions for common time units. EG: days, weeks, hours, etc. One
            such example is java.time.temporal.ChronoUnit.DAYS. DAYS has a
            method called between() that returns the number of days between two
            LocalDates.

            https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html#between-java.time.temporal.Temporal-java.time.temporal.Temporal-

            Here's an example usage of DAYS.between():

            java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), NEW_YEARS_EVE)

            DAYS.between() returns a long.
         */
    // todo: return the number of days between today and the nextDate


}

        }
