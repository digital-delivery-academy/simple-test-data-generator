package uk.co.evoco.testdata;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankHolidayTests {

    private BankHoliday bankHoliday = new BankHoliday();

    @Test
    public void testGetTitle() {
        bankHoliday.setTitle("test");
        assertThat(bankHoliday.getTitle(), is("test"));
    }

    @Test
    public void testGetLocalDate() {
        bankHoliday.setLocalDate("2019-02-01");
        assertThat(bankHoliday.getLocalDate("MM/dd/YYYY"), is("02/01/2019"));
    }
}
