package th.ac.ku.sci.todolistapp;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import th.ac.ku.sci.todolistapp.model.DataModel;
import th.ac.ku.sci.todolistapp.model.TodoItem;

import java.util.Date;

public class MainPage {

    DataModel dataModel = DataModel.getInstance();

    @FXML
    TableView<TodoItem> tableView;

    @FXML
    TableColumn isDoneColumn;

    @FXML
    TableColumn titleColumn;

    @FXML
    TableColumn createdColumn;

    @FXML
    TableColumn startColumn;

    @FXML
    TableColumn endColumn;

    @FXML
    void initialize(){
        this.isDoneColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Boolean>("isDone"));
        this.titleColumn.setCellValueFactory(new PropertyValueFactory<TodoItem,String>("title"));
        this.createdColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("created"));
        this.startColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("start"));
        this.endColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("end"));
        this.tableView.setItems(this.dataModel.getObservableList());
        this.createRandomData();
    }

    void createRandomData(){
        ObservableList<TodoItem> l = this.dataModel.getObservableList();

        for (int i = 0; i < 10; i++) {
            l.add(TodoItem.createRandomTodoItem());
        }

    }
}

