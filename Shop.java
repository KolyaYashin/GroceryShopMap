package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    public String shopName;
    public Pane shopPane;
    public Pane shopPaneEdit;
    public String password;
    public Scene shopScene;
    public Scene shopSceneEdit;
    public List<prilavok> p=new ArrayList();
    public Shop(String _name,String _password){
        shopName=_name;
        shopPane= new Pane();
        password=_password;
        shopPaneEdit=new Pane();





        shopScene=new Scene(shopPane,500,500);
        shopSceneEdit=new Scene(shopPaneEdit,700,500);
    }
    public void save(){
        this.shopPane=this.shopPaneEdit;
    }

}

