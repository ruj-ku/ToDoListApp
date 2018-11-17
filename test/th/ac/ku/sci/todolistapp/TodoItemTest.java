package th.ac.ku.sci.todolistapp;

import org.junit.jupiter.api.Test;
import th.ac.ku.sci.todolistapp.model.TodoItem;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


/** JUnit 5 test */

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
        assertEquals(null,item.getStart());
        item.setEnd(null);
        assertEquals(null,item.getEnd());
        item.setEnd(start);
        item.setStart(end);
        assertEquals(start, item.getStart());
        assertEquals(end, item.getEnd());
        item.setStart(null);
        item.setEnd(null);
        item.setStart(end);
        item.setEnd(start);
        assertEquals(start, item.getStart());
        assertEquals(end,item.getEnd());
        item.setEnd(mid);
        item.setStart(end);
        assertEquals(mid,item.getStart());
        assertEquals(end,item.getEnd());
        item.setEnd(start);
        assertEquals(start,item.getStart());
        assertEquals(mid,item.getEnd());
    }

    @Test
    void equal(){
        TodoItem t1 = new TodoItem();
        TodoItem t2 = new TodoItem();

        assertFalse(t1.equals(null));
        assertTrue(t1.equals(t2));

        t1.title = "a";
        assertFalse(t1.equals(t2));
        t2.title = "a";
        assertTrue(t1.equals(t2));

        t1.detail = "da";
        assertFalse(t1.equals(t2));
        t1.title = "b";
        assertFalse(t1.equals(t2));
        t2.title = "b";
        assertFalse(t1.equals(t2));

        t2.detail = "da";
        assertTrue(t1.equals(t2));
        t1.title = "a";
        assertFalse(t1.equals(t2));
        t2.title = "a";
        assertTrue(t1.equals(t2));

        // More to test for all combinations
    }
}