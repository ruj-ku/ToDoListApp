package th.ac.ku.sci.todolistapp.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/** JUnit 5 test */

class DataModelTest {

    public File f;

    @Test
    void saveAndLoad() {
        DataModel dataModel = new DataModel();

        // Save null
        assertThrows(FileNotFoundException.class, () -> {dataModel.save(null);});

        // Load null
        assertThrows(FileNotFoundException.class, () -> {dataModel.load(null);});

        assertDoesNotThrow(() -> {
            f = File.createTempFile("save",".sav");
            f.delete();
        });

        assertFalse(f.exists());

        f.deleteOnExit();

        // Load non-existing file
        assertThrows(FileNotFoundException.class, () -> {dataModel.load(f);});

        // Save empty data
        assertDoesNotThrow(() -> {dataModel.save(f);});

        assertTrue(f.exists());

        assertDoesNotThrow(() -> {dataModel.load(f);});

        assertEquals(0,dataModel.getObservableList().size());

        ObservableList<TodoItem> l = dataModel.getObservableList();

        TodoItem[] todoItems = new TodoItem[5];
        for (int i = 0; i < 5; i++) {
            todoItems[i] = createRandomTodoItem();
            l.add(todoItems[i]);
        }

        assertDoesNotThrow(() -> {dataModel.save(f);});

        l.clear();

        assertDoesNotThrow(() -> {dataModel.load(f);});

        l = dataModel.getObservableList();

        int i = 0;
        for (TodoItem t:l) {
            assertEquals(todoItems[i],t);
            i++;
        }
    }

    TodoItem createRandomTodoItem(){
        Calendar c = Calendar.getInstance();
        Random random = new Random();
        c.set(2018,1+random.nextInt(11),1+random.nextInt(27));
        Date d1 = c.getTime();
        c.set(2018,1+random.nextInt(11),1+random.nextInt(27));
        Date d2 = c.getTime();
        c.set(2018,1+random.nextInt(11),1+random.nextInt(27));
        Date d3 = c.getTime();
        return new TodoItem("Title"+ random.nextInt(),
                "Detail"+random.nextInt(), d1,d2,d3);
    }
}