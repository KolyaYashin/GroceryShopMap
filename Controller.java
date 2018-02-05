package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class Controller {
    @FXML
    private Button create;
    @FXML
    private Button find;

    @FXML
    public void createShop() throws Exception{
        Parent root2 = FXMLLoader.load(getClass().getResource("CreateShopList.fxml"));


    }

    @FXML
    public void show() throws Exception{
            Parent root2 = FXMLLoader.load(getClass().getResource("list.fxml"));

    }

}
