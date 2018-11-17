package th.ac.ku.sci.todolistapp;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    @org.junit.jupiter.api.Test
    void setStartSetEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(2018,01,01);
        Date start = cal.getTime();
        cal.set(2018,02,23);
        Date end = cal.getTime();
        cal.set(2018,02,10);
        Date mid = cal.getTime();
        TodoItem item = new TodoItem();
        item.setStart(start);
        assertEquals(item.getStart(),start);
        item.setEnd(end);
        assertEquals(item.getEnd(),end);
        item.setStart(null);
        assertEquals(item.getStart(),null);
        item.setEnd(null);
        assertEquals(item.getEnd(),null);
        item.setEnd(start);
        item.setStart(end);
        assertEquals(item.getStart(),start);
        assertEquals(item.getEnd(),end);
        item.setStart(null);
        item.setEnd(null);
        item.setStart(end);
        item.setEnd(start);
        assertEquals(item.getStart(),start);
        assertEquals(item.getEnd(),end);
        item.setEnd(mid);
        item.setStart(end);
        assertEquals(item.getStart(),mid);
        assertEquals(item.getEnd(),end);
        item.setEnd(start);
        assertEquals(item.getStart(),start);
        assertEquals(item.getEnd(),mid);
    }
}