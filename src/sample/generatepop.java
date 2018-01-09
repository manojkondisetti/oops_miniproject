package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class generatepop {
    Stage window;
    public static void display(String url){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL); //block user interaction with other window
        window.setTitle("Generate");


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(10);

        Label label = new Label();
        label.setText("Enter No Of Questions");
        GridPane.setConstraints(label,0,1);
        Label label2 = new Label();
        label2.setText("Test is generated!!");
        GridPane.setConstraints(label2,0,4);
        label2.setVisible(false);

        TextField q = new TextField();
        GridPane.setConstraints(q,0,2);

        Label l2 = new Label();
        l2.setText("Location:C:\\Users\\manoj\\IdeaProjects\\Mini\\Generated Test\\test.txt");
        l2.setVisible(false);
        GridPane.setConstraints(l2,0,3);
        Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methods m = new methods();
                int k;
                String n = q.getText();
                k = Integer.parseInt(n);
                m.generate(k,url);
                label2.setVisible(true);
                l2.setVisible(true);
            }
        });
        GridPane.setConstraints(submit,0,5);

        Button close = new Button("Close");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                q.setDisable(true);
                window.close();
            }
        });
        GridPane.setConstraints(close,1,5);
        grid.getChildren().addAll(label,submit,label2,q,close,l2);

        Scene scene = new Scene(grid,500,500);
        window.setScene(scene);
        window.showAndWait();


    }
}
