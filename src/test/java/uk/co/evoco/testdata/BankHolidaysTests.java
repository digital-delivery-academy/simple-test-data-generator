package uk.co.evoco.testdata;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankHolidaysTests {

    private BankHolidays bankHolidays = new BankHolidays();

    @Test
    public void testGetAndSetLocale() {
        bankHolidays.setLocale("scotland");
        assertThat(bankHolidays.getLocale(), is(Locale.SCOTLAND));
    }
}
