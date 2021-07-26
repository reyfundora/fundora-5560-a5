package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ucf.assignments.appController.*;
import static ucf.assignments.menuEdit.*;
import static ucf.assignments.menuHelp.*;

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
        int expect = 2;

        values.add("$1.00");
        itemCounter++;
        serials.add("xxxxxxxxxx");
        itemCounter++;

        // when
        int actual = itemCounter;

        // then
        assertEquals(expect, actual);
    }
    @Test
    void isEditCounterWorking() throws IOException {
        // given
        int expect = 0;
        new appController();

        // when
        int actual = editCounter;

        // then
        assertEquals(expect, actual);
    }
    @Test
    void isTutorialSectionWorking() throws IOException {
        // given
        int expect = 0;
        new ucf.assignments.menuHelp();

        // when
        int actual = testGettingStarted;

        // then
        assertEquals(expect, actual);
    }
    @Test
    void isAboutSectionWorking() throws IOException {
        // given
        int expect = 0;
        new ucf.assignments.menuHelp();

        // when
        int actual = testAbout;

        // then
        assertEquals(expect, actual);
    }
    @Test
    void isClickNewTestWorking() throws IOException {
        // given
        int expect = 0;
        new appController();

        // when
        int actual = clickNewTest;

        // then
        assertEquals(expect, actual);
    }
    @Test
    void isClickDeleteTestWorking() throws IOException {
        // given
        int expect = 0;
        new appController();

        // when
        int actual = clickDeleteTest;

        // then
        assertEquals(expect, actual);
    }
}
