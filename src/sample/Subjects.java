package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static sample.popup.display;

public class Subjects  {
    static Stage window;
    static Button maths,physics,chemistry,logout;
    static Scene scene1,scene2;
    public static void  starter(){
        window = Main.window;
        window.setTitle("MiniProject-Manoj");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(10);

        maths = new Button("Mathematics");
        GridPane.setConstraints(maths,0,0);
        maths.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Functions f = new Functions();
                //f.begin("C:/Users/manoj/IdeaProjects/Mini/maths.txt");
                Pool p = new Pool();
                p.show("C:/Users/manoj/IdeaProjects/Mini/Maths/maths.txt","maths");
            }
        });

        physics = new Button("Physics");
        GridPane.setConstraints(physics,0,1);
        physics.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pool p = new Pool();
                p.show("C:/Users/manoj/IdeaProjects/Mini/Physics/physics.txt","physics");
            }
        });

        chemistry = new Button("Chemistry");
        GridPane.setConstraints(chemistry,0,2);
        chemistry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pool p = new Pool();
                p.show("C:/Users/manoj/IdeaProjects/Mini/Chemistry/chemistry.txt","chemistry");
            }
        });

        logout = new Button("Logout");
        GridPane.setConstraints(logout,2,3);
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                display("Succesfully Logged out");
            }
        });

        grid.getChildren().addAll(maths,physics,chemistry,logout);


        scene1 = new Scene(grid,300,275);
        window.setScene(scene1);
        window.show();
    }
}
