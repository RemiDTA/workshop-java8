package java8.ex01;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 01 - Les dates avant Java 8
 */
public class DateAndTime_01_Test {

    // Vous vous souvenez de java.util.Date (Java 1) ?
    @Test
    public void test_date() {

        // TODO modifier les paramètres pour que le test soit passant
        Date date = new Date(117, 2, 24, 0,0,3723);

        assertThat(date.toString(), is("Fri Mar 24 01:02:03 CET 2017"));

        // une date est mutable... :-(
        // TODO modifier le jour de la date pour que le test soit passant
        date = new Date(117, 2, 25, 0,0,3723);
        System.out.println(date);
        assertThat(date.toString(), is("Sat Mar 25 01:02:03 CET 2017"));
    }

    // Vous vous souvenez de java.util.Calendar (Java 1.1) ?

    @Test
    public void test_calendar() throws Exception {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(117, 2, 24, 0,0,3723);
        calendar.setTime(date);
        // TODO modifier l'objet calendar pour que le test soit passant

        assertThat(calendar.getTime().toString(), is("Fri Mar 24 01:02:03 CET 2017"));

        // calendar est mutable... :-(
        // TODO modifier l'objet calendar pour que le test soit passant
        calendar.add(Calendar.DATE, 1);
        assertThat(calendar.getTime().toString(), is("Sat Mar 25 01:02:03 CET 2017"));
    }


}
