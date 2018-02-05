package sample; /**
 * Created by user on 26.11.2017.
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static sample.Const.*;


public class CreateShopListController {
    @FXML
    private AnchorPane pane2;
    @FXML
    Button[] buttons= new Button[shoplength];
    Button[] deleteButtons = new Button[shoplength];
    public static int shopsK=0;
    @FXML
    public void initialize() throws Exception{
        int y=20;

        for(int i=0;i<shoplength;i++) {
            buttons[i] = new Button(shops.get(i).shopName);
            buttons[i].setLayoutY(y);
            buttons[i].setLayoutX(25);

            final int ii=i;

            deleteButtons[i] = new Button("-");
            deleteButtons[i].setLayoutY(y);
            y=y+30;
            deleteButtons[i].setLayoutX(3);


            deleteButtons[i].setOnAction(event -> {
                Pane pane=new Pane();
                Label l1=new Label("Введите пароль");
                PasswordField p1=new PasswordField();
                Button b1=new Button("Ввод");
                l1.setLayoutY(10);
                l1.setLayoutX(25);
                p1.setLayoutY(50);
                p1.setLayoutX(50);
                b1.setLayoutY(100);
                b1.setLayoutX(50);

                pane.getChildren().add(l1);pane.getChildren().add(p1);pane.getChildren().add(b1);
                Scene scene=new Scene(pane,250,150);
                Stage stage2=new Stage();
                stage2.setScene(scene);
                stage2.setTitle("Введите пароль");
                stage2.show();
                b1.setOnMouseClicked(event1 -> {
                    if(shops.get(ii).password.compareTo(p1.getText())==0) {
                        shops.remove(ii);
                        shoplength--;
                        ((Stage)b1.getScene().getWindow()).close();
                        shopsK--;
                    }
                    save();
                });
            });
            buttons[i].setOnAction(event ->{

                Pane pane=new Pane();
                Label l1=new Label("Введите пароль");
                PasswordField p1=new PasswordField();
                Button b1=new Button("Ввод");
                l1.setLayoutY(10);
                l1.setLayoutX(25);
                p1.setLayoutY(50);
                p1.setLayoutX(50);
                b1.setLayoutY(100);
                b1.setLayoutX(50);

                pane.getChildren().add(l1);pane.getChildren().add(p1);pane.getChildren().add(b1);
                Scene scene=new Scene(pane,250,150);
                Stage stage2=new Stage();
                stage2.setScene(scene);
                stage2.setTitle("Введите пароль");
                stage2.show();
                b1.setOnAction(event1 -> {
                    if(shops.get(ii).password.compareTo(p1.getText())==0) {
                        Stage stage = new Stage();
                        Label povorot=new Label("Поворот прилавка"), dlina=new Label("Длина прилавка"), shirina=new Label("Ширина прилавка");
                        TextField rotate1=new TextField(),w=new TextField(),h=new TextField();
                        Button deleteLast=new Button("Удалить последний элемент");
                        ToggleButton tog=new ToggleButton("Пустой прилавок");
                        tog.setLayoutX(25);
                        tog.setLayoutY(100);
                        rotate1.setLayoutY(150);
                        rotate1.setLayoutX(25);
                        w.setLayoutX(25);
                        w.setLayoutY(200);
                        h.setLayoutX(25);
                        h.setLayoutY(250);
                        deleteLast.setLayoutX(25);
                        deleteLast.setLayoutY(300);
                        povorot.setLayoutX(25);
                        povorot.setLayoutY(130);
                        dlina.setLayoutX(25);
                        dlina.setLayoutY(180);
                        shirina.setLayoutX(25);
                        shirina.setLayoutY(230);
                        Canvas canvas=new Canvas(500,500);
                        canvas.setLayoutX(200);
                        shops.get(ii).shopPaneEdit.getChildren().add(tog);shops.get(ii).shopPaneEdit.getChildren().add(povorot);shops.get(ii).shopPaneEdit.getChildren().add(dlina);shops.get(ii).shopPaneEdit.getChildren().add(shirina);shops.get(ii).shopPaneEdit.getChildren().add(canvas);shops.get(ii).shopPaneEdit.getChildren().add(rotate1);shops.get(ii).shopPaneEdit.getChildren().add(w);shops.get(ii).shopPaneEdit.getChildren().add(h);shops.get(ii).shopPaneEdit.getChildren().add(deleteLast);
                        GraphicsContext gr=canvas.getGraphicsContext2D();
                        gr.setLineWidth(2);
                        gr.strokeLine(0,0,0,500);
                        gr.strokeLine(0,500,500,500);
                        gr.strokeLine(500,500,500,0);
                        gr.strokeLine(500,0,0,0);
                        canvas.setOnMousePressed(event2 -> {
                            ImageView im=new ImageView("/sample/prilavok.jpg");

                            double rr=Double.parseDouble(rotate1.getText()),hh=Double.parseDouble(h.getText()),ww=Double.parseDouble(w.getText());
                            shops.get(ii).p.add(new prilavok(rr,hh,ww));
                            im.setLayoutX(event2.getX()-ww/2+200);
                            im.setLayoutY(event2.getY()-hh/2);
                            im.setRotate(rr);
                            im.setFitHeight(hh);
                            im.setFitWidth(ww);
                            shops.get(ii).shopPaneEdit.getChildren().add(im);
                        });


                        canvas.setOnMouseReleased(event2 -> {

                            double rr = Double.parseDouble(rotate1.getText()), hh = Double.parseDouble(h.getText()), ww = Double.parseDouble(w.getText());
                            shops.get(ii).p.get(shops.get(ii).p.size() - 1).X = (event2.getX() - ww);
                            if (event2.getX() + ww / 2 > 500) {
                                shops.get(ii).p.get(shops.get(ii).p.size() - 1).X = 500 - ww - ww / 2;
                            }
                            if (event2.getX() - ww / 2 < 0) {
                                shops.get(ii).p.get(shops.get(ii).p.size() - 1).X = 0 - ww / 2;
                            }
                            shops.get(ii).p.get(shops.get(ii).p.size() - 1).Y = (event2.getY() - hh);
                            if (event2.getY() - hh / 2 < 0) {
                                shops.get(ii).p.get(shops.get(ii).p.size() - 1).Y = 0 - hh / 2;
                            }
                            if (event2.getY() + hh / 2 > 500) {
                                shops.get(ii).p.get(shops.get(ii).p.size() - 1).Y = 500 - hh - hh / 2;
                            }


                            int iii=shops.get(ii).p.size()-1;

                            Node node=shops.get(ii).shopPaneEdit.getChildren().get(shops.get(ii).shopPaneEdit.getChildren().size()-1);
                            ////////////////////////////////////////////////
                            node.setOnMouseClicked(event3 -> {
                                if(event3.isControlDown()){
                                    shops.get(ii).shopPaneEdit.getChildren().remove(node);
                                    shops.get(ii).p.remove(iii);
                                }else{

                                Pane pane1 = new Pane();
                                System.out.println(shops.get(ii).p.get(shops.get(ii).p.size() - 1).Y + " " + shops.get(ii).p.get(shops.get(ii).p.size() - 1).X);
                                TextField addt = new TextField("");
                                Button add = new Button("Добавить"), remove = new Button("-");
                                addt.setLayoutX(25);
                                addt.setLayoutY(250);
                                add.setLayoutX(185);
                                add.setLayoutY(250);
                                remove.setLayoutX(250);
                                remove.setLayoutY(250);
                                pane1.getChildren().add(addt);
                                pane1.getChildren().add(add);
                                pane1.getChildren().add(remove);
                                ListView<String> listView = new ListView();
                                for(int j=0;j<shops.get(ii).p.get(iii).products.size();j++){
                                    listView.getItems().add(shops.get(ii).p.get(iii).products.get(j));
                                }
                                listView.setLayoutX(25);
                                listView.setLayoutY(25);
                                listView.setPrefHeight(160);
                                pane1.getChildren().add(listView);
                                add.setOnMouseClicked(event4 -> {
                                    listView.getItems().add(addt.getText());
                                    shops.get(ii).p.get(iii).products.add(addt.getText());
                                    addt.setText("");
                                });
                                remove.setOnMouseClicked(event4 -> {
                                    listView.getItems().remove(listView.getItems().size() - 1);
                                    shops.get(ii).p.get(iii).products.remove(shops.get(ii).p.get(iii).products.size() - 1);
                                });


                                Scene scene1 = new Scene(pane1, 300, 300);
                                scene1.setOnKeyPressed(event4 -> {
                                    if (event4.getCode() == KeyCode.ENTER) {
                                        listView.getItems().add(addt.getText());
                                        shops.get(ii).p.get(iii).products.add(addt.getText());
                                        addt.setText("");
                                    }
                                });
                                Stage stage1 = new Stage();
                                stage1.setScene(scene1);
                                stage1.setTitle("Продукты");
                                stage1.show();
                            }});



                            if(!tog.isSelected()){
                            Pane pane1 = new Pane();
                            System.out.println(shops.get(ii).p.get(shops.get(ii).p.size() - 1).Y + " " + shops.get(ii).p.get(shops.get(ii).p.size() - 1).X);
                            TextField addt = new TextField("");
                            Button add = new Button("Добавить"), remove = new Button("-");
                            addt.setLayoutX(25);
                            addt.setLayoutY(250);
                            add.setLayoutX(185);
                            add.setLayoutY(250);
                            remove.setLayoutX(250);
                            remove.setLayoutY(250);
                            pane1.getChildren().add(addt);
                            pane1.getChildren().add(add);
                            pane1.getChildren().add(remove);
                            ListView<String> listView = new ListView();
                            listView.setLayoutX(25);
                            listView.setLayoutY(25);
                            listView.setPrefHeight(160);
                            pane1.getChildren().add(listView);
                            add.setOnMouseClicked(event3 -> {
                                listView.getItems().add(addt.getText());
                                shops.get(ii).p.get(shops.get(ii).p.size() - 1).products.add(addt.getText());
                                addt.setText("");
                            });
                            remove.setOnMouseClicked(event3 -> {
                                listView.getItems().remove(listView.getItems().size() - 1);
                                shops.get(ii).p.get(shops.get(ii).p.size() - 1).products.remove(shops.get(ii).p.get(shops.get(ii).p.size() - 1).products.size() - 1);
                            });


                            Scene scene1 = new Scene(pane1, 300, 300);
                            scene1.setOnKeyPressed(event3 -> {
                                if (event3.getCode() == KeyCode.ENTER) {
                                    listView.getItems().add(addt.getText());
                                    shops.get(ii).p.get(shops.get(ii).p.size() - 1).products.add(addt.getText());
                                    addt.setText("");
                                }
                            });
                            Stage stage1 = new Stage();
                            stage1.setScene(scene1);
                            stage1.setTitle("Продукты");
                            stage1.show();
                        }
                        });





                        canvas.setOnMouseDragged(event2 ->{

                            ImageView im = new ImageView("/sample/prilavok.jpg");
                            double rr = Double.parseDouble(rotate1.getText()), hh = Double.parseDouble(h.getText()), ww = Double.parseDouble(w.getText());
                            im.setLayoutX(event2.getX() - ww / 2 + 200);
                            im.setLayoutY(event2.getY() - hh / 2);
                            im.setRotate(rr);

                            im.setFitHeight(hh);
                            im.setFitWidth(ww);
                            if(event2.getX()-ww/2>0&&event2.getX()+ww/2<500&&event2.getY()-hh/2>0&event2.getY()+hh/2<500){
                                shops.get(ii).shopPaneEdit.getChildren().remove(shops.get(ii).shopPaneEdit.getChildren().size() - 1);
                                shops.get(ii).shopPaneEdit.getChildren().add(im);
                            }
                        });


                        deleteLast.setOnMouseClicked(event2 -> {
                            if(shops.get(ii).p.size()>0){
                                shops.get(ii).shopPaneEdit.getChildren().remove(shops.get(ii).shopPaneEdit.getChildren().size()-1);
                                shops.get(ii).p.remove(shops.get(ii).p.size()-1);
                            }
                        });

                        stage.setScene(shops.get(ii).shopSceneEdit);
                        stage.setTitle(shops.get(ii).shopName);
                        stage.show();
                        stage2.close();
                    }else{
                        l1.setText("Ваш пароль неверный, введите ещё раз");
                    }
                });



            });
            pane2.getChildren().add(buttons[i]);
            pane2.getChildren().add(deleteButtons[i]);

        }
        Scene sc=new Scene(pane2,400,400);
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Создание");
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    @FXML
    public void handleButtonAction(){

    }
    @FXML
    public void logAndPas() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("registerNewShop.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Карта магазинов");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }
    @FXML
    private Button obnova;
    public void obnova() throws Exception{
        Stage stage = (Stage) obnova.getScene().getWindow();
        stage.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("CreateShopList.fxml"));
    }

    @FXML
    public void save(){
        String text = new String();
        text=text+ shops.size()+" ";
        for(int i=0;i<shops.size();i++) {
            text = text + shops.get(i).shopName+ " "+shops.get(i).password+" " + shops.get(i).p.size()+" ";
            for(int j=0;j<shops.get(i).p.size();j++){
                text=text+shops.get(i).p.get(j).X+" "+shops.get(i).p.get(j).Y+" "+shops.get(i).p.get(j).width+" "+shops.get(i).p.get(j).height+" "+shops.get(i).p.get(j).rotate+" "+shops.get(i).p.get(j).products.size()+" ";
                for(int q=0;q<shops.get(i).p.get(j).products.size();q++){
                    text=text+ shops.get(i).p.get(j).products.get(q)+" ";
                }
            }
        }
        char[] chars = text.toCharArray();
        FileOutputStream stream=null;
        try(FileWriter writer=new FileWriter("file.txt")) {
        for (char eachChar: chars){
            writer.write(eachChar);
        }

        }catch (IOException exceprion){
            System.out.println("error");
        }
    }


    @FXML
    public void load() throws Exception{

    }

}