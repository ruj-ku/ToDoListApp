package th.ac.ku.sci.todolistapp;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import th.ac.ku.sci.todolistapp.model.DataModel;
import th.ac.ku.sci.todolistapp.model.TodoItem;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MainPage {

    File saveFile = new File("todo.sav");

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
        this.isDoneColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<TodoItem, Boolean>, ObservableValue<Boolean>>() {
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<TodoItem, Boolean> c) {
                        return c.getValue().isDoneProperty();
                    }
                }
        );
        this.isDoneColumn.setCellFactory(CheckBoxTableCell.forTableColumn(isDoneColumn));
        this.titleColumn.setCellValueFactory(new PropertyValueFactory<TodoItem,String>("title"));
        this.createdColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("created"));
        this.startColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("start"));
        this.endColumn.setCellValueFactory(new PropertyValueFactory<TodoItem, Date>("end"));
        this.tableView.setItems(this.dataModel.getObservableList());

        this.tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    System.out.println("Old"+oldValue);
                    System.out.println("New"+newValue);
                });

        this.createRandomData();
    }



    @FXML
    public void addButtonActionHandler(ActionEvent e){

    }

    @FXML
    public void loadButtonActionHandler(ActionEvent e){
        if(saveFile.exists()) {
            try {
                this.dataModel.load(saveFile);
            } catch (Exception e1) {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Error reading "+saveFile.getAbsolutePath()+
                                ".\n"+ e1.getMessage(),
                        ButtonType.CLOSE);
                alert.show();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    saveFile.getAbsolutePath() + " does not exists.",
                    ButtonType.CLOSE);
            alert.showAndWait();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose new save file");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("TodoList save file", "*.sav"));
            this.saveFile = fileChooser.showOpenDialog(this.tableView.getScene().getWindow());
            if(this.saveFile != null){
                try {
                    this.dataModel.load(saveFile);
                } catch (Exception e1) {
                    alert = new Alert(Alert.AlertType.ERROR,
                            "Error reading "+saveFile.getAbsolutePath()+
                                    ".\n" + e1.getMessage(),
                            ButtonType.CLOSE);
                    alert.show();
                }
            }
        }
    }

    @FXML
    public void saveButtonActionHandler(ActionEvent e){
        if(saveFile.exists()) {
            try {
                this.dataModel.save(saveFile);
            } catch (IOException e1) {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        e1.getMessage(),
                        ButtonType.CLOSE);
                alert.show();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    saveFile.getAbsolutePath() + " does not exists.",
                    ButtonType.CLOSE);
            alert.showAndWait();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose new save file");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("TodoList save file", "*.sav"));
            this.saveFile = fileChooser.showSaveDialog(this.tableView.getScene().getWindow());
            if(this.saveFile != null){
                try {
                    this.dataModel.save(saveFile);
                } catch (IOException e1) {
                    alert = new Alert(Alert.AlertType.ERROR,
                            e1.getMessage(),
                            ButtonType.CLOSE);
                    alert.show();
                }
            }
        }
    }

    void createRandomData(){
        ObservableList<TodoItem> l = this.dataModel.getObservableList();

        for (int i = 0; i < 10; i++) {
            l.add(TodoItem.createRandomTodoItem());
        }
    }
}

