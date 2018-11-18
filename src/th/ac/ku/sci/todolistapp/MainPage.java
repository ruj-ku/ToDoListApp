package th.ac.ku.sci.todolistapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
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
    TextField titleTextField;

    @FXML
    TextArea detailArea;

    @FXML
    CheckBox startCheckBox;

    @FXML
    CheckBox endCheckBox;

    @FXML
    DatePicker startDatePicker;

    @FXML
    DatePicker endDatePicker;

    @FXML
    Button addButton;

    @FXML
    void initialize(){
        this.isDoneColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Boolean>("isDone"));
        this.isDoneColumn.setCellFactory(CheckBoxTableCell.forTableColumn(isDoneColumn));
        this.titleColumn.setCellValueFactory(new PropertyValueFactory<TodoItem,String>("title"));
        this.createdColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("created"));
        this.startColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("start"));
        this.endColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("end"));
        this.tableView.setItems(this.dataModel.getObservableList());
        this.createRandomData();
    }

    @FXML
    public void addButtonActionHandler(ActionEvent e){

    }

    @FXML
    public void loadButtonActionHandler(ActionEvent e){

    }

    @FXML
    public void saveButtonActionHandler(ActionEvent e){

    }

    void createRandomData(){
        ObservableList<TodoItem> l = this.dataModel.getObservableList();

        for (int i = 0; i < 10; i++) {
            l.add(TodoItem.createRandomTodoItem());
        }


    }
}

