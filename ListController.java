package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static sample.Const.*;

public class ListController {
    @FXML
    private AnchorPane pane;

    Button[] buttons= new Button[shoplength];
    @FXML
    public void initialize() throws Exception{


        int y=20;

        for(int i=0;i<shoplength;i++) {
            buttons[i] = new Button(shops.get(i).shopName);
            buttons[i].setLayoutY(y);
            buttons[i].setLayoutX(25);
            y=y+30;
            final int ii=i;
            System.out.println(shops.get(ii).p.size());
            buttons[i].setOnAction(event ->{
                ImageView[] images=new ImageView[shops.get(ii).p.size()];
                Pane pane1=new Pane();
                TextField search=new TextField();
                Button find=new Button("Поиск");
                search.setPrefWidth(400);
                search.setLayoutY(10);search.setLayoutX(10);
                find.setLayoutY(10);find.setLayoutX(425);
                pane1.getChildren().add(search);
                pane1.getChildren().add(find);
                pane1.setOnKeyPressed(event1 -> {
                    if(event1.getCode()== KeyCode.ENTER){
                        for(int iii=0;iii<shops.get(ii).p.size();iii++){
                            Image jj=new Image("/sample/prilavok.jpg");
                            images[iii].setImage(jj);

                        }
                        boolean isHave=false;
                        for(int iii=0;iii<shops.get(ii).p.size();iii++){
                            isHave=false;
                            for(int iiii=0;iiii<shops.get(ii).p.get(iii).products.size();iiii++){
                                if(shops.get(ii).p.get(iii).products.get(iiii).contains(search.getText())) {
                                    isHave=true;
                                    break;
                                }
                            }if(isHave) {
                                Image red = new Image("/sample/redPrilavok.jpg");
                                images[iii].setImage(red);
                            }
                        }
                    }
                });
                find.setOnMouseClicked(event1 -> {
                    for(int iii=0;iii<shops.get(ii).p.size();iii++){
                        Image jj=new Image("/sample/prilavok.jpg");
                        images[iii].setImage(jj);

                    }
                    boolean isHave=false;
                    for(int iii=0;iii<shops.get(ii).p.size();iii++){
                        isHave=false;
                        for(int iiii=0;iiii<shops.get(ii).p.get(iii).products.size();iiii++){
                            if(shops.get(ii).p.get(iii).products.get(iiii).contains(search.getText())) {
                                isHave=true;
                                break;
                            }
                        }if(isHave) {
                            Image red = new Image("/sample/redPrilavok.jpg");
                            images[iii].setImage(red);
                        }
                    }
                });
                Canvas canvas =new Canvas(500,550);
                canvas.setLayoutY(0);
                canvas.setLayoutX(0);
                GraphicsContext gr=canvas.getGraphicsContext2D();
                shops.get(ii).shopPane.getChildren().add(canvas);
                gr.setLineWidth(2);
                gr.strokeLine(0,50,500,50);
                System.out.print("Line Added");

                Scene scene=new Scene(pane1,500,540);
                for(int iii=0;iii<shops.get(ii).p.size();iii++) {
                    int iiii=iii;
                    ImageView im=new ImageView("/sample/prilavok.jpg");
                    im.setLayoutX(shops.get(ii).p.get(iii).X+shops.get(ii).p.get(iii).width/2);
                    im.setLayoutY(shops.get(ii).p.get(iii).Y+50+shops.get(ii).p.get(iii).height/2);
                    im.setFitWidth(shops.get(ii).p.get(iii).width);
                    im.setFitHeight(shops.get(ii).p.get(iii).height);
                    im.setRotate(shops.get(ii).p.get(iii).rotate);


                    shops.get(ii).shopPane.getChildren().add(im);
                    pane1.getChildren().add(im);
                    im.setOnMousePressed(event1 -> {
                        Stage stage=new Stage();
                        Pane pane2=new Pane();


                        ListView<String> listView=new ListView();
                        listView.setPrefHeight(200);

                        listView.setLayoutX(25);
                        listView.setPrefWidth(150);
                        for(int j=0;j<shops.get(ii).p.get(iiii).products.size();j++){
                            listView.getItems().add(shops.get(ii).p.get(iiii).products.get(j));
                        }
                        pane2.getChildren().add(listView);

                        Scene scene1=new Scene(pane2,200,200);
                        stage.setTitle("Продукты");
                        stage.setScene(scene1);
                        stage.show();
                    });
                    images[iii]=im;
                }
                Stage stage=new Stage();
                stage.setScene(scene);
                stage.setTitle(shops.get(ii).shopName);
                stage.show();
            });
            pane.getChildren().add(buttons[i]);

        }
        Scene sc=new Scene(pane,400,400);
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Магазины");
        primaryStage.setScene(sc);
        primaryStage.show();
    }





    @FXML
    private Button obnova;
    public void obnova() throws Exception{
        Stage stage = (Stage) obnova.getScene().getWindow();
        stage.close();
        Parent root2 = FXMLLoader.load(getClass().getResource("list.fxml"));
    }


public void handleButtonAction(){}

 //               public void handleButtonAction(MouseEvent event) throws Exception {
   //                 System.out.println("ok");
     //               Stage stageGlobal = (Stage) ((Button) event.getSource()).getScene().getWindow();
       //             Parent root;
         //           if (event.getSource() == buttons[0]) {
           //             root = FXMLLoader.load(getClass().getResource(shops.get(0).shopName + ".fxml"));
             //           System.out.println(shops.get(0).shopName + ".fxml");
               //     } else {
                 //       root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                   // }
                    //Scene scene = new Scene(root);
                    //stage.setScene(scene);
                    //stage.show();
                //}

}
