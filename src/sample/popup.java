package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class popup {
    Stage window;
    public static void display(String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); //block user interaction with other window
        window.setTitle("Alert!");


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(10);

        Label label = new Label();
        label.setText(message);
        GridPane.setConstraints(label,0,1);

        Button close = new Button("Close");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });
        GridPane.setConstraints(close,1,2);
        grid.getChildren().addAll(label,close);

        Scene scene = new Scene(grid,500,400);
        window.setScene(scene);
        window.showAndWait();


    }
}
