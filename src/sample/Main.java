package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application{
    Button login,reset;
    Scene scene1,scene2;
    static Stage window;
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("MiniProject-Manoj");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(10);

        Label user = new Label("Username");
        GridPane.setConstraints(user,0,0);

        TextField username = new TextField();
        GridPane.setConstraints(username,1,0);

        Label p1 = new Label("Password");
        GridPane.setConstraints(p1,0,1);

        PasswordField password = new PasswordField();
        GridPane.setConstraints(password,1,1);

        login = new Button("Login");
        GridPane.setConstraints(login,0,2);
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String user = username.getText();
                String pass = password.getText();
                if(!user.equals("manoj") && !pass.equals("123")){
                    popup p = new popup();
                    p.display("Authentication Failed!!");
                }
                else{
                    Subjects.starter();
                }
            }
        });


        reset = new Button("Reset");
        GridPane.setConstraints(reset,1,2);
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                username.clear();
                password.clear();
            }
        });

        grid.getChildren().addAll(user,username,p1,password,login,reset);


        Scene scene = new Scene(grid,300,275);
        window.setScene(scene);
        window.show();
    }

}
