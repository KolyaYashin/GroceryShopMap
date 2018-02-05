package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

import static sample.Const.shoplength;
import static sample.Const.shops;
import static sample.CreateShopListController.shopsK;

public class registerController {
    @FXML
    private PasswordField pas;
    @FXML
    private PasswordField pas2;
    @FXML
    private TextField name;
    @FXML
    private Label error;
    public void register()  throws Exception{
        String password = pas.getText();
        String password2=pas2.getText();
        if(password.compareTo(password2)==0){

            shops.add(new Shop(name.getText(),password));
            error.setText("Магазин успешно создан");
            shopsK++;
            shoplength+=1;
            Thread.sleep(100);
            
            ((Stage) name.getScene().getWindow()).close();
        }else{
            pas.setText("");
            pas2.setText("");
            error.setText("Пароли не совпадают ");

        }

    }

}
