package uk.co.evoco.testdata;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankHolidaysTests {

    private BankHolidays bankHolidays = new BankHolidays();

    @Test
    public void testGetAndSetLocale() {
        bankHolidays.setLocale("scotland");
        assertThat(bankHolidays.getLocale(), is(Locale.SCOTLAND));
    }

    @Test
    public void testMixedCaseShouldNotFail() {
        bankHolidays.setLocale("sCotLaND");
        assertThat(bankHolidays.getLocale(), is(Locale.SCOTLAND));
    }

    @Test
    public void testNoEnumMatchThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> bankHolidays.setLocale("WRONG_ITEM"));
    }


}
