package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static sample.Const.shoplength;
import static sample.Const.shops;


public class Main extends Application {


    @Override

    public void start(Stage stage) throws IOException{
        shops=new ArrayList();
        shoplength=0;

        List<Character> charsL= new ArrayList();
        try(FileReader reader= new FileReader("file.txt")){
        int symbol;
        while((symbol = reader.read())!=-1){
            charsL.add((char) symbol);
        }
        }catch (IOException exception) {
            System.out.println("error");
        }
        char[] chars=new char[charsL.size()];
        for(int i=0;i<charsL.size();i++){
            chars[i]=charsL.get(i);
        }

        String[] words=String.valueOf(chars).split(" ");


        if(String.valueOf(chars).compareTo("0")!=0&&String.valueOf(chars).compareTo("")!=0) {
            int lengthSh = Integer.parseInt(words[0]);
            int k=1;
            for (int ii = 0; ii < lengthSh; ii++) {

                shops.add(new Shop(words[k], words[k+1]));
                k=k+2;
                shoplength++;
                int lengthPr = Integer.parseInt(words[k]);
                k++;
                for (int i = 0; i < lengthPr; i++) {
                    double x = Double.parseDouble(words[k]);
                    double y = Double.parseDouble(words[k + 1]);
                    double width = Double.parseDouble(words[k + 2]);
                    double height = Double.parseDouble(words[k + 3]);
                    double rotate = Double.parseDouble(words[k + 4]);
                    shops.get(ii).p.add(new prilavok(rotate, height, width));
                    shops.get(ii).p.get(shops.get(ii).p.size() - 1).X = x;
                    shops.get(ii).p.get(shops.get(ii).p.size() - 1).Y = y;
                    ImageView im = new ImageView("/sample/prilavok.jpg");
                    im.setFitHeight(height);
                    im.setFitWidth(width);
                    im.setRotate(rotate);
                    im.setLayoutX(x + 200+width/2);
                    im.setLayoutY(y+height/2);
                    shops.get(ii).shopPaneEdit.getChildren().add(im);


                    k = k + 5;
                    int lengthP = Integer.parseInt(words[k]);
                    for (int j = 0; j < lengthP; j++) {
                        shops.get(ii).p.get(shops.get(ii).p.size() - 1).products.add(words[k + 1]);
                        k++;
                    }
                    k++;
                }
            }
        }
        //////////////////////////////////////////////////
        Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
        stage.setTitle("Карта магазинов");
        stage.setScene(new Scene(root, 300, 275));
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
