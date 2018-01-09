package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;

import static sample.Subjects.scene1;


public class Pool{


    static Stage window;
    Button insert,modify,delete,generate,back;
    BufferedReader a;

    public  void show(String url,String sub) {
        window = Main.window;
        window.setTitle("Pool Of Questions");

        ListView listView = new ListView();
        listView.setPrefSize(600, 350);
        listView.setEditable(true);
        //(line = b.readLine())!=null
        boolean x = true;
        int i = 0;
        String l="";
        FlowPane f;
        try {
            BufferedReader b = new BufferedReader(new FileReader(new File(url))); {
                while (b.ready()) {
                    a=b;
                    try{
                        i++;
                        StringBuilder question = new StringBuilder();
                        question.append(i);
                        question.append(".");
                        question.append("  ");
                        question.append(b.readLine());
                        question.append("\n");

                        question.append("a");
                        question.append(".");
                        question.append(b.readLine());
                        question.append("  ");
                        question.append("\n");

                        l = b.readLine();

                        if (l == null) {
                            x = false;
                            listView.getItems().add(question);
                            break;
                        }
                        else if("".equals(l)) {
                            System.out.println(l);
                            listView.getItems().add(question);
                            continue;
                        }
                        else {
                            question.append("b");
                            question.append(".");
                            question.append(l);
                            question.append("\n");
                        }
                        l = b.readLine();

                        if (l == null) {

                            x = false;
                            listView.getItems().add(question);
                            break;
                        }
                        else if("".equals(l)) {
                            System.out.println(1);
                            System.out.println(l);
                            listView.getItems().add(question);
                            continue;

                        }
                        else {
                            System.out.println(2);
                            question.append("c");
                            question.append(".");
                            question.append(l);
                            question.append("\n");
                        }
                        l = b.readLine();
                        if (l == null) {
                            x = false;
                            listView.getItems().add(question);
                            break;
                        }
                        else if("".equals(l)) {
                            System.out.println(l);
                            listView.getItems().add(question);
                            continue;
                        }
                        else{
                            question.append("d");
                            question.append(".");
                            question.append(l);
                            question.append("\n");
                        }
                        System.out.println(i);
                        listView.getItems().add(question);
                        l = b.readLine();
                        if (l == null) {
                            x = false;
                            break;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File does not exist");
                    } catch (IOException e) {
                        System.out.println("exception while reading file");
                    }
                }
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        insert = new Button("Insert");
        insert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String q = null;
                Popup2 p = new Popup2();
                p.display1(url,sub,q,1);
                System.out.println("123");
            }
        });
        modify = new Button("Modify");
        modify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s = listView.getSelectionModel().getSelectedItem().toString();
                String[] result = s.split("\r\n|\r|\n", 2);
                String q = result[0].substring(4, result[0].length());
                Popup2 p = new Popup2();
                methods.delete(listView,url,sub);
                p.display1(url,sub,q,2);

            }
        });
        delete = new Button("Delete");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                methods m = new methods();
                m.delete(listView,url,sub);
            }
        });
        generate = new Button("Generate");
        generate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generatepop p =new generatepop();
                p.display(url);
            }
        });
        back = new Button("Return");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(scene1);
                window.show();
            }
        });

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(insert,modify,delete,generate,back);

        f = new FlowPane();
        window.setScene(new Scene(f, 600, 400));
        f.getChildren().addAll(hbox,listView);

        window.show();
    }
}
