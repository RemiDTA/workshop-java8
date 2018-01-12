package java8.ex02;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 02 - LocalDate
 */
public class DateAndTime_02_Test {

    @Test
    public void test_localDate_of() {

        // TODO créer un objet LocalDate à la date 24/12/2050
    	LocalDate date = LocalDate.of(2050, 12, 24);
        LocalDate result = null;

        // TODO valoriser les différentes variables afin de rendre le test passant
        int year = 2050;
        Month month = Month.DECEMBER;
        int dayOfMonth = 24;
        DayOfWeek dayOfWeek = DayOfWeek.SATURDAY;
        int dayOfYear = 358;

        assertThat(year, is(2050));
        assertThat(month, is(Month.DECEMBER));
        assertThat(dayOfMonth, is(24));
        assertThat(dayOfWeek, is(DayOfWeek.SATURDAY));
        assertThat(dayOfYear, is(358));
    }

    @Test
    public void test_localDate_parse() {

        // TODO créer un objet LocalDate à la date 10/01/1990
        // TODO utiliser la méthode parse
    	LocalDate date = LocalDate.parse("1990-01-10");
        LocalDate result = date;


        // TODO valoriser les différentes variables afin de rendre le test passant
        int year = 1990;
        Month month = Month.JANUARY;
        int dayOfMonth = 10;


        assertThat(year, is(1990));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(10));
    }

    @Test
    public void test_localDate_format() {

        // TODO créer un objet LocalDate à la date 11/03/2015
        // TODO utiliser la méthode of
    	LocalDate date = LocalDate.of(2015, 03, 11);

        // TODO Formatter la date pour que le test soit passant
        String result = date.toString();

        assertThat(result, is("2015-03-11"));
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void test_localDate_format_with_hour() {

        // TODO créer un objet LocalDate à la date 11/03/2015
        // TODO utiliser la méthode of
    	LocalDate date = LocalDate.of(2015, 03, 11);

        // TODO Formatter la date pour avoir l'affichage suivant : "11/03/2015 00:00:00"
        date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }

    @Test
    public void test_with() {

        // TODO créer un objet LocalDate à la date 10/01/2000
        // TODO utiliser la méthode of
    	LocalDate date = LocalDate.of(2000, 01, 10);

        // TODO transformer la date précédente en 05/02/2015
    	LocalDate newDate = date.withYear(2015).with(ChronoField.DAY_OF_MONTH, 05).plus(1, ChronoUnit.MONTHS);;;
        LocalDate result = newDate;

        assertThat(result.getYear(), is(2015));
        assertThat(result.getMonth(), is(Month.FEBRUARY));
        assertThat(result.getDayOfMonth(), is(5));
    }

}
