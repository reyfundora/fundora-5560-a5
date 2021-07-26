package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ucf.assignments.menuEdit.*;

public class appTest  {
    @Test
    void isValuesArrayListWorking() {
        // given
        String expect = "$1.00";
        values.add("$1.00");

        // when
        String actual = values.get(0);

        // then
        assertEquals(expect, actual);
    }
    @Test
    void isSerialsArrayListWorking() {
        // given
        String expect = "1234567890";
        serials.add("1234567890");

        // when
        String actual = serials.get(0);

        // then
        assertEquals(expect, actual);
    }
    @Test
    void isNamesArrayListWorking() {
        // given
        String expect = "testname";
        names.add("testname");

        // when
        String actual = names.get(0);

        // then
        assertEquals(expect, actual);
    }
    @Test
    void isItemCounterWorking() throws IOException {
        // given
        int expect = 0;

        // when
        int actual = itemCounter;

        // then
        assertEquals(expect, actual);
    }
}
