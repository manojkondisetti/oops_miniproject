package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Popup2 {
    public void display1(String url,String sub,String ques,int a){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //block user interaction with other window
        window.setTitle("Alert!");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(10);

        Label user = new Label("Question");
        GridPane.setConstraints(user,0,0);

        TextField t1 = new TextField();
        GridPane.setConstraints(t1,0,1);
        t1.setText(ques);

        ChoiceBox box = new ChoiceBox();
        box.getItems().add("MCQ");
        box.getItems().add("True or False");
        box.getItems().add("Fill in the blanks");
        box.setValue("MCQ");
        GridPane.setConstraints(box,0,2);

        Label l2 = new Label("Enter Options");
        GridPane.setConstraints(l2,0,3);
        l2.setVisible(false);

        TextField op0 = new TextField();
        GridPane.setConstraints(op0,0,4);
        op0.setVisible(false);

        TextField op1 = new TextField();
        GridPane.setConstraints(op1,0,5);
        op1.setVisible(false);

        TextField op2 = new TextField();
        GridPane.setConstraints(op2,0,6);
        op2.setVisible(false);

        TextField op3 = new TextField();
        GridPane.setConstraints(op3,0,7);
        op3.setVisible(false);


        Button submit = new Button("Submit");
        GridPane.setConstraints(submit,2,4);
        submit.setVisible(false);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String q = t1.getText();
                System.out.println(q);
                String o0 = op0.getText();
                String o1 = op1.getText();
                String o2 = op2.getText();
                String o3 = op3.getText();

                methods m = new methods();
                m.add(q,o0,o1,o2,o3,url,sub,a);


            }
        });

        Button next = new Button("Next");
        GridPane.setConstraints(next,1,2);
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(box.getValue()=="MCQ"){
                    l2.setVisible(true);
                    op0.setVisible(true);
                    op1.setVisible(true);
                    op2.setVisible(true);
                    op3.setVisible(true);
                    submit.setVisible(true);
                    box.setDisable(true);
                    next.setDisable(true);
                }
                else if(box.getValue()=="True or False"){
                    l2.setVisible(true);
                    op0.setVisible(true);
                    op0.setText("True");
                    op0.setDisable(true);
                    op1.setVisible(true);
                    op1.setText("False");
                    op1.setDisable(true);
                    submit.setVisible(true);
                    box.setDisable(true);
                    next.setDisable(true);
                }
                else if(box.getValue()=="Fill in the blanks"){
                    l2.setVisible(true);
                    op0.setVisible(true);
                    op0.setText("___________________________");
                    op0.setDisable(true);
                    submit.setVisible(true);
                    box.setDisable(true);
                    next.setDisable(true);
                }
            }
        });

        Button close = new Button("Close");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });
        GridPane.setConstraints(close,3,4);

        grid.getChildren().addAll(user,t1,box,next,op0,op1,op2,op3,l2,submit,close);

        Scene scene = new Scene(grid,500,400);
        window.setScene(scene);
        window.showAndWait();
    }

}
