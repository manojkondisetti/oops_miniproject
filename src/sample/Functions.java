package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static sample.Subjects.scene1;
import static sample.Subjects.scene2;

public class Functions {
    static Stage window;
    Button insert,modify,delete,generate,back;
    public void begin(String sub){
        window = Main.window;
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(10);

        insert = new Button("Insert");
        GridPane.setConstraints(insert,0,0);
        insert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });

        modify = new Button("Modify");
        GridPane.setConstraints(modify,0,1);

        delete = new Button("Delete");
        GridPane.setConstraints(delete,0,2);

        generate = new Button("Generate");
        GridPane.setConstraints(generate,0,3);

        back = new Button("Return");
        GridPane.setConstraints(back,1,4);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene1);
                window.show();
            }
        });

        grid.getChildren().addAll(insert,modify,delete,generate,back);

        scene2 = new Scene(grid,300,275);
        window.setScene(scene2);
        window.show();
    }

}
